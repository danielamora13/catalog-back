package com.catalog.crud_mongo_back.CRUD.service;

import com.catalog.crud_mongo_back.CRUD.dto.BookDto;
import com.catalog.crud_mongo_back.CRUD.entity.Book;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookMapper {

    public static Book fromDto(BookDto dto, int id) {
        return Book.builder()
                .id(id)
                .name(dto.getName())
                .author(dto.getAuthor())
                .year(dto.getYear())
                .image(dto.getImage())
                .synopsis(dto.getSynopsis())
                .comment(dto.getComment())
                .build();
    }

    public static Book update(BookDto dto, Book book) {
        return book.toBuilder()
                .name(dto.getName())
                .author(dto.getAuthor())
                .year(dto.getYear())
                .image(dto.getImage())
                .synopsis(dto.getSynopsis())
                .comment(dto.getComment())
                .build();
    }
}
