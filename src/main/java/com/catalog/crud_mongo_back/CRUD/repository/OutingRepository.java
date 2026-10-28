package com.catalog.crud_mongo_back.CRUD.repository;

import com.catalog.crud_mongo_back.CRUD.entity.Outing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutingRepository extends MongoRepository<Outing, Integer> {
    List<String> findDistinctTypeBy();
}
