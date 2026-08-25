package com.catalog.crud_mongo_back.CRUD.service;

import com.catalog.crud_mongo_back.CRUD.dto.EscapeRoomDto;
import com.catalog.crud_mongo_back.CRUD.entity.EscapeRoom;
import com.catalog.crud_mongo_back.CRUD.repository.EscapeRoomRepository;
import com.catalog.crud_mongo_back.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EscapeRoomService {

    @Autowired
    EscapeRoomRepository escapeRoomRepository;

    public List<EscapeRoom> getAll() {
        return escapeRoomRepository.findAll();
    }

    public EscapeRoom getById(int id) throws ResourceNotFoundException {
        return escapeRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EscapeRoom not found with id: " + id));
    }

    public EscapeRoom save(EscapeRoomDto dto) {
        int id = autoIncrement();
        return escapeRoomRepository.save(EscapeRoomMapper.fromDto(dto, id));
    }

    public EscapeRoom update(int id, EscapeRoomDto dto) throws ResourceNotFoundException {
        EscapeRoom escapeRoom = escapeRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EscapeRoom not found with id: " + id));
        return escapeRoomRepository.save(EscapeRoomMapper.update(dto, escapeRoom));
    }

    public void delete(int id) throws ResourceNotFoundException {
        EscapeRoom escapeRoom = escapeRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EscapeRoom not found with id: " + id));
        escapeRoomRepository.delete(escapeRoom);
    }

    private int autoIncrement() {
        List<EscapeRoom> escapeRooms = escapeRoomRepository.findAll();
        return escapeRooms.isEmpty() ? 1
                : escapeRooms.stream().max(Comparator.comparing(EscapeRoom::getId)).get().getId() + 1;
    }
}
