package citi.training.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import citi.training.backend.model.Category;
import citi.training.backend.serviceImpl.CategoryServiceImpl;
import citi.training.backend.utils.ResultUtils;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@GetMapping(value="/categories")
	public JSONObject getCategories() {
		List<Category> list = categoryServiceImpl.getCategories();
		return ResultUtils.success(list);
	}

}
