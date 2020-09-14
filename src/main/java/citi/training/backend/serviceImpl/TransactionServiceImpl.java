package citi.training.backend.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citi.training.backend.model.Transaction;
import citi.training.backend.repository.TransactionRepository;
import citi.training.backend.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public void addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		transaction.setId((int)transactionRepository.count());
		transactionRepository.save(transaction);

	}
	
	@Override
	public void removeTransacttion(int id) {
		// TODO Auto-generated method stub
		transactionRepository.deleteById(id);
	}

	@Override
	public Map<Integer, List<Transaction>> getTransactions(List<Integer> categoryIds, String stratDate, String endDate) {
		// TODO Auto-generated method stub
		Map<Integer,List<Transaction>> map = new HashMap<>();
		try {
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			Date t1 = ft.parse(stratDate);
			Date t2 = ft.parse(endDate);
			
			for(int i=0;i<categoryIds.size();i++) {
				
				int id = categoryIds.get(i);
				List<Transaction> list = transactionRepository.findByCategoryIdAndDateBetween(id,t1,t2);
				map.put(id, list);			
				
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		return map;
		
	}

	
	
	

}
