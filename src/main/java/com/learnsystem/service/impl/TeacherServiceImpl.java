package com.learnsystem.service.impl;

import com.learnsystem.bean.Manager;
import com.learnsystem.bean.Teacher;
import com.learnsystem.dao.ManagerDao;
import com.learnsystem.dao.RoleDao;
import com.learnsystem.dao.TeacherDao;
import com.learnsystem.service.ManagerService;
import com.learnsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;
    @Override
    public int add(Teacher teacher) {
        return teacherDao.add(teacher);
    }

    @Override
    public int delete(String id) {
        return teacherDao.delete(id);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherDao.update(teacher);
    }

    @Override
    public List<Teacher> get(Teacher teacher) {
        return teacherDao.get(teacher);
    }
}
