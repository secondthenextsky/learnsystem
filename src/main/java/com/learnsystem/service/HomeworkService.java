package com.learnsystem.service;

import com.learnsystem.bean.Article;
import com.learnsystem.bean.Homework;

import java.util.List;

public interface HomeworkService {
    /**
     * 添加作业
     *
     * @param homework
     * @return
     */
    public int add(Homework homework);

    /**
     * 删除作业
     *
     * @param id
     * @return
     */
    public int delete(int id);

    public int update(Homework homework);

    /**
     * 根据章节id获取作业
     *
     * @param id
     * @return
     */
    public Homework getById(int id);

    /**
     * 获取某个教师所有作业
     *
     * @param teacherId
     * @return
     */
    public List<Homework> getAllByTeacher(String teacherId);

    public List<Homework> getAll();
}
