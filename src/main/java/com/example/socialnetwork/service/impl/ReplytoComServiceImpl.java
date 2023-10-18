package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.dao.Impl.ReplytoComDaoImpl;
import com.example.socialnetwork.dao.ReplytoComDao;
import com.example.socialnetwork.domain.Reply_Com;
import com.example.socialnetwork.domain.ReplytoCom;
import com.example.socialnetwork.service.ReplytoComService;

import java.util.List;

public class ReplytoComServiceImpl implements ReplytoComService {
    ReplytoComDao replytoComDao = new ReplytoComDaoImpl();
    @Override
    public boolean PostReplytoCom(ReplytoCom replytoCom) {
        return replytoComDao.SaveReplytoCom(replytoCom);
    }

    @Override
    public Integer curReplytoCom_num() {
        return replytoComDao.getReplytoCom_num()+1;
    }

    @Override
    public List<Reply_Com> showAllReply_Com(Integer bid) {
        return replytoComDao.getAllReply_Com(bid);
    }
}
