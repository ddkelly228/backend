package citi.training.backend.service;

import java.util.List;
import java.util.Map;

import citi.training.backend.model.Transaction;

public interface TransactionService {
	
	void addTransaction(Transaction transaction);
	
	void removeTransacttion(int id);
	
	Map<Integer,List<Transaction>> getTransactions(List<Integer> categoryIds, String stratDate, String endDate);

}
