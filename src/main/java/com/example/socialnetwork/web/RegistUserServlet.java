package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Edu_work;
import com.example.socialnetwork.domain.User;
import com.example.socialnetwork.service.UserService;
import com.example.socialnetwork.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/registUserServlet")
public class RegistUserServlet extends HttpServlet {
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
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setTelephone(request.getParameter("telephone"));
        user.setGender(request.getParameter("gender"));
        user.setBirthday(request.getParameter("birthday"));
        user.setProvince(request.getParameter("input_province"));
        user.setCity(request.getParameter("input_city"));

        Edu_work edu_work = new Edu_work(request.getParameter("username"), null, null, null, null, null, null, null, null, null);


        UserService userService = new UserServiceImpl();
        boolean flag = userService.regist(user);
        boolean flag_1 = userService.regist_1(edu_work);
        System.out.println(flag_1);
        System.out.println(flag);
        PrintWriter out = response.getWriter();
        if (flag && flag_1){
            out.println("<script>");
            out.println("alert('注册成功');");
            out.println("window.location.href='login.html';");
            out.println("</script>");
        }
        else {
            out.println("<script>");
            out.println("alert('注册失败');");
            out.println("window.location.href='register.html';");
            out.println("</script>");
        }
    }
}
