package com.example.itnewsreadermicroservice.service;

import com.example.itnewsreadermicroservice.config.LocalDateTimeDeserializer;
import com.example.itnewsreadermicroservice.model.News;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaNewsReceiverImpl implements KafkaNewsReceiver {

    private final KafkaReceiver<String, Object> receiver;
    private final LocalDateTimeDeserializer localDateTimeDeserializer;
    private final KafkaNewsServiceImpl kafkaNewsService;

    @PostConstruct
    private void init() {
        fetch();
    }

    @Override
    public void fetch() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        localDateTimeDeserializer)
                .create();

        receiver.receive()
                .subscribe(r -> {
                    News news = gson
                            .fromJson(r.value().toString(), News.class);
                    kafkaNewsService.handle(news);
                    r.receiverOffset().acknowledge();
                });
    }
}
