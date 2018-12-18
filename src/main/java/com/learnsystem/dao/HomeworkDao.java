package com.learnsystem.dao;


import com.learnsystem.bean.Homework;
import com.learnsystem.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface HomeworkDao {
    /**
     * 添加新作业
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
    public int delete(@Param("id") int id);

    /**
     * 修改作业
     *
     * @param homework
     * @return
     */
    public int update(Homework homework);

    /**
     * 根据id获取作业
     *
     * @param id
     * @return
     */
    public Homework getById(@Param("id") int id);

    /**
     * 获取所有作业
     *
     * @return
     */
    public List<Homework> getAll();

    /**
     * 获取该教师发布的所有作业
     *
     * @param teacherId
     * @return
     */
    public List<Homework> getAllByTeacher(@Param("teacherId") String teacherId);

    /**
     * 学生提交答案
     * @param answer
     * @param opinion
     * @param score
     * @param submitTime
     * @return
     */
    public int answer(@Param("studentId")String studentId,@Param("homeworkId")int homeworkId,@Param("answer")String answer,@Param("opinion")String opinion,@Param("score")float score,@Param("submitTime")Date submitTime);

    /**
     * 教师评分
     * @param studentId
     * @param homeworkId
     * @param opinion
     * @param score
     * @return
     */
    public int score(@Param("studentId")String studentId,@Param("homeworkId")int homeworkId,@Param("opinion")String opinion,@Param("score")float score);

    /**
     * 查重
     * @param homeworkId
     * @param answer
     * @return
     */
    int countAnswer(@Param("homeworkId") int homeworkId, @Param("answer") String answer);

    /**
     * 该学生是否已经提交过了，避免重复提交
     * @param studentId
     * @param homeworkId
     * @return
     */
    int isSubmit(@Param("studentId") String studentId, @Param("homeworkId")int homeworkId);

    /**
     *
     * @param studentId
     * @param homeworkId
     * @return
     */
    int isScored(@Param("studentId") String studentId, @Param("homeworkId")int homeworkId);

    /**
     * 获取学生的答案
     * @param id
     * @param id1
     * @return
     */
    String getAnswer(@Param("studentId") String studentId, @Param("homeworkId")int homeworkId);

    /**
     * 获取已经提交过作业的学生列表
     * @param homeworkId
     * @return
     */
    List<Student> getSubmitedStudent(@Param("homeworkId")int homeworkId);
}
