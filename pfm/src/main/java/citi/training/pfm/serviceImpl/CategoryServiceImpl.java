package citi.training.pfm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import citi.training.pfm.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	

}
