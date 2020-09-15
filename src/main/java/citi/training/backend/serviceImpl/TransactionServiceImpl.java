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
		//transaction.setId((int)transactionRepository.count());
		//transactionRepository.save(transaction);
		transactionRepository.insert(transaction);

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
	
	@Override
	public void FileProcess(List<String[]> list) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		float expense;
		for(int i=0;i<list.size();i++) {
			Transaction trac = new Transaction();
			//trac.setId((int)transactionRepository.count());
			//处理类目
			boolean food = list.get(i)[5].contains("美团");
			boolean life = list.get(i)[5].contains("生活");
			boolean tech = list.get(i)[5].contains("科技");
			boolean mall = list.get(i)[5].contains("商城");
			boolean market = list.get(i)[5].contains("超市");
			boolean fruit = list.get(i)[5].contains("水果");
			boolean house = list.get(i)[5].contains("酒店");
			if(food||mall||market||fruit) {
				trac.setCategoryId(2);
			}else {
				trac.setCategoryId(3);
			}
			
			//处理日期
			try {
				Date t1 = ft.parse(list.get(i)[0]);
				trac.setDate(t1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//处理费用
			if(list.get(i)[1].equals("__")) {
				//该笔费用为支出
				expense = Float.parseFloat(list.get(i)[2].replaceAll(",", ""));			
			}else {
				expense = Float.parseFloat(list.get(i)[1].replaceAll(",", ""));
			}
			trac.setExpense(expense);
			trac.setDescription(list.get(i)[5]);
			
			transactionRepository.save(trac);
		}
	}
	
	
	

	
	
	

}
