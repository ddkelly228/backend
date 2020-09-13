package citi.training.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="category")
public class Category {

	@Id
	@Field("id")
	private int id;
	
	@Field("name")
	private String name;
	
	@Field("reserved")
	private int reserved;//0--可以删除；1--原有的，用户不可删除

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getReserved() {
		return reserved;
	}
	
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	
	
	
	
}

