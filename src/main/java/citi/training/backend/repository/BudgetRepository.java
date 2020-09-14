package citi.training.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import citi.training.backend.model.MonthCategoryBudget;

public interface BudgetRepository extends MongoRepository<MonthCategoryBudget, Integer> {

	MonthCategoryBudget findByYearAndMonthAndCategoryId(int year,int month,int categoryId);

	//Object findByYearAndMonthAndCategoryId(int year, int month, int categoryId);
}
