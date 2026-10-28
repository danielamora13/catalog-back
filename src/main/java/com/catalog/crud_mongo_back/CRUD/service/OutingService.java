package com.catalog.crud_mongo_back.CRUD.service;

import com.catalog.crud_mongo_back.CRUD.dto.OutingDto;
import com.catalog.crud_mongo_back.CRUD.entity.Outing;
import com.catalog.crud_mongo_back.CRUD.repository.OutingRepository;
import com.catalog.crud_mongo_back.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class OutingService {
    
    @Autowired
    OutingRepository outingRepository;
    
    public List<Outing> getAll() {
        return outingRepository.findAll();
    }

    public Outing getById(int id) throws ResourceNotFoundException {
        return outingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Outing not found with id: " + id));
    }

    public Outing save(OutingDto dto) {
        int id = autoIncrement();
        return outingRepository.save(OutingMapper.fromDto(dto, id));
    }

    public Outing update(int id, OutingDto dto) throws ResourceNotFoundException {
        Outing Outing = outingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Outing not found with id: " + id));
        return outingRepository.save(OutingMapper.update(dto, Outing));
    }

    public void delete(int id) throws ResourceNotFoundException {
        Outing Outing = outingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Outing not found with id: " + id));
        outingRepository.delete(Outing);
    }

    private int autoIncrement() {
        List<Outing> Outings = outingRepository.findAll();
        return Outings.isEmpty() ? 1
                : Outings.stream().max(Comparator.comparing(Outing::getId)).get().getId() + 1;
    }

    public List<String> getAllTypes() {
        return outingRepository.findDistinctTypeBy();
    }
    
}
