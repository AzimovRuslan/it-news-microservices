package com.example.itnewsreadermicroservice.service;

import com.example.itnewsreadermicroservice.model.News;

public interface KafkaNewsService {

    void handle(News news);
}
