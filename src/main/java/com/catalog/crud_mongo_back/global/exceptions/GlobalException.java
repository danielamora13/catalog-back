package com.catalog.crud_mongo_back.global.exceptions;

import com.catalog.crud_mongo_back.global.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException ex) {
        MessageDto messageDto = new MessageDto();
        messageDto.setStatus(HttpStatus.NOT_FOUND);
        messageDto.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDto);
    }
}
