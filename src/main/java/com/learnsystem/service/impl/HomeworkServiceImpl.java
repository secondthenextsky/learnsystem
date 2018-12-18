package com.learnsystem.service.impl;

import com.learnsystem.bean.Homework;
import com.learnsystem.bean.Student;
import com.learnsystem.common.Result;
import com.learnsystem.dao.HomeworkDao;
import com.learnsystem.service.HomeworkService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public Result answer(Student student, Homework homework, String answer) {
        //是否已经提交过了
        int isSubmit = homeworkDao.isSubmit(student.getId(),homework.getId());
        if(isSubmit>0){
            return new Result(Result.HANDLE_FAIL,"你已经提交过了，请勿重复提交");
        }
        //查重
        int count = homeworkDao.countAnswer(homework.getId(),answer);
        if(count>0){
            return new Result(Result.HANDLE_FAIL,"请勿抄袭");
        }
        //超时检测
        Date now = new Date();
        Date endTime = homework.getEndTime();
        if(now.after(endTime)){
            return new Result(Result.HANDLE_FAIL,"已经过了截止时间，不能提交作业");
        }
        homeworkDao.answer(student.getId(),homework.getId(),answer,"",-1,new Date());
        return new Result(Result.HANDLE_SUCCESS,"提交成功");
    }

    @Override
    public void score(Student student, Homework homework, String opinion, float score) {
        homeworkDao.score(student.getId(),homework.getId(),opinion,score);
    }

    @Override
    public boolean isSubmit(Student student, Homework homework) {
        if(homeworkDao.isSubmit(student.getId(),homework.getId())>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean isScored(Student student, Homework homework) {
        if(homeworkDao.isScored(student.getId(),homework.getId())>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getAnswer(Student student, Homework homework) {
        return homeworkDao.getAnswer(student.getId(),homework.getId());
    }

}
