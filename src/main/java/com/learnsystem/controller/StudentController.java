package com.learnsystem.controller;

import com.learnsystem.bean.Manager;
import com.learnsystem.bean.Student;
import com.learnsystem.common.Constant;
import com.learnsystem.common.Result;
import com.learnsystem.service.StudentService;
import com.learnsystem.utils.LoginNeed;
import com.learnsystem.utils.MD5Uitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController()
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(MD5Uitls.md5(password));
        List<Student> list = studentService.get(student);
        if(list!=null&&list.size()==1){
            student = list.get(0);
            request.getSession().setAttribute(Constant.SESSION_LOGIN_STUDENT,student);
            return new Result(Result.LOGIN_SUCCESS, "登录成功");
        }else{
            return new Result(Result.LOGIN_FAIL,"用户名或密码错误");
        }
    }

    @RequestMapping("/logout")
    public Result login(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.SESSION_LOGIN_STUDENT);
        return new Result(Result.HANDLE_SUCCESS, "退出成功");
    }

    @LoginNeed
    @RequestMapping("/updateStudent")
    public Result updateStudent(@RequestBody Student student) {
        if(student.getPassword()!=null&&!student.getPassword().trim().equals("")){
            student.setPassword(MD5Uitls.md5(student.getPassword()));
        }
        studentService.update(student);
        return new Result(Result.HANDLE_SUCCESS, "更新成功");
    }

    @LoginNeed
    @RequestMapping("/addStudent")
    public Result addStudent(@RequestBody Student student) {
        if(student.getPassword()!=null&&!student.getPassword().trim().equals("")){
            student.setPassword(MD5Uitls.md5(student.getPassword()));
        }
        studentService.add(student);
        return new Result(Result.HANDLE_SUCCESS, "更新成功");
    }

    @LoginNeed
    @RequestMapping("/get")
    public Result get(@RequestParam("id")String id) {
        Student student = new Student();
        student.setId(id);
        student = studentService.get(student).get(0);
        student.setPassword(null);
        return new Result(Result.HANDLE_SUCCESS, student);
    }

    @LoginNeed
    @RequestMapping("/getAll")
    public Result getAll(){
        List<Student> students = studentService.get(new Student());
        if(students!=null&&students.size()>0){
            for (Student student:students){
                student.setPassword(null);
            }
        }
        return new Result(Result.HANDLE_SUCCESS,students);
    }
}
