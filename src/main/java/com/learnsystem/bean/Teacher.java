package com.learnsystem.bean;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 教师
 */
public class Teacher extends User{
    /**
     * 教师管理的学生集合
     */
    private Set<Student> students = new LinkedHashSet<>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "students=" + students +
                '}';
    }
}
