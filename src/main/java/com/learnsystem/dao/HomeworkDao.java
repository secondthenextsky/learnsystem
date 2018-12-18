package com.learnsystem.dao;


import com.learnsystem.bean.Homework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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


}
