package com.catalog.crud_mongo_back.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String name;
    private String author;
    private Integer year;
    private String synopsis;
    private String comment;
}
