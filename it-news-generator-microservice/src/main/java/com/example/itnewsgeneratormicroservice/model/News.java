package com.example.itnewsgeneratormicroservice.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class News {

    private Long id;
    private LocalDateTime timestamp;
    private String text;
}
