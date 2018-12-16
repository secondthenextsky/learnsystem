package com.learnsystem.service.impl;

import com.learnsystem.bean.Manager;
import com.learnsystem.bean.Student;
import com.learnsystem.bean.User;
import com.learnsystem.dao.ManagerDao;
import com.learnsystem.dao.RoleDao;
import com.learnsystem.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public int add(Manager manager) {
        return managerDao.add(manager);
    }

    @Override
    public int delete(String id) {
        return managerDao.delete(id);
    }

    @Override
    public int update(Manager manager) {
        return managerDao.update(manager);
    }

    @Override
    public List<Manager> get(Manager manager) {
        return managerDao.get(manager);
    }

    @Transactional
    @Override
    public void updateRoles(String userId, List<Integer> roleIdList) {
        if(roleIdList!=null&&roleIdList.size()>0){
            for(Integer roleId:roleIdList){
                roleDao.addUserRoles(userId,roleId);
            }
        }
    }
}
