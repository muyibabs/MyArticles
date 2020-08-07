package com.muyi.comment.controller;

import com.muyi.comment.service.CommentService;
import com.muyi.model.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{cId}")
    public Comment getCommentById(@PathVariable(name = "cId") Integer id){
        return commentService.getCommentById(id);
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @PostMapping
    public void saveComment(@RequestBody Comment comment){
        commentService.saveComment(comment);
    }
}
