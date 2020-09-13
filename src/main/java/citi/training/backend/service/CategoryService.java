package citi.training.backend.service;

import java.util.List;

import citi.training.backend.model.Category;

public interface CategoryService {
	
	List<Category> getCategories();
	
	boolean addCategory(String name);
	
	void removeCategory(int id);

}
