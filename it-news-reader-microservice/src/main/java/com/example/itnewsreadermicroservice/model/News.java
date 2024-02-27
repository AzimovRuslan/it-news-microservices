package com.example.itnewsreadermicroservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class News {

    private Long id;
    private LocalDateTime timestamp;
    private String text;
}
