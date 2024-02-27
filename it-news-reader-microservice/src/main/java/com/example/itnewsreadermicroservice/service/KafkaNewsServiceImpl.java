package com.example.itnewsreadermicroservice.service;

import com.example.itnewsreadermicroservice.model.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class KafkaNewsServiceImpl implements KafkaNewsService{

    @Override
    public void handle(News news) {
        System.out.println("News object is received " + news.toString());
    }
}
