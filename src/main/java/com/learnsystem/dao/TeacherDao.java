package com.learnsystem.dao;


import com.learnsystem.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherDao {
    public int add(Teacher teacher);
    public int delete(@Param("id") String id);
    public int update(Teacher teacher);
    public List<Teacher> get(Teacher teacher);
}
