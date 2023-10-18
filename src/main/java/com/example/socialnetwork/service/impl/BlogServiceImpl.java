package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.dao.BlogDao;
import com.example.socialnetwork.dao.Impl.BlogDaoImpl;
import com.example.socialnetwork.domain.AreaBlog;
import com.example.socialnetwork.domain.Blog;
import com.example.socialnetwork.service.BlogService;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    BlogDao blogDao = new BlogDaoImpl();
    public boolean Post(Blog blog){
        return blogDao.SaveBlog(blog);
    }

    public Integer curPost_num(){
        return blogDao.getBlog_num()+1;
    }

    @Override
    public List<Blog> showAllBlog(String username) {
        return blogDao.getAllBlog(username);
    }

    @Override
    public List<AreaBlog> showAllAreaBlog() {
        return blogDao.getAllAreaBlog();
    }

    @Override
    public boolean Delete(Integer bid) {
        return blogDao.DeleteBlog(bid);
    }

    @Override
    public List<Blog> showAllBlogs() {
        return blogDao.getAllBlogs();
    }

    @Override
    public boolean DeleteBlogs(int bid) {
        return blogDao.omitBlog(bid);
    }
    @Override
    public Blog showABlog(Integer bid){
        return blogDao.getABlog(bid);
    }

}
