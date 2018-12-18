package com.learnsystem.bean;

import java.util.Date;

/**
 * 作业
 */
public class Homework {
    private int id;
    /**
     * 发布者id
     */
    private String teacherId;
    /**
     * 发布者姓名
     */
    private String teacherName;

    /**
     * 作业内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date beginTime;
    /**
     * 截止提交时间
     */
    private Date endTime;
    /**
     * 顺序
     */
    private int sort;
    /**
     * 状态：未提交，已提交，已批改
     */
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", content='" + content + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", sort=" + sort +
                ", status='" + status + '\'' +
                '}';
    }
}
