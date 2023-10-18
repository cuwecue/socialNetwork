package com.example.socialnetwork.dao.Impl;

import com.example.socialnetwork.dao.CommentDao;
import com.example.socialnetwork.domain.Blog;
import com.example.socialnetwork.domain.Comment;
import com.example.socialnetwork.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public boolean SaveComment(Comment comment) {
        String sql = "insert into comment(cid,bid,commenter,content,time) values(?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql,comment.getCid(),comment.getBid(),comment.getCommenter(),
                    comment.getContent(),comment.getTime());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer getComment_num() {
        String sql = "select max(cid) from comment";
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
    public List<Comment> getAllComment(Integer bid) {
        String sql = "select * from comment where bid=? order by time asc";
        try {
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Comment>(Comment.class),bid);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
