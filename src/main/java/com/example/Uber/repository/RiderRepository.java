package com.example.Uber.repository;

import com.example.Uber.model.Rider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RiderRepository extends MongoRepository<Rider, UUID> {


}
