package citi.training.pfm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import citi.training.pfm.model.Category;

public interface CategoryRepository extends MongoRepository<Category,Integer> {

}
