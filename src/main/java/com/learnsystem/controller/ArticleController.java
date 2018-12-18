package com.learnsystem.controller;

import com.learnsystem.bean.Article;
import com.learnsystem.bean.Attachment;
import com.learnsystem.bean.Teacher;
import com.learnsystem.common.Constant;
import com.learnsystem.common.Result;
import com.learnsystem.dao.AttachmentDao;
import com.learnsystem.service.ArticleService;
import com.learnsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private AttachmentDao attachmentDao;
    @Value("${filePath}")
    private String filePath;

    /**
     * 新增章节
     * @param article
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestParam("title")String title,@RequestParam("textContent")String textContent, HttpServletRequest request) {
        Article article = new Article();
        article.setTitle(title);
        article.setTextContent(textContent);
        article.setCreateTime(new Date());
        Teacher teacher = (Teacher) request.getSession().getAttribute(Constant.SESSION_LOGIN_TEACHER);
        article.setTeacherId(teacher.getId());
        article.setTeacherName(teacher.getUsername());
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");
        //保存文件
        File path = new File(filePath);
        if(!path.exists()){
            path.mkdirs();
        }
        if(files!=null&&files.size()>0){
            for(MultipartFile multipartFile:files){
                File file = new File(filePath+File.separator+System.currentTimeMillis()+multipartFile.getOriginalFilename());
                List<Attachment> attachments = article.getAttachments();
                if(attachments==null){
                    attachments = new ArrayList<>();
                    article.setAttachments(attachments);
                }
                Attachment attachment = new Attachment();
                attachment.setFileName(file.getName());
                attachments.add(attachment);
                try(FileOutputStream fos = new FileOutputStream(file);){
                    InputStream inputStream = multipartFile.getInputStream();
                    int len = 0;
                    byte[] b = new byte[1024];
                    while((len=inputStream.read(b))>0){
                        fos.write(b,0,len);
                    }
                    fos.flush();
                    fos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        articleService.add(article);
        return new Result(Result.HANDLE_SUCCESS,"创建成功");
    }

    @RequestMapping("/update")
    public Result update(@RequestParam("id")int id,@RequestParam("title")String title,@RequestParam("textContent")String textContent, HttpServletRequest request) {
        Article article = new Article();
        article.setTitle(title);
        article.setTextContent(textContent);
        article.setId(id);
        Teacher teacher = (Teacher) request.getSession().getAttribute(Constant.SESSION_LOGIN_TEACHER);
        article.setTeacherId(teacher.getId());
        article.setTeacherName(teacher.getUsername());
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");
        //保存文件
        File path = new File(filePath);
        if(!path.exists()){
            path.mkdirs();
        }
        if(files!=null&&files.size()>0){
            for(MultipartFile multipartFile:files){
                if(multipartFile.isEmpty()){
                    continue;
                }
                File file = new File(filePath+File.separator+System.currentTimeMillis()+multipartFile.getOriginalFilename());
                List<Attachment> attachments = article.getAttachments();
                if(attachments==null){
                    attachments = new ArrayList<>();
                    article.setAttachments(attachments);
                }
                Attachment attachment = new Attachment();
                attachment.setFileName(file.getName());
                attachments.add(attachment);
                try(FileOutputStream fos = new FileOutputStream(file);){
                    InputStream inputStream = multipartFile.getInputStream();
                    int len = 0;
                    byte[] b = new byte[1024];
                    while((len=inputStream.read(b))>0){
                        fos.write(b,0,len);
                    }
                    fos.flush();
                    fos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        articleService.update(article);
        return new Result(Result.HANDLE_SUCCESS,"修改成功");
    }

    /**
     * 获取当前登录的教师所发布的所有章节
     * @param request
     * @return
     */
    @RequestMapping("/getAllByLoginTeacher")
    public Result getAllByLoginTeacher(HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute(Constant.SESSION_LOGIN_TEACHER);
        List<Article> articles = articleService.getAllByTeacher(teacher.getId());
        return new Result(Result.HANDLE_SUCCESS,articles);
    }

    /**
     * 获取所有教师发布的所有章节
     * @param request
     * @return
     */
    @RequestMapping("/getAll")
    public Result getAll(HttpServletRequest request){
        List<Article> articles = articleService.getAll();
        return new Result(Result.HANDLE_SUCCESS,articles);
    }

    @RequestMapping("/get")
    public Result get(@RequestParam("articleId")int articleId){
        Article article = articleService.getById(articleId);
        return new Result(Result.HANDLE_SUCCESS,article);
    }
    @RequestMapping("/getAttachment")
    public void getAttachment(@RequestParam("id")int id, HttpServletResponse response){
        Attachment attachment = attachmentDao.getById(id);
        InputStream in = null;
        OutputStream out = null;
        try {
            File file = new File(filePath+File.separator+attachment.getFileName());
            response.reset();
            response.setContentType("application/octet-stream;charset=UTF-8");// 设置下载文件的类型
            response.setHeader("content-disposition","attachment;filename=" + URLEncoder.encode(attachment.getFileName(), "UTF-8"));
            long fileLength = file.length();
            String length = String.valueOf(fileLength);
            response.setHeader("Content_Length", length);
            out = response.getOutputStream();
            in = new FileInputStream(file);
            byte[] buffer = new byte[1024*10];
            int ins = in.read(buffer);
            while (ins != -1) {
                out.write(buffer, 0, ins);
                ins = in.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e1) {
                in = null;
                out = null;
            }
        }
    }

}
