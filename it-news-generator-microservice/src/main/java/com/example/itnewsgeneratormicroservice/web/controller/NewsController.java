package com.example.itnewsgeneratormicroservice.web.controller;

import com.example.itnewsgeneratormicroservice.model.News;
import com.example.itnewsgeneratormicroservice.service.KafkaNewsServiceImpl;
import com.example.itnewsgeneratormicroservice.web.dto.NewsDto;
import com.example.itnewsgeneratormicroservice.web.mapper.NewsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsMapper newsMapper;
    private final KafkaNewsServiceImpl kafkaNewsServiceImpl;

    @PostMapping("/send")
    public void send(@RequestBody NewsDto newsDto) {
        News news = newsMapper.toEntity(newsDto);
        kafkaNewsServiceImpl.send(news);
    }
}
