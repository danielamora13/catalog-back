package com.catalog.crud_mongo_back.CRUD.controller;

import com.catalog.crud_mongo_back.CRUD.dto.OutingDto;
import com.catalog.crud_mongo_back.CRUD.entity.Outing;
import com.catalog.crud_mongo_back.CRUD.service.OutingService;
import com.catalog.crud_mongo_back.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outing")
public class OutingController {
    
    @Autowired
    private OutingService outingService;

    @GetMapping
    public ResponseEntity<List<Outing>> getAll() {
        return ResponseEntity.ok(outingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Outing> getById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(outingService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Outing> save(@RequestBody OutingDto dto) {
        return ResponseEntity.ok(outingService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Outing> update(@PathVariable("id") int id, @RequestBody OutingDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(outingService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        outingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/types")
    public List<String> getTypes() {
        return outingService.getAllTypes();
    }
    
    
}
