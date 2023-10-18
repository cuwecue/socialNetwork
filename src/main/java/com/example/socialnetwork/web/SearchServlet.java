package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Search;
import com.example.socialnetwork.service.SearchService;
import com.example.socialnetwork.service.impl.SearchServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchServlet", value = "/searchServlet")
public class SearchServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            SearchService searchService=new SearchServiceImpl();
            List<Search> searches=searchService.showAllSearches();
            mapper.writeValue(response.getOutputStream(),searches);
        }
    }


