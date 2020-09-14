package citi.training.backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import citi.training.backend.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction,Integer> {

	//List<Transaction> findByCategoryId(int id);
	
	List<Transaction> findByCategoryIdAndDateBetween(int id, Date startDate, Date endDate );
}
