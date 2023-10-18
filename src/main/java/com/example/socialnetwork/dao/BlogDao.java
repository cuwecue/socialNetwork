package com.example.socialnetwork.dao;

import com.example.socialnetwork.domain.AreaBlog;
import com.example.socialnetwork.domain.Blog;

import java.util.List;

public interface BlogDao {
    boolean SaveBlog(Blog blog);
    Integer getBlog_num();
    List<Blog> getAllBlog(String username);
    List<AreaBlog> getAllAreaBlog();
    boolean DeleteBlog(Integer bid);
    List<Blog> getAllBlogs();
    boolean omitBlog(int bid);
    Blog getABlog(Integer bid);
}
