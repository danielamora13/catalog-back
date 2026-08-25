package com.catalog.crud_mongo_back.CRUD.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URI;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "escapeRoom")
public class EscapeRoom {

    @Id
    private int id;
    private String name;
    private Date date;
    private String city;
    private URI photo;
    private String description;
}
