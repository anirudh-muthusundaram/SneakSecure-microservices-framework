package com.sneakerTag.sneakerservice.repository;

import com.sneakerTag.sneakerservice.model.Sneaker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SneakerRepository extends MongoRepository<Sneaker, String> {
}
