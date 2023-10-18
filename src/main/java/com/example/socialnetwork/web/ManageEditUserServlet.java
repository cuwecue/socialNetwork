package com.example.socialnetwork.web;

import com.example.socialnetwork.service.UserService;
import com.example.socialnetwork.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ManageEditUserServlet", value = "/ManageEditUserServlet")
public class ManageEditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");

        UserService userService = new UserServiceImpl();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String brithday=request.getParameter("birthday");
        String gender=request.getParameter("gender");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        String province=request.getParameter("province");
        String city=request.getParameter("city");
        boolean result=userService.edit(username,password,name,brithday,gender
        ,telephone,email,province,city);
        System.out.println(result);
        mapper.writeValue(response.getOutputStream(),result);
    }
}
