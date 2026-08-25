package com.catalog.crud_mongo_back.CRUD.repository;

import com.catalog.crud_mongo_back.CRUD.entity.EscapeRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscapeRoomRepository extends MongoRepository<EscapeRoom, Integer> {
}
