package com.learnsystem.service;

import com.learnsystem.bean.Teacher;

import java.util.List;

public interface TeacherService {
    public int add(Teacher teacher);
    public int delete(String id);
    public int update(Teacher teacher);
    public List<Teacher> get(Teacher teacher);
}
