package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Blog;
import com.example.socialnetwork.service.BlogService;
import com.example.socialnetwork.service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;

public class PostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        HttpSession session = request.getSession();

        BlogService blogService = new BlogServiceImpl();

        Integer curblog_num = blogService.curPost_num();
        if (curblog_num == null) {
            curblog_num = 0;
        }

        Blog blog = new Blog();
        blog.setBid(curblog_num);
        blog.setUsername(session.getAttribute("username").toString());
        blog.setTitle(request.getParameter("title"));
        blog.setMain_body(request.getParameter("main_body"));
        blog.setPart(request.getParameter("sid"));

        Part filePart = request.getPart("selectFiles");



        // 将文件保存到服务器上的某个目录中
        String fileName = filePart.getSubmittedFileName();
        fileName = fileName.replace(':', '_');
        String saveDirectory = "D:\\web\\小学期课设\\项目工程\\socialnetwork\\src\\main\\webapp\\imgs"; // 注意使用双反斜杠来表示路径分隔符
        File savePath = new File(saveDirectory, fileName);
        try (InputStream is = filePart.getInputStream()) {
            Files.copy(is, savePath.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        String path = "imgs/" + fileName; // 将图片的路径存储在 path 变量中
        System.out.println(path);
        blog.setPicture(path);

        blog.setTime(new Timestamp(System.currentTimeMillis()));

        boolean flag = blogService.Post(blog);
        PrintWriter out = response.getWriter();
        if (flag){
            out.println("<script>");
            out.println("alert('发布成功');");
            out.println("window.location.href='blog_list.jsp';");
            out.println("</script>");
            session.setAttribute("blog_num",curblog_num);
        } else {
            out.println("<script>");
            out.println("alert('发布失败');");
            out.println("window.location.href='blog_edit.html';");
            out.println("</script>");
        }
    }
}

