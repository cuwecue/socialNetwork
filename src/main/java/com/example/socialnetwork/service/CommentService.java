package com.example.socialnetwork.service;

import com.example.socialnetwork.domain.Comment;

import java.util.List;

public interface CommentService {
    boolean PostComment(Comment comment);
    Integer curComment_num();
    List<Comment> showAllComment(Integer bid);
}
