package citi.training.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import citi.training.backend.model.Category;


public interface CategoryRepository extends MongoRepository<Category,Integer> {

}
