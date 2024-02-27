package com.example.itnewsgeneratormicroservice.web.mapper;

import com.example.itnewsgeneratormicroservice.model.News;
import com.example.itnewsgeneratormicroservice.web.dto.NewsDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper implements Mappable<News, NewsDto> {

    @Override
    public News toEntity(NewsDto dto) {
        return new ModelMapper().map(dto, News.class);
    }

    @Override
    public NewsDto toDto(News entity) {
        return new ModelMapper().map(entity, NewsDto.class);
    }
}
