package com.learnsystem.service;

import com.learnsystem.bean.Article;
import com.learnsystem.bean.Privilege;
import com.learnsystem.bean.Role;

import java.util.List;

public interface ArticleService {
    /**
     * 添加章节，顺便添加附件
     *
     * @param article
     * @return
     */
    public int add(Article article);

    /**
     * 删除章节（先删除附件）
     *
     * @param id
     * @return
     */
    public int delete(int id);

    public int update(Article article);

    /**
     * 根据章节id获取章节
     *
     * @param id
     * @return
     */
    public Article getById(int id);

    /**
     * 获取某个教师所有章节
     *
     * @param teacherId
     * @return
     */
    public List<Article> getAllByTeacher(String teacherId);

    public List<Article> getAll();
}
