package com.example.socialnetwork.dao.Impl;

import com.example.socialnetwork.dao.ReplytoComDao;
import com.example.socialnetwork.domain.Blog;
import com.example.socialnetwork.domain.Reply_Com;
import com.example.socialnetwork.domain.ReplytoCom;
import com.example.socialnetwork.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReplytoComDaoImpl implements ReplytoComDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public boolean SaveReplytoCom(ReplytoCom replytoCom) {
        String sql = "insert into replytocom(rid,cid,replier,content,time) values(?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql,replytoCom.getRid(),replytoCom.getCid(),replytoCom.getReplier(),
                    replytoCom.getContent(),replytoCom.getTime());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer getReplytoCom_num() {
        String sql = "select max(rid) from replytocom";
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
    public List<Reply_Com> getAllReply_Com(Integer bid) {
        String sql = "select * from reply_com where bid=?";
        try {
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Reply_Com>(Reply_Com.class),bid);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
