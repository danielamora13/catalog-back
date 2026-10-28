package com.catalog.crud_mongo_back.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutingDto {

    private String name;
    private Date date;
    private String place;
    private URI photo;
    private String difficulty;
    private String description;
    private String type;
}
