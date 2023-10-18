package com.example.socialnetwork.service;

import com.example.socialnetwork.domain.Reply_Com;
import com.example.socialnetwork.domain.ReplytoCom;

import java.util.List;

public interface ReplytoComService {
    boolean PostReplytoCom(ReplytoCom replytoCom);
    Integer curReplytoCom_num();
    List<Reply_Com> showAllReply_Com(Integer bid);
}
