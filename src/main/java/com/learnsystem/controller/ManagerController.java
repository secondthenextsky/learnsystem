package com.learnsystem.controller;

import com.learnsystem.bean.Manager;
import com.learnsystem.bean.Student;
import com.learnsystem.common.Constant;
import com.learnsystem.common.Result;
import com.learnsystem.service.ManagerService;
import com.learnsystem.utils.MD5Uitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController()
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(MD5Uitls.md5(password));
        List<Manager> list = managerService.get(manager);
        if(list!=null&&list.size()==1){
            manager = list.get(0);
            request.getSession().setAttribute(Constant.SESSION_LOGIN_MANAGER,manager);
            return new Result(Result.LOGIN_SUCCESS, "登录成功");
        }else{
            return new Result(Result.LOGIN_FAIL,"用户名或密码错误");
        }
    }

    @RequestMapping("/get")
    public Result get(@RequestParam("id") int id) {
        Manager manager = new Manager();
        manager.setId(id);
        return new Result(Result.HANDLE_SUCCESS, managerService.get(manager));
    }
}
