package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Reply_Com;
import com.example.socialnetwork.domain.Reply_Rep;
import com.example.socialnetwork.service.ReplytoComService;
import com.example.socialnetwork.service.ReplytoRepService;
import com.example.socialnetwork.service.impl.ReplytoComServiceImpl;
import com.example.socialnetwork.service.impl.ReplytoRepServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class ReplytoRepShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");

        HttpSession session = request.getSession();

        ReplytoRepService replytoRepService = new ReplytoRepServiceImpl();
        List<Reply_Rep> reply_coms = replytoRepService.showAllReply_Rep(Integer.valueOf(request.getParameter("bid")));
        mapper.writeValue(response.getOutputStream(),reply_coms);
    }
}
