package com.catalog.crud_mongo_back.CRUD.controller;

import com.catalog.crud_mongo_back.CRUD.dto.EscapeRoomDto;
import com.catalog.crud_mongo_back.CRUD.entity.EscapeRoom;
import com.catalog.crud_mongo_back.CRUD.service.EscapeRoomService;
import com.catalog.crud_mongo_back.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escape-room")
public class EscapeRoomController {

    @Autowired
    EscapeRoomService escapeRoomService;

    @GetMapping
    public ResponseEntity<List<EscapeRoom>> getAll() {
        return ResponseEntity.ok(escapeRoomService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscapeRoom> getById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(escapeRoomService.getById(id));
    }

    @PostMapping
    public ResponseEntity<EscapeRoom> save(@RequestBody EscapeRoomDto dto) {
        return ResponseEntity.ok(escapeRoomService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EscapeRoom> update(@PathVariable("id") int id, @RequestBody EscapeRoomDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(escapeRoomService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        escapeRoomService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
