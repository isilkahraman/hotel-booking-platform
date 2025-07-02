package com.hotelbooking.commentsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentStats {
    private String serviceType;
    private int[] distribution; // rating counts (index 0 = 1-star, index 4 = 5-star)
}
