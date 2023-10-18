package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Edu_work;
import com.example.socialnetwork.domain.User;
import com.example.socialnetwork.service.BlogService;
import com.example.socialnetwork.service.UserService;
import com.example.socialnetwork.service.impl.BlogServiceImpl;
import com.example.socialnetwork.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        HttpSession session = request.getSession();

        UserService userService = new UserServiceImpl();
        Edu_work edu_work  =userService.showinfo(user.getUsername());
        User user_1 = userService.showinfo_1(user.getUsername());

        BlogService blogService = new BlogServiceImpl();
        Integer blog_num = blogService.curPost_num()-1;
        session.setAttribute("blog_num",blog_num);

        session.setAttribute("username",user_1.getUsername());
        session.setAttribute("name",user_1.getName());
        session.setAttribute("birthday",user_1.getBirthday());
        session.setAttribute("gender",user_1.getGender());
        session.setAttribute("telephone",user_1.getTelephone());
        session.setAttribute("email",user_1.getEmail());
        session.setAttribute("province",user_1.getProvince());
        session.setAttribute("city",user_1.getCity());

        session.setAttribute("edu_level",edu_work.getEdu_level());
        session.setAttribute("edu_start",edu_work.getEdu_start());
        session.setAttribute("edu_end",edu_work.getEdu_end());
        session.setAttribute("school",edu_work.getSchool());
        session.setAttribute("degree",edu_work.getDegree());
        session.setAttribute("workplace",edu_work.getWorkplace());
        session.setAttribute("work_start",edu_work.getWork_start());
        session.setAttribute("work_end",edu_work.getWork_end());
        session.setAttribute("job",edu_work.getJob());


        boolean flag = userService.login(user);
        System.out.println(flag);
        PrintWriter out = response.getWriter();
        if (!flag){
            out.println("<script>");
            out.println("alert('登录失败');");
            out.println("window.location.href='login.html';");
            out.println("</script>");
        } else {
            out.println("<script>");
            out.println("window.location.href='blog_list.jsp';");
            out.println("</script>");
        }
    }
}
