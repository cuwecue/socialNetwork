package com.example.socialnetwork.dao.Impl;

import com.example.socialnetwork.dao.ReplytoRepDao;
import com.example.socialnetwork.domain.Reply_Rep;
import com.example.socialnetwork.domain.ReplytoRep;
import com.example.socialnetwork.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReplytoRepDaoImpl implements ReplytoRepDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public boolean SaveReplytoRep(ReplytoRep replytoRep) {
        String sql = "insert into replytorep(rid,target_rid,replier,content,time) values(?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql,replytoRep.getRid(),replytoRep.getTarget_rid(),replytoRep.getReplier(),
                    replytoRep.getContent(),replytoRep.getTime());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer getReplytoRep_num() {
        String sql = "select max(rid) from replytorep";
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
    public List<Reply_Rep> getAllReplytoRep(Integer bid) {
        System.out.println(bid);
        String sql = "select replytorep.replier,replytocom.replier as tar_replier,replytorep.content," +
                "replytocom.time as tar_time,replytorep.time as rep_time" +
                " from replytorep,replytocom,comment where replytorep.target_rid=replytocom.rid and comment.cid=replytocom.cid and bid=?";

        try {
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Reply_Rep>(Reply_Rep.class),bid);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
