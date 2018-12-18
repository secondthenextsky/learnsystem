package com.learnsystem.controller;

import com.learnsystem.bean.Homework;
import com.learnsystem.bean.Student;
import com.learnsystem.bean.Teacher;
import com.learnsystem.common.Constant;
import com.learnsystem.common.Result;
import com.learnsystem.service.HomeworkService;
import com.learnsystem.service.StudentService;
import com.learnsystem.service.TeacherService;
import com.learnsystem.utils.LoginNeed;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/homework")
public class HomeworkController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private StudentService studentService;


    /**
     * 新增作业
     */
    @LoginNeed
    @RequestMapping("/add")
    public Result add(@RequestParam("content") String content, @RequestParam("endTime") String endTime, HttpServletRequest request) {
        Homework homework = new Homework();
        homework.setContent(content);
        homework.setBeginTime(new Date());
        try {
            homework.setEndTime(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Teacher teacher = (Teacher) request.getSession().getAttribute(Constant.SESSION_LOGIN_TEACHER);
        homework.setTeacherId(teacher.getId());
        homework.setTeacherName(teacher.getUsername());

        homeworkService.add(homework);
        return new Result(Result.HANDLE_SUCCESS, "创建成功");
    }

    @LoginNeed
    @RequestMapping("/update")
    public Result update(@RequestParam("id") int id, @RequestParam("sort") int sort, @RequestParam("content") String content, @RequestParam("endTime") String endTime, HttpServletRequest request) {
        Homework homework = new Homework();
        homework.setId(id);
        homework.setSort(sort);
        try {
            homework.setEndTime(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        homework.setContent(content);
        Teacher teacher = (Teacher) request.getSession().getAttribute(Constant.SESSION_LOGIN_TEACHER);
        homework.setTeacherId(teacher.getId());
        homework.setTeacherName(teacher.getUsername());
        homeworkService.update(homework);
        return new Result(Result.HANDLE_SUCCESS, "修改成功");
    }

    /**
     * 获取当前登录的教师所发布的所有作业
     *
     * @param request
     * @return
     */
    @LoginNeed
    @RequestMapping("/getAllByLoginTeacher")
    public Result getAllByLoginTeacher(HttpServletRequest request) {
        Teacher teacher = (Teacher) request.getSession().getAttribute(Constant.SESSION_LOGIN_TEACHER);
        List<Homework> homeworks = homeworkService.getAllByTeacher(teacher.getId());
        return new Result(Result.HANDLE_SUCCESS, homeworks);
    }

    /**
     * 获取所有教师发布的所有章节
     *
     * @param request
     * @return
     */
    @LoginNeed
    @RequestMapping("/getAll")
    public Result getAll(HttpServletRequest request) {
        List<Homework> homeworks = homeworkService.getAll();
        Student student = (Student)request.getSession().getAttribute(Constant.SESSION_LOGIN_STUDENT);
        if(student!=null){
            //学生登录了，则给homework加状态信息
            if(homeworks!=null&&homeworks.size()>0){
                for(Homework homework:homeworks){
                    if(!homeworkService.isSubmit(student,homework)){
                        homework.setStatus("未提交");
                    }else {
                        //已提交
                        homework.setStatus("已提交");
                        //已批改
                        if(homeworkService.isScored(student,homework)){
                            homework.setStatus("已批改");
                        }
                    }
                }
            }
        }
        return new Result(Result.HANDLE_SUCCESS, homeworks);
    }

    @LoginNeed
    @RequestMapping("/get")
    public Result get(@RequestParam("homeworkId") int homeworkId,HttpServletRequest request) {
        Homework homework = homeworkService.getById(homeworkId);
        Student student = (Student)request.getSession().getAttribute(Constant.SESSION_LOGIN_STUDENT);
        Result result = new Result(Result.HANDLE_SUCCESS,homework);
        if(student!=null){
            //如果是学生查询自己的作业，则给出答案以及老师评分
            Map<Object,Object> map = homeworkService.getAnswer(student,homework);
            if(map!=null){
                result.put("answer",map.get("answer"));
                result.put("opinion",map.get("opinion"));
                result.put("score",map.get("score"));
            }

        }
        return result;
    }

    @LoginNeed
    @RequestMapping("/getHomeworkAndStudent")
    public Result getHomeworkAndStudent(@RequestParam("homeworkId") int homeworkId,@RequestParam("studentId")String studentId,HttpServletRequest request) {
        Homework homework = homeworkService.getById(homeworkId);
        Student student = new Student();
        student.setId(studentId);
        student = studentService.get(student).get(0);
        Result result = new Result(Result.HANDLE_SUCCESS,homework);
        if(student!=null){
            result.put("answer",homeworkService.getAnswer(student,homework));
            result.put("student",student);
        }
        return result;
    }

    /**
     * 获取课程详情以及已经提交的学生列表
     * @param homeworkId
     * @param request
     * @return
     */
    @LoginNeed
    @RequestMapping("/getHomeworkAndStudentList")
    public Result getHomeworkAndStudentList(@RequestParam("homeworkId") int homeworkId,HttpServletRequest request) {
        Homework homework = homeworkService.getById(homeworkId);
        Result result = new Result(Result.HANDLE_SUCCESS,homework);
        List<Student> students = homeworkService.getSubmitedStudent(homeworkId);
        if(students!=null&&students.size()>0){
            result.put("students",students);
        }
        return result;
    }

    @LoginNeed
    @RequestMapping("/delete")
    public Result delete(@RequestParam("homeworkId") int homeworkId) {
        homeworkService.delete(homeworkId);
        return new Result(Result.HANDLE_SUCCESS, "删除成功");
    }

    /**
     * 提交作业答案
     *
     * @param homeworkId
     * @param answer
     * @param request
     * @return
     */
    @LoginNeed
    @RequestMapping("/answer")
    public Result answer(@Param("homeworkId") int homeworkId, @RequestParam("answer") String answer, HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(Constant.SESSION_LOGIN_STUDENT);
        Homework homework = homeworkService.getById(homeworkId);
        return homeworkService.answer(student, homework, answer);
    }

    /**
     * 批改作业
     */
    @LoginNeed
    @RequestMapping("/score")
    public Result score(@Param("homeworkId") int homeworkId,@Param("studentId") String studentId, @RequestParam("score") float score, @Param("opinion")String opinion, HttpServletRequest request) {
        Teacher teacher = (Teacher) request.getSession().getAttribute(Constant.SESSION_LOGIN_TEACHER);
        Student student = new Student();
        student.setId(studentId);
        student = studentService.get(student).get(0);
        Homework homework = homeworkService.getById(homeworkId);
        homeworkService.score(student,homework,opinion,score);
        return new Result(Result.HANDLE_SUCCESS,"批改成功");
    }
}
