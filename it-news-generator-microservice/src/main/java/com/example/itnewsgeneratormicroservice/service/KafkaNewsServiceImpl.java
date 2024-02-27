package com.example.itnewsgeneratormicroservice.service;

import com.example.itnewsgeneratormicroservice.model.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
@RequiredArgsConstructor
public class KafkaNewsServiceImpl implements KafkaNewsService {

    private final KafkaSender<String, Object> sender;

    @Override
    public void send(News news) {
        String topic = "news";
        sender.send(
                Mono.just(
                        SenderRecord.create(
                                topic,
                                0,
                                System.currentTimeMillis(),
                                String.valueOf(news.hashCode()),
                                news,
                                null
                        )
                )
        ).subscribe();
    }
}
