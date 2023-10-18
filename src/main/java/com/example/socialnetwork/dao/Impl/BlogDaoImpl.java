package com.example.socialnetwork.dao.Impl;

import com.example.socialnetwork.dao.BlogDao;
import com.example.socialnetwork.domain.AreaBlog;
import com.example.socialnetwork.domain.Blog;
import com.example.socialnetwork.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BlogDaoImpl implements BlogDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public boolean SaveBlog(Blog blog) {
        String sql = "insert blog set bid=?,title=?,main_body=?,time=?,username=?,part=?,picture=?";
        jdbcTemplate.update(sql,blog.getBid(),blog.getTitle(),blog.getMain_body(),blog.getTime(),blog.getUsername(),blog.getPart(),blog.getPicture());
        return true;
    }

    @Override
    public Integer getBlog_num(){
        String sql = "select max(bid) from blog";
        try {
            Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class);
            if (cnt == null)
                cnt = 0;
            return cnt;
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Blog> getAllBlog(String username){
        String sql = "select * from blog where username=? order by time asc";
        try {
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Blog>(Blog.class),username);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AreaBlog> getAllAreaBlog() {
        String sql = "select count(*) as num,province,city from blog natural join user group by province,city";
        try {
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<AreaBlog>(AreaBlog.class));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean DeleteBlog(Integer bid) {
        String sql = "delete from blog where bid=?";
        try {
            jdbcTemplate.update(sql,bid);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<Blog> getAllBlogs() {
        String sql = "select * from blog";
        try {
            List<Blog> blogs = null;
            blogs = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Blog.class));

            return blogs;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean omitBlog(int bid) {
        String sql="delete from blog where bid=?;";
        try{
            jdbcTemplate.update(sql,bid);
            return true;
        }catch (Exception E){
            E.printStackTrace();
            return  false;
        }
    }

    @Override
    public Blog getABlog(Integer bid){
        String sql = "select * from blog where bid=?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Blog>(Blog.class), bid);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
