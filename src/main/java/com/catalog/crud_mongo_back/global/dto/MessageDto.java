package com.catalog.crud_mongo_back.global.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private HttpStatus status;
    private String message;


}
