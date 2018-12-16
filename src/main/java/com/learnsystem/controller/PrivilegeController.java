package com.learnsystem.controller;

import com.learnsystem.bean.Privilege;
import com.learnsystem.bean.Role;
import com.learnsystem.common.Result;
import com.learnsystem.service.PrivilegeService;
import com.learnsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/privilege")
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;

    @RequestMapping("/add")
    public Result add(@RequestBody Privilege privilege){
        privilegeService.add(privilege);
        return new Result(Result.HANDLE_SUCCESS,"添加角色成功");
    }

    @RequestMapping("/delete")
    public Result delete(@RequestParam("id") int id){
        privilegeService.delete(id);
        return new Result(Result.HANDLE_SUCCESS,"删除角色成功");
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Privilege privilege){
        privilegeService.update(privilege);
        return new Result(Result.HANDLE_SUCCESS,"更新角色成功");
    }

    @RequestMapping("/getAll")
    public Result getAll(){
        return new Result(Result.HANDLE_SUCCESS,privilegeService.get(new Privilege()));
    }

    @RequestMapping("/get")
    public Result get(@RequestParam("id")int id){
        Privilege privilege = new Privilege();
        privilege.setId(id);
        return new Result(Result.HANDLE_SUCCESS,privilegeService.get(new Privilege()));
    }
}
