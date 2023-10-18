package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.dao.CommentDao;
import com.example.socialnetwork.dao.Impl.CommentDaoImpl;
import com.example.socialnetwork.domain.Comment;
import com.example.socialnetwork.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();

    @Override
    public boolean PostComment(Comment comment) {
        return commentDao.SaveComment(comment);
    }

    @Override
    public Integer curComment_num() {
        return commentDao.getComment_num()+1;
    }

    @Override
    public List<Comment> showAllComment(Integer bid) {
        return commentDao.getAllComment(bid);
    }
}
