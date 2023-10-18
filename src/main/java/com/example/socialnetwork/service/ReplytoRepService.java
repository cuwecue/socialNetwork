package com.example.socialnetwork.service;

import com.example.socialnetwork.domain.Reply_Rep;
import com.example.socialnetwork.domain.ReplytoRep;

import java.util.List;

public interface ReplytoRepService {
    boolean PostReplytoRep(ReplytoRep replytoRep);
    Integer curReplytoRep_num();
    List<Reply_Rep> showAllReply_Rep(Integer rid);
}
