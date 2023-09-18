package com.hafiz.blog.controllers;


import com.hafiz.blog.payloads.ApiResponse;
import com.hafiz.blog.payloads.CommentDto;
import com.hafiz.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //create comment

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){
        CommentDto createdComment = commentService.createComment(comment, postId);
        return  new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        commentService.deleteComment(commentId);
        return  new ResponseEntity<ApiResponse>(new ApiResponse("Comment Successfully deleted!!",true), HttpStatus.OK);
    }
}
