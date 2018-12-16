package com.learnsystem.service;

import com.learnsystem.bean.Privilege;
import com.learnsystem.bean.Role;

import java.util.List;

public interface RoleService {
    public int add(Role role);

    /**
     * 删除角色（先删除用户-角色关系和角色-权限关系）
     * @param id
     * @return
     */
    public int delete(int id);
    public int update(Role role);
    public List<Role> get(Role role);

    /**
     * 获取该角色所有权限
     * @param role
     * @return
     */
    public List<Privilege> getPrivileges(Role role);
}
