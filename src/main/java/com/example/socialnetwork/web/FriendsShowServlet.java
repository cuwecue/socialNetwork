package com.example.socialnetwork.web;

import com.example.socialnetwork.service.FriendsService;
import com.example.socialnetwork.service.impl.FriendsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class FriendsShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");

        HttpSession session = request.getSession();
        FriendsService friendsService = new FriendsServiceImpl();
        List<String> friends = friendsService.showAllFriends(session.getAttribute("username").toString());

        mapper.writeValue(response.getOutputStream(),friends);
    }
}
