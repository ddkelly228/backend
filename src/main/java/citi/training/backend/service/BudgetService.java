package citi.training.backend.service;

import citi.training.backend.model.MonthCategoryBudget;

public interface BudgetService {

	boolean addBudget(int year,int month,int categoryId,float limitation);
	
	void removeBudget(int id);
	
	MonthCategoryBudget getBudget(int year,int month,int categoryId);
}
