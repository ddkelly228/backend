package citi.training.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import citi.training.backend.model.Category;
import citi.training.backend.serviceImpl.CategoryServiceImpl;
import citi.training.backend.utils.ResultUtils;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@GetMapping(value="/category")
	public JSONObject getCategories() {
		List<Category> list = categoryServiceImpl.getCategories();
		return ResultUtils.success(list);
	}
	
	@PostMapping(value="/category")
	public JSONObject addCategory(@RequestParam("name") String name) {
		 if(categoryServiceImpl.addCategory(name)) {
			 return ResultUtils.success();
		 }
		 return ResultUtils.error("The category has already exist.");
			
	}
	
	@DeleteMapping(value="/category/{id}")
	public JSONObject removeCategory(@PathVariable(value = "id") int id) {
		
		if(categoryServiceImpl.removeCategory(id)) {
			return ResultUtils.success();
		}
		return ResultUtils.error("sorry, the category can't be removed");

	}
	
	

}
