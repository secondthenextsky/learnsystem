package com.learnsystem.dao;


import com.learnsystem.bean.Article;
import com.learnsystem.bean.Attachment;
import com.learnsystem.bean.Privilege;
import com.learnsystem.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleDao {
    /**
     * 添加新章节
     *
     * @param article
     * @return
     */
    public int add(Article article);

    /**
     * 删除章节
     *
     * @param id
     * @return
     */
    public int delete(@Param("id") int id);

    /**
     * 修改章节
     *
     * @param article
     * @return
     */
    public int update(Article article);

    /**
     * 根据id获取章节
     *
     * @param id
     * @return
     */
    public Article getById(@Param("id") int id);

    /**
     * 获取所有章节
     *
     * @return
     */
    public List<Article> getAll();

    /**
     * 获取该教师发布的所有章节
     *
     * @param teacherId
     * @return
     */
    public List<Article> getAllByTeacher(@Param("teacherId") String teacherId);

    /**
     * 获取章节的附件列表
     *
     * @param articleId
     * @return
     */
    public List<Attachment> getAttachments(@Param("articleId") int articleId);

}
