package com.example.itnewsgeneratormicroservice.service;

import com.example.itnewsgeneratormicroservice.model.News;

public interface KafkaNewsService {
    void send(News news);
}
