package com.learnsystem.bean;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 学生
 */
public class Student extends User{


    /**
     * 学院
     */
    private String college;
    /**
     * 专业
     */
    private String major;

    /**
     * 入学时间
     */
    private Date intendtime;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    public Date getIntendtime() {
        return intendtime;
    }

    public void setIntendtime(Date intendtime) {
        this.intendtime = intendtime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", intendtime=" + intendtime +
                '}';
    }
}
