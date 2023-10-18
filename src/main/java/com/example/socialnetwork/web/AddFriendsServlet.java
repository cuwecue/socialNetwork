package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Friends;
import com.example.socialnetwork.service.FriendsService;
import com.example.socialnetwork.service.impl.FriendsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AddFriendsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        HttpSession session = request.getSession();
        Friends friends = new Friends();
        FriendsService friendsService = new FriendsServiceImpl();
        friends.setUser_1(session.getAttribute("username").toString());
        friends.setUser_2(request.getParameter("user_2"));
        friends.setFid(friendsService.curFriends_num());

        boolean flag = friendsService.AddFriends(friends);
        PrintWriter out = response.getWriter();
        if (flag){
            out.println("<script>");
            out.println("alert('添加成功');");
            out.println("window.location.href='friends.jsp';");
            out.println("</script>");
        } else {
            out.println("<script>");
            out.println("alert('添加失败');");
            out.println("window.location.href='friends.jsp';");
            out.println("</script>");
        }
    }
}
