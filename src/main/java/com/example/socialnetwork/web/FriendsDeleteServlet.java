package com.example.socialnetwork.web;

import com.example.socialnetwork.service.FriendsService;
import com.example.socialnetwork.service.impl.FriendsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/FriendsDeleteServlet")
public class FriendsDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(2);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");

        HttpSession session = request.getSession();
        FriendsService friendsService = new FriendsServiceImpl();
        String username=session.getAttribute("username").toString();
        System.out.println("username "+username);
        String friendname=request.getParameter("friendname");
        System.out.print("friendsname: ");
        System.out.println(friendname);
        boolean result=friendsService.DeleteFriends(username,friendname);
        System.out.println(result);
        mapper.writeValue(response.getOutputStream(),result);
    }
}
