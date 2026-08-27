package com.catalog.crud_mongo_back.CRUD.service;

import com.catalog.crud_mongo_back.CRUD.dto.EscapeRoomDto;
import com.catalog.crud_mongo_back.CRUD.entity.EscapeRoom;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EscapeRoomMapper {

    public static EscapeRoom fromDto(EscapeRoomDto dto, int id) {
        return EscapeRoom.builder()
                .id(id)
                .name(dto.getName())
                .date(dto.getDate())
                .city(dto.getCity())
                .photo(dto.getPhoto())
                .synopsis(dto.getSynopsis())
                .numPeople(dto.getNumPeople())
                .difficulty(dto.getDifficulty())
                .time(dto.getTime())
                .description(dto.getDescription())
                .build();
    }

    public static EscapeRoom update(EscapeRoomDto dto, EscapeRoom escapeRoom) {
        return escapeRoom.toBuilder()
                .name(dto.getName())
                .date(dto.getDate())
                .city(dto.getCity())
                .photo(dto.getPhoto())
                .synopsis(dto.getSynopsis())
                .numPeople(dto.getNumPeople())
                .difficulty(dto.getDifficulty())
                .time(dto.getTime())
                .description(dto.getDescription())
                .build();
    }
}
