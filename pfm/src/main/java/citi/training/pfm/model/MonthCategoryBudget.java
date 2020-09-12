package citi.training.pfm.model;

import java.util.Date;



//monthly budgets for these categories
public class MonthCategoryBudget {

	private int categoryId;
	
	private Date date;//year and month
	
	private float budget;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}
	
	
	
	
	
}
