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

@WebServlet("/manageDeleteServlet")
public class manageDeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        UserService userService = new UserServiceImpl();
        String username=request.getParameter("username");
        boolean flag=userService.DeleteUsers(username);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),flag);
    }
}
