package com.learnsystem.service;

import com.learnsystem.bean.Article;
import com.learnsystem.bean.Homework;
import com.learnsystem.bean.Student;
import com.learnsystem.common.Result;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 学生提交作业
     * @param student
     * @param homework
     */
    public Result answer(Student student, Homework homework, String answer);

    /**
     * 教师评分
     * @param student
     * @param homework
     * @param opinion
     * @param score
     */
    public void score(Student student,Homework homework,String opinion,float score);

    /**
     * 该学生是否已经提交过了，避免重复提交
     * @param student
     * @param homework
     * @return
     */
    public boolean isSubmit(Student student,Homework homework);

    /**
     * 是否已批改
     * @param student
     * @param homework
     * @return
     */
    public boolean isScored(Student student, Homework homework);

    /**
     * 获取该学生在该题的答案
     * @param student
     * @param homework
     * @return
     */
    String getAnswer(Student student, Homework homework);
}
