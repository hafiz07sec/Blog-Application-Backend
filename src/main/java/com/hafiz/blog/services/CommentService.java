package com.hafiz.blog.services;

import com.hafiz.blog.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);
}
