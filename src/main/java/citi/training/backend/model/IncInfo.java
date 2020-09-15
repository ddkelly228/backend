package citi.training.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "inc")
public class IncInfo {

    @Id
    private String id;// 主键

    @Field
    private String collName;// 需要自增id的集合名称(这里设置为MyDomain)

    @Field
    private Integer incId;// 当前自增id值

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCollName() {
		return collName;
	}

	public void setCollName(String collName) {
		this.collName = collName;
	}

	public Integer getIncId() {
		return incId;
	}

	public void setIncId(Integer incId) {
		this.incId = incId;
	}

    
}
