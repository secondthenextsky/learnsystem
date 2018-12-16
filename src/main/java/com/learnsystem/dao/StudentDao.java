package com.learnsystem.dao;


import com.learnsystem.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StudentDao {
    public int add(Student student);
    public int delete(int id);
    public int update(Student student);
    public List<Student> get(Student student);
}
