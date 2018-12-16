package com.learnsystem.service;

import com.learnsystem.bean.Manager;
import com.learnsystem.bean.User;

import java.util.List;

public interface ManagerService {
    public int add(Manager manager);
    public int delete(String id);
    public int update(Manager manager);
    public List<Manager> get(Manager manager);

    /**
     * 为用户赋予角色
     * @param userId
     * @param roleIdList
     */
    public void updateRoles(String userId, List<Integer> roleIdList);
}
