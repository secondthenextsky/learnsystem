package com.learnsystem.service.impl;

import com.learnsystem.bean.Student;
import com.learnsystem.dao.StudentDao;
import com.learnsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public int add(Student student) {
        student.setId(UUID.randomUUID().toString());
        return studentDao.add(student);
    }

    @Override
    public int delete(String id) {
        return studentDao.delete(id);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public List<Student> get(Student student) {
        return studentDao.get(student);
    }
}
