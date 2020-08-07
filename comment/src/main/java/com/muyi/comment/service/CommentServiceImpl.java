package com.muyi.comment.service;

import com.muyi.comment.dao.CommentDao;
import com.muyi.model.comment.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    CommentDao commentDao;
    ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao, ModelMapper modelMapper) {
        this.commentDao = commentDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Comment getCommentById(Integer id) {
        Optional<com.muyi.model.comment.entity.Comment> comment = commentDao.findById(id);
        if(comment.isPresent())
            return modelMapper.map(comment.get(), Comment.class);
        return null;
    }

    @Override
    public List<Comment> getAllComments() {
        List<com.muyi.model.comment.entity.Comment> commentList = commentDao.findAll();
        if(!commentList.isEmpty())
            return commentList.stream().map(comment -> modelMapper.map(comment, Comment.class)).collect(Collectors.toList());
        return null;
    }

    @Override
    public void saveComment(Comment comment) {
        com.muyi.model.comment.entity.Comment comment1 = modelMapper.map(comment, com.muyi.model.comment.entity.Comment.class);
        commentDao.save(comment1);

    }
}
