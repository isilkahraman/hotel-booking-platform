package com.hotelbooking.commentsservice.controller;

import com.hotelbooking.commentsservice.dto.*;
import com.hotelbooking.commentsservice.model.Comment;
import com.hotelbooking.commentsservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Comment add(@RequestBody CommentRequest request) {
        return commentService.addComment(request);
    }

    @GetMapping("/{hotelId}")
    public List<Comment> getAll(@PathVariable Long hotelId) {
        return commentService.getComments(hotelId);
    }

    @GetMapping("/{hotelId}/stats")
    public List<CommentStats> getStats(@PathVariable Long hotelId) {
        return commentService.getStats(hotelId);
    }
}
