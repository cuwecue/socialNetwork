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

//@WebServlet("/infoSaveServlet")
public class InfoSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        HttpSession session = request.getSession();

        User user = new User();
        user.setUsername(session.getAttribute("username").toString());
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setTelephone(request.getParameter("telephone"));
        user.setGender(request.getParameter("gender"));
        user.setBirthday(request.getParameter("birthday"));
        user.setProvince(request.getParameter("input_province"));
        user.setCity(request.getParameter("input_city"));

        Edu_work edu_work = new Edu_work();
        edu_work.setUsername(session.getAttribute("username").toString());
        edu_work.setEdu_level(request.getParameter("edu_level"));
        edu_work.setEdu_start(request.getParameter("edu_start"));
        edu_work.setEdu_end(request.getParameter("edu_end"));
        edu_work.setSchool(request.getParameter("school"));
        edu_work.setDegree(request.getParameter("degree"));
        edu_work.setWorkplace(request.getParameter("workplace"));
        edu_work.setWork_start(request.getParameter("work_start"));
        edu_work.setWork_end(request.getParameter("work_end"));
        edu_work.setJob(request.getParameter("job"));

        UserService userService = new UserServiceImpl();
        boolean flag = userService.updateinfo(edu_work);
        boolean flag_1 = userService.updateinfo_1(user);

        PrintWriter out = response.getWriter();
        if (flag && flag_1){
            out.println("<script>");
            out.println("alert('修改成功');");
            out.println("window.location.href='blog_list.jsp';");
            out.println("</script>");
        }
        else {
            out.println("<script>");
            out.println("alert('修改失败');");
            out.println("window.location.href='pim.jsp';");
            out.println("</script>");
        }

        session.setAttribute("name",user.getName());
        session.setAttribute("birthday",user.getBirthday());
        session.setAttribute("gender",user.getGender());
        session.setAttribute("telephone",user.getTelephone());
        session.setAttribute("email",user.getEmail());
        session.setAttribute("province",user.getProvince());
        session.setAttribute("city",user.getCity());
        session.setAttribute("edu_level",edu_work.getEdu_level());
        session.setAttribute("edu_start",edu_work.getEdu_start());
        session.setAttribute("edu_end",edu_work.getEdu_end());
        session.setAttribute("school",edu_work.getSchool());
        session.setAttribute("degree",edu_work.getDegree());
        session.setAttribute("workplace",edu_work.getWorkplace());
        session.setAttribute("work_start",edu_work.getWork_start());
        session.setAttribute("work_end",edu_work.getWork_end());
        session.setAttribute("job",edu_work.getJob());
    }
}
