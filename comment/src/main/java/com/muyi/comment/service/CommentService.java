package com.muyi.comment.service;

import com.muyi.model.comment.Comment;

import java.util.List;

public interface CommentService {

    Comment getCommentById(Integer id);

    List<Comment> getAllComments();

    void saveComment(Comment comment);
}
