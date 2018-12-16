package com.learnsystem.service.impl;

import com.learnsystem.bean.Privilege;
import com.learnsystem.dao.PrivilegeDao;
import com.learnsystem.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    private PrivilegeDao privilegeDao;

    @Override
    public int add(Privilege privilege) {
        return privilegeDao.add(privilege);
    }

    @Override
    public int delete(int id) {
        return privilegeDao.delete(id);
    }

    @Override
    public int update(Privilege privilege) {
        return privilegeDao.update(privilege);
    }
}
