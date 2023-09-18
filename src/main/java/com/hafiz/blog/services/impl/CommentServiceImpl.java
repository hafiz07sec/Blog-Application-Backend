package com.hafiz.blog.services.impl;

import com.hafiz.blog.entities.Comment;
import com.hafiz.blog.entities.Post;
import com.hafiz.blog.exceptions.ResourceNotFoundException;
import com.hafiz.blog.payloads.CommentDto;
import com.hafiz.blog.repositories.CommentRepo;
import com.hafiz.blog.repositories.PostRepo;
import com.hafiz.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));

        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = commentRepo.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {

        Comment comment = commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "comment Id", commentId));
        commentRepo.delete(comment);

    }
}
