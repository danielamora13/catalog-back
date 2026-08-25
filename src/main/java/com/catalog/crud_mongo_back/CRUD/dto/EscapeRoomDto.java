package com.catalog.crud_mongo_back.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EscapeRoomDto {

    private String name;
    private Date date;
    private String city;
    private URI photo;
    private String description;
}
