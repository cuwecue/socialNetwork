package com.example.socialnetwork.dao;

import com.example.socialnetwork.domain.Reply_Com;
import com.example.socialnetwork.domain.ReplytoCom;

import java.util.List;

public interface ReplytoComDao {
    boolean SaveReplytoCom(ReplytoCom replytoCom);
    Integer getReplytoCom_num();
    List<Reply_Com> getAllReply_Com(Integer bid);
}
