package com.hotelbooking.commentsservice.service;

import com.hotelbooking.commentsservice.dto.*;
import com.hotelbooking.commentsservice.model.Comment;
import com.hotelbooking.commentsservice.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepo;

    public Comment addComment(CommentRequest request) {
        Comment comment = new Comment(null, request.getHotelId(),
                request.getServiceType(), request.getRating(), request.getText());
        return commentRepo.save(comment);
    }

    public List<Comment> getComments(Long hotelId) {
        return commentRepo.findByHotelId(hotelId);
    }

    public List<CommentStats> getStats(Long hotelId) {
        List<Comment> comments = commentRepo.findByHotelId(hotelId);
        Map<String, int[]> statsMap = new HashMap<>();

        for (Comment c : comments) {
            statsMap.putIfAbsent(c.getServiceType(), new int[5]);
            statsMap.get(c.getServiceType())[c.getRating() - 1]++;
        }

        List<CommentStats> result = new ArrayList<>();
        for (var entry : statsMap.entrySet()) {
            result.add(new CommentStats(entry.getKey(), entry.getValue()));
        }
        return result;
    }
}
