package com.learnsystem.controller;

import com.learnsystem.bean.Manager;
import com.learnsystem.bean.Student;
import com.learnsystem.bean.Teacher;
import com.learnsystem.common.Constant;
import com.learnsystem.common.Result;
import com.learnsystem.service.ManagerService;
import com.learnsystem.service.TeacherService;
import com.learnsystem.utils.MD5Uitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController()
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        Teacher teacher = new Teacher();
        teacher.setUsername(username);
        teacher.setPassword(MD5Uitls.md5(password));
        List<Teacher> list = teacherService.get(teacher);
        if(list!=null&&list.size()==1){
            teacher = list.get(0);
            request.getSession().setAttribute(Constant.SESSION_LOGIN_TEACHER,teacher);
            return new Result(Result.LOGIN_SUCCESS, "登录成功");
        }else{
            return new Result(Result.LOGIN_FAIL,"用户名或密码错误");
        }
    }

    @RequestMapping("/logout")
    public Result login(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.SESSION_LOGIN_TEACHER);
        return new Result(Result.HANDLE_SUCCESS, "退出成功");
    }

    @RequestMapping("/get")
    public Result get(@RequestParam("id")String id) {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher = teacherService.get(teacher).get(0);
        teacher.setPassword(null);
        return new Result(Result.HANDLE_SUCCESS, teacher);
    }

    @RequestMapping("/getAll")
    public Result getAll() {
        List<Teacher> teachers = teacherService.get(new Teacher());
        for (Teacher teacher:teachers){
            teacher.setPassword(null);
        }
        return new Result(Result.HANDLE_SUCCESS, teachers);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Teacher teacher) {
        if(teacher.getPassword()!=null&&!teacher.getPassword().trim().equals("")){
            teacher.setPassword(MD5Uitls.md5(teacher.getPassword()));
        }
        teacherService.update(teacher);
        return new Result(Result.HANDLE_SUCCESS, "更新成功");
    }
}
