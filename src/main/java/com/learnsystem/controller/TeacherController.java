package com.learnsystem.controller;

import com.learnsystem.bean.Manager;
import com.learnsystem.bean.Teacher;
import com.learnsystem.common.Constant;
import com.learnsystem.common.Result;
import com.learnsystem.service.ManagerService;
import com.learnsystem.service.TeacherService;
import com.learnsystem.utils.MD5Uitls;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/get")
    public Result get(@RequestParam("id") String id) {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        return new Result(Result.HANDLE_SUCCESS, teacherService.get(teacher));
    }
}
