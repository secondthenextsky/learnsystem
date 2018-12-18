package com.learnsystem.controller;

import com.learnsystem.bean.Manager;
import com.learnsystem.bean.Role;
import com.learnsystem.bean.Student;
import com.learnsystem.bean.Teacher;
import com.learnsystem.common.Constant;
import com.learnsystem.common.Result;
import com.learnsystem.dao.TeacherDao;
import com.learnsystem.service.ManagerService;
import com.learnsystem.service.TeacherService;
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
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(MD5Uitls.md5(password));
        List<Manager> list = managerService.get(manager);
        if (list != null && list.size() == 1) {
            manager = list.get(0);
            request.getSession().setAttribute(Constant.SESSION_LOGIN_MANAGER, manager);
            return new Result(Result.LOGIN_SUCCESS, "登录成功");
        } else {
            return new Result(Result.LOGIN_FAIL, "用户名或密码错误");
        }
    }

    @RequestMapping("/logout")
    public Result login(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.SESSION_LOGIN_MANAGER);
        return new Result(Result.HANDLE_SUCCESS, "退出成功");
    }

    @LoginNeed
    @RequestMapping("/updateManager")
    public Result updateManager(@RequestBody Manager manager,HttpServletRequest request) {
        if(manager.getPassword()!=null&&!manager.getPassword().trim().equals("")){
            manager.setPassword(MD5Uitls.md5(manager.getPassword()));
        }
        managerService.update(manager);
        return new Result(Result.HANDLE_SUCCESS, "更新成功");
    }

    //修改当前登录的管理员
    @LoginNeed
    @RequestMapping("/updateLoginManager")
    public Result updateLoginManager(@RequestBody Manager manager,HttpServletRequest request) {
        if(manager.getPassword()!=null&&!manager.getPassword().trim().equals("")){
            manager.setPassword(MD5Uitls.md5(manager.getPassword()));
        }
        managerService.update(manager);
        manager.setPassword(null);
        request.getSession().setAttribute(Constant.SESSION_LOGIN_MANAGER,manager);
        return new Result(Result.HANDLE_SUCCESS, "更新成功");
    }

    @LoginNeed
    @RequestMapping("/updateRole")
    public Result updateRole(String userId, List<Integer> roleIdList) {
        managerService.updateRoles(userId, roleIdList);
        return new Result(Result.HANDLE_SUCCESS, "更新角色成功");
    }

    @LoginNeed
    @RequestMapping("/get")
    public Result get(@RequestParam("id")String id) {
        Manager manager = new Manager();
        manager.setId(id);
        manager = managerService.get(manager).get(0);
        manager.setPassword(null);
        return new Result(Result.HANDLE_SUCCESS, manager);
    }

    @LoginNeed
    @RequestMapping("/getLoginManager")
    public Result getLoginManager(HttpServletRequest request) {
        Object manager = request.getSession().getAttribute(Constant.SESSION_LOGIN_MANAGER);
        return new Result(Result.HANDLE_SUCCESS, manager);
    }

    @LoginNeed
    @RequestMapping("/getAll")
    public Result getAll(){
        List<Manager> managers = managerService.get(new Manager());
        if(managers!=null&&managers.size()>0){
            for (Manager manager:managers){
                manager.setPassword(null);
            }
        }
        return new Result(Result.HANDLE_SUCCESS,managers);
    }

}
