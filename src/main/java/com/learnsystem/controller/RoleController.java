package com.learnsystem.controller;

import com.learnsystem.bean.Role;
import com.learnsystem.common.Result;
import com.learnsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/add")
    public Result add(@RequestBody Role role){
        roleService.add(role);
        return new Result(Result.HANDLE_SUCCESS,"添加角色成功");
    }

    @RequestMapping("/delete")
    public Result delete(@RequestParam("id") int id){
        roleService.delete(id);
        return new Result(Result.HANDLE_SUCCESS,"删除角色成功");
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Role role){
        roleService.update(role);
        return new Result(Result.HANDLE_SUCCESS,"更新角色成功");
    }

    @RequestMapping("/getAll")
    public Result getAll(){
        return new Result(Result.HANDLE_SUCCESS,roleService.get(new Role()));
    }

    @RequestMapping("/get")
    public Result get(@RequestParam("id")int id){
        Role role = new Role();
        role.setId(id);
        return new Result(Result.HANDLE_SUCCESS,roleService.get(new Role()));
    }
}
