package citi.training.backend.controller;

import java.util.List;

import citi.training.backend.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import com.alibaba.fastjson.JSONObject;

import citi.training.backend.model.Category;
import citi.training.backend.serviceImpl.CategoryServiceImpl;
import citi.training.backend.utils.ResultUtils;

@CrossOrigin
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@GetMapping(value="/category")
	public Result getCategories() {
		List<Category> list = categoryServiceImpl.getCategories();
		return ResultUtils.success(list);
	}
	
//	@PostMapping(value="/category/add")
//	public JSONObject addCategory(@RequestBody JSONObject requestJson) {
//		 String name = requestJson.getString("name");
//		 if(categoryServiceImpl.addCategory(name)) {
//			 return ResultUtils.success();
//		 }
//		 return ResultUtils.error("The category has already exist.");
//
//	}
	
	@DeleteMapping(value="/category/remove/{id}")
	public Result removeCategory(@PathVariable(value = "id") int id) {
		
		if(categoryServiceImpl.removeCategory(id)) {
			return ResultUtils.success();
		}
		return ResultUtils.error("sorry, the category can't be removed");

	}
	
	

}
