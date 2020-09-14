package citi.training.backend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citi.training.backend.model.MonthCategoryBudget;
import citi.training.backend.repository.BudgetRepository;
import citi.training.backend.service.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService {

	
	@Autowired
	private BudgetRepository budgetRepository;
	@Override
	public boolean addBudget(int year, int month, int categoryId, float limitation) {
		// TODO Auto-generated method stub
		if(budgetRepository.findByYearAndMonthAndCategoryId(year, month, categoryId)!=null) {
			return false;
		}
		MonthCategoryBudget monthCategoryBudget = new MonthCategoryBudget();
		monthCategoryBudget.setId((int)budgetRepository.count());
		monthCategoryBudget.setYear(year);
		monthCategoryBudget.setMonth(month);
		monthCategoryBudget.setCategoryId(categoryId);
		monthCategoryBudget.setBudget(limitation);
		
		budgetRepository.save(monthCategoryBudget);
		return true;
	}

	@Override
	public void removeBudget(int id) {
		// TODO Auto-generated method stub
		budgetRepository.deleteById(id);

	}

	@Override
	public MonthCategoryBudget getBudget(int year, int month, int categoryId) {
		// TODO Auto-generated method stub
		return budgetRepository.findByYearAndMonthAndCategoryId(year, month, categoryId);
	}

}
