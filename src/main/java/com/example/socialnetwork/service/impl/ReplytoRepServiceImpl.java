package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.dao.Impl.ReplytoRepDaoImpl;
import com.example.socialnetwork.dao.ReplytoRepDao;
import com.example.socialnetwork.domain.Reply_Rep;
import com.example.socialnetwork.domain.ReplytoRep;
import com.example.socialnetwork.service.ReplytoRepService;

import java.util.List;

public class ReplytoRepServiceImpl implements ReplytoRepService {
    ReplytoRepDao replytoRepDao = new ReplytoRepDaoImpl();
    @Override
    public boolean PostReplytoRep(ReplytoRep replytoRep) {
        return replytoRepDao.SaveReplytoRep(replytoRep);
    }

    @Override
    public Integer curReplytoRep_num() {
        return replytoRepDao.getReplytoRep_num()+1;
    }

    @Override
    public List<Reply_Rep> showAllReply_Rep(Integer rid) {
        return replytoRepDao.getAllReplytoRep(rid);
    }
}
