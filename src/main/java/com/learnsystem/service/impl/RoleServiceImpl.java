package com.learnsystem.service.impl;

import com.learnsystem.bean.Privilege;
import com.learnsystem.bean.Role;
import com.learnsystem.dao.RoleDao;
import com.learnsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public int add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public int delete(int id) {
        return roleDao.delete(id);
    }

    @Override
    public int update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public List<Role> get(Role role) {
        return roleDao.get(role);
    }

    @Override
    public List<Privilege> getPrivileges(Role role) {
        return roleDao.getPrivileges(role);
    }
}
