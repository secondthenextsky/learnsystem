package com.learnsystem.service.impl;

import com.learnsystem.bean.Article;
import com.learnsystem.bean.Attachment;
import com.learnsystem.dao.ArticleDao;
import com.learnsystem.dao.AttachmentDao;
import com.learnsystem.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private AttachmentDao attachmentDao;

    @Transactional
    @Override
    public int add(Article article) {
        articleDao.add(article);
        List<Attachment> attachments = article.getAttachments();
        if (attachments != null && attachments.size() > 0) {
            for (Attachment attachment : attachments) {
                attachment.setArticleId(article.getId());
                attachmentDao.add(attachment);
            }
        }
        return 1;
    }

    @Transactional
    @Override
    public int delete(int id) {
        attachmentDao.deleteByArticle(id);
        articleDao.delete(id);
        return 1;
    }

    @Override
    public int update(Article article) {
        articleDao.update(article);
        List<Attachment> attachments = article.getAttachments();
        if (attachments != null && attachments.size() > 0) {
            for (Attachment attachment : attachments) {
                attachment.setArticleId(article.getId());
                attachmentDao.add(attachment);
            }
        }
        return 1;
    }

    @Override
    public Article getById(int id) {
        Article article = articleDao.getById(id);
        article.setAttachments(attachmentDao.getAttachments(id));
        return article;
    }

    @Override
    public List<Article> getAllByTeacher(String teacherId) {
        List<Article> articles = articleDao.getAllByTeacher(teacherId);
        if (articles != null && articles.size() > 0) {
            for (Article article : articles) {
                article.setAttachments(attachmentDao.getAttachments(article.getId()));
            }
        }
        return articles;
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = articleDao.getAll();
        if (articles != null && articles.size() > 0) {
            for (Article article : articles) {
                article.setAttachments(attachmentDao.getAttachments(article.getId()));
            }
        }
        return articles;
    }
}
