package com.catalog.crud_mongo_back.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.net.URI;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String name;
    private String author;
    private Integer year;
    private URI image;
    private String synopsis;
    private String comment;
}
