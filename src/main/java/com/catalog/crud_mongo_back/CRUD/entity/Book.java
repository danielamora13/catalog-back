package com.catalog.crud_mongo_back.CRUD.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "book")
public class Book {

    @Id
    private int id;
    private String name;
    private String author;
    private Integer year;
    private String synopsis;
    private String comment;
}
