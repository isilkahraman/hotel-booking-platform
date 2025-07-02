package com.hotelbooking.commentsservice.dto;

import lombok.Data;

@Data
public class CommentRequest {
    private Long hotelId;
    private String serviceType;
    private int rating;
    private String text;
}
