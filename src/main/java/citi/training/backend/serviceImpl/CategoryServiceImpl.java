package citi.training.backend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import citi.training.backend.model.Category;
import citi.training.backend.repository.CategoryRepository;
import citi.training.backend.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	//@Autowired
	//private MongoTemplate mongoTemplate;
	
	public List<Category> getCategories() {
		return categoryRepository.findAll();
		
	}

	@Override
	public boolean addCategory(String name) {
		// TODO Auto-generated method stub		
		if(categoryRepository.existsByName(name)) {
			return false;
		}
		Category category = new Category();
		category.setId((int)categoryRepository.count());
		category.setName(name);
		category.setReserved(0);
		categoryRepository.save(category);
		return true;
		
	}

	@Override
	public boolean removeCategory(int id) {
		// TODO Auto-generated method stub
		if(categoryRepository.findById(id).get().getReserved()==0) {
			categoryRepository.deleteById(id);
			return true;
		}
		return false;
		
	}
	
	

}
