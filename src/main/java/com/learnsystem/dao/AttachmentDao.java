package com.learnsystem.dao;


import com.learnsystem.bean.Article;
import com.learnsystem.bean.Attachment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttachmentDao {
    /**
     * 新增附件
     *
     * @param attachment
     * @return
     */
    public int add(Attachment attachment);

    /**
     * 删除附件
     *
     * @param id
     * @return
     */
    public int delete(@Param("id") int id);

    /**
     * 删除该章节的所有附件
     *
     * @param articleId
     * @return
     */
    public int deleteByArticle(@Param("articleId") int articleId);

    /**
     * 修改附件
     *
     * @param attachment
     * @return
     */
    public int update(Attachment attachment);

    /**
     * 根据附件id获取附件
     *
     * @param id
     * @return
     */
    public Attachment getById(@Param("id") int id);

    /**
     * 获取章节的附件列表
     *
     * @param articleId
     * @return
     */
    public List<Attachment> getAttachments(@Param("articleId") int articleId);

}
