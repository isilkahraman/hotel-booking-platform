package com.hotelbooking.commentsservice.repository;

import com.hotelbooking.commentsservice.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByHotelId(Long hotelId);
}
