package com.learnsystem.service;

import com.learnsystem.bean.Student;

import java.util.List;

public interface StudentService {
    public int add(Student student);
    public int delete(String id);
    public int update(Student student);
    public List<Student> get(Student student);
}
