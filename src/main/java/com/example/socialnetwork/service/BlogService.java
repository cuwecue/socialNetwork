package com.example.socialnetwork.service;

import com.example.socialnetwork.domain.AreaBlog;
import com.example.socialnetwork.domain.Blog;

import java.util.List;

public interface BlogService {
    boolean Post(Blog blog);
    Integer curPost_num();
    List<Blog> showAllBlog(String username);
    List<AreaBlog> showAllAreaBlog();
    boolean Delete(Integer bid);
    public  abstract  List<Blog> showAllBlogs();
    boolean DeleteBlogs(int bid);
    Blog showABlog(Integer bid);
}
