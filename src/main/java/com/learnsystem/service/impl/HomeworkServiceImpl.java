package com.learnsystem.service.impl;

import com.learnsystem.bean.Homework;
import com.learnsystem.dao.HomeworkDao;
import com.learnsystem.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkDao homeworkDao;
    @Override
    public int add(Homework homework) {
        return homeworkDao.add(homework);
    }

    @Override
    public int delete(int id) {
        return homeworkDao.delete(id);
    }

    @Override
    public int update(Homework homework) {
        return homeworkDao.update(homework);
    }

    @Override
    public Homework getById(int id) {
        return homeworkDao.getById(id);
    }

    @Override
    public List<Homework> getAllByTeacher(String teacherId) {
        return homeworkDao.getAllByTeacher(teacherId);
    }

    @Override
    public List<Homework> getAll() {
        return homeworkDao.getAll();
    }
}
