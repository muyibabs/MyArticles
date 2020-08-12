package com.muyi.comment.controller;

import com.muyi.comment.service.CommentService;
import com.muyi.model.comment.Comment;
import com.muyi.model.exception.BadRequestException;
import com.muyi.model.exception.ConflictException;
import com.muyi.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        if(id==null || id<1)
            throw new BadRequestException("100", "Invalid comment id");
        Comment comment = commentService.getCommentById(id);
        if(comment==null)
            throw new NotFoundException("101", "Comment not found");
        return comment;
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveComment(@RequestBody @Valid Comment comment){
//        Comment comment1 = commentService.getCommentById(comment.getCommentId());
//        if(comment1 != null)
//            throw new ConflictException("100", "Comment already exist");
        commentService.saveComment(comment);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@RequestBody @Valid Comment comment){
        Comment comment1 = commentService.getCommentById(comment.getCommentId());
        if(comment1 == null)
            throw new NotFoundException("100", "Comment does not exist");
        commentService.saveComment(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Integer id){
        if(id==null || id<1)
            throw new BadRequestException("100", "");
        Comment comment = commentService.getCommentById(id);
        if(comment==null)
            throw new NotFoundException("101", "Comment not found");

        commentService.deleteComment(comment);
    }

    @GetMapping("/user/{uId}")
    public List<Comment> getCommentsByUser(@PathVariable Integer uId){
        if(uId==null || uId<1)
            throw new BadRequestException("100", "Invalid user id");
        return commentService.getCommentsByUserId(uId);
    }
}
