package citi.training.backend.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="monthCategoryBudget")
public class MonthCategoryBudget {
	
	@Id
	@Field("id")
	private int id;

	@Field("categoryId")
	private int categoryId;
	
	@Field("year")
	private int year;
	
	@Field("month")
	private int month;
	
	@Field("budget")
	private float budget;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int month() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}
}
