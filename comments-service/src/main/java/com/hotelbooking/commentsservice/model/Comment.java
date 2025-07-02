package com.hotelbooking.commentsservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;

    private Long hotelId;
    private String serviceType;  // e.g., "room", "staff", "location"
    private int rating;          // 1–5
    private String text;
}
