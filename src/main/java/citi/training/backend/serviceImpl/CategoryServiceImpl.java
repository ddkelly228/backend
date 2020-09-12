package citi.training.backend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citi.training.backend.model.Category;
import citi.training.backend.repository.CategoryRepository;
import citi.training.backend.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getCategories() {
		return categoryRepository.findAll();
		
	}

	@Override
	public void addCategory(String name) {
		// TODO Auto-generated method stub
		
		Category category = new Category();
		category.setName(name);
		categoryRepository.save(category);
		
	}

	@Override
	public void removeCategory(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
