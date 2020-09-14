package citi.training.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import citi.training.backend.model.MonthCategoryBudget;
import citi.training.backend.serviceImpl.BudgetServiceImpl;
import citi.training.backend.utils.ResultUtils;

@RestController
public class MonthCategoryBudgetController {
	
	@Autowired
	private BudgetServiceImpl budgetServiceImpl;

	@PostMapping(value="/budget")
	public JSONObject addBudget(@RequestParam("year") int year, @RequestParam("month") int month ,
			@RequestParam("categoryId") int categoryId,@RequestParam("limitation") float limitation) {
		
		if(budgetServiceImpl.addBudget(year, month, categoryId, limitation)) {
			return ResultUtils.success();
		}
		return ResultUtils.error("there already have the same one, you don't need to add again");
		
	}
	
	@DeleteMapping(value="/budget/{id}")
	public JSONObject removeBudget(@PathVariable(value = "id") int id) {
		budgetServiceImpl.removeBudget(id);
		return ResultUtils.success();
	}
	
	@GetMapping(value="/budget")
	public JSONObject getBudget(@RequestParam("year") int year, @RequestParam("month") int month, 
			@RequestParam("categoryId") int categoryId) {
		
		MonthCategoryBudget monthCategoryBudget = budgetServiceImpl.getBudget(year, month, categoryId);
		if(monthCategoryBudget!=null) {
			return ResultUtils.success(monthCategoryBudget);
		}
		return ResultUtils.error("sorry, there is nothing");
	}
}
