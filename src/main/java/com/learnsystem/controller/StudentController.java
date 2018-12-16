package com.learnsystem.controller;

import com.learnsystem.bean.Student;
import com.learnsystem.common.Constant;
import com.learnsystem.common.Result;
import com.learnsystem.service.StudentService;
import com.learnsystem.utils.MD5Uitls;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/get")
    public Result get(@RequestParam("id") String id) {
        Student student = new Student();
        student.setId(id);
        return new Result(Result.HANDLE_SUCCESS, studentService.get(student));
    }
}
