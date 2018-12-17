package com.learnsystem.bean;

import java.util.Date;
import java.util.List;

/**
 * 课程章节
 */
public class Article {
    private int id;
    /**
     * 顺序
     */
    private int sort;
    /**
     * 标题
     */
    private String title;
    /**
     * 章节内容（文字）
     */
    private String textContent;
    /**
     * 附件列表（图片、视频等资料）
     */
    private List<Attachment> attachments;
    /**
     * 所属教师
     */
    private String teacherId;
    private String teacherName;
    /**
     * 创建时间
     */
    private Date createTime;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", sort=" + sort +
                ", title='" + title + '\'' +
                ", textContent='" + textContent + '\'' +
                ", attachments=" + attachments +
                ", teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
