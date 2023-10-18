package com.example.socialnetwork.dao;

import com.example.socialnetwork.domain.Comment;

import java.util.List;

public interface CommentDao {
    boolean SaveComment(Comment comment);
    Integer getComment_num();
    List<Comment> getAllComment(Integer bid);
}
