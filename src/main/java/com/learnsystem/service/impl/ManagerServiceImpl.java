package com.learnsystem.service.impl;

import com.learnsystem.bean.Manager;
import com.learnsystem.bean.Student;
import com.learnsystem.dao.ManagerDao;
import com.learnsystem.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

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
}
