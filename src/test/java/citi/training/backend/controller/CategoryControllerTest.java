package citi.training.backend.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
class CategoryControllerTest{

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	//方法执行前初始化数据
	@BeforeAll
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext ).build(); 
	}
	
	@Test
	void testGetCategories() throws Exception {
		fail("Not yet implemented");
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/category" ).accept(MediaType.APPLICATION_JSON);
	    mockHttpServletRequestBuilder.param("name", "fruit" ); //要传入的参数
	    ResultActions resultActions = mockMvc.perform( mockHttpServletRequestBuilder );  
	    resultActions.andExpect(MockMvcResultMatchers.status().isOk());
	    
	   	}

	@Test
	void testAddCategory() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveCategory() {
		fail("Not yet implemented");
	}

}
