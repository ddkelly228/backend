package citi.training.backend.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import citi.training.backend.annotation.AutoIncKey;

@Document(collection="transaction")
public class Transaction {
	
	@Id
	@AutoIncKey
	@Field("id")
	private int id;
	
	@Field("categoryId")
	private int categoryId;
	
	@Field("date")
	private Date date;
	
	@Field("expense")
	private float expense;
	
	@Field("description")
	private String description;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getExpense() {
		return expense;
	}

	public void setExpense(float expense) {
		this.expense = expense;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
