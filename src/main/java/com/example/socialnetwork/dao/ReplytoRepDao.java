package com.example.socialnetwork.dao;

import com.example.socialnetwork.domain.Reply_Rep;
import com.example.socialnetwork.domain.ReplytoRep;

import java.util.List;

public interface ReplytoRepDao {
    boolean SaveReplytoRep(ReplytoRep replytoRep);
    Integer getReplytoRep_num();
    List<Reply_Rep> getAllReplytoRep(Integer bid);
}
