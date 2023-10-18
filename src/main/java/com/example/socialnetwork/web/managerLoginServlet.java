package com.example.socialnetwork.web;

import com.example.socialnetwork.service.ManagerService;
import com.example.socialnetwork.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "managerLoginServlet", value = "/managerLoginServlet")
public class managerLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //Manager manager=new Manager();
        String magname=request.getParameter("managername");
        String magpassword=request.getParameter("password");

        ManagerService managerService=new ManagerServiceImpl();
        boolean flag=managerService.login(magname,magpassword);


        PrintWriter out = response.getWriter();
        if(flag){
            out.println("<script>");
            out.println("window.location.href='management.html';");
            out.println("</script>");
        }else{
            out.println("<script>");
            out.println("alert('登录失败');");
            out.println("window.location.href='login.html';");
            out.println("</script>");
        }
    }
}
