package com.catalog.crud_mongo_back.CRUD.service;

import com.catalog.crud_mongo_back.CRUD.dto.OutingDto;
import com.catalog.crud_mongo_back.CRUD.entity.Outing;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OutingMapper {
    public static Outing fromDto(OutingDto dto, int id) {
        return Outing.builder()
                .id(id)
                .name(dto.getName())
                .description(dto.getDescription())
                .date(dto.getDate())
                .place(dto.getPlace())
                .photo(dto.getPhoto())
                .difficulty(dto.getDifficulty())
                .type(dto.getType())
                .build();
    }

    public static Outing update(OutingDto dto, Outing outing) {
        outing.setName(dto.getName());
        outing.setDescription(dto.getDescription());
        outing.setDate(dto.getDate());
        outing.setPlace(dto.getPlace());
        outing.setPhoto(dto.getPhoto());
        outing.setDifficulty(dto.getDifficulty());
        outing.setType(dto.getType());
        return outing;
    }

}
