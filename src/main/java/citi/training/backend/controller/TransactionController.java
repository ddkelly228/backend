package citi.training.backend.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import citi.training.backend.model.Transaction;
import citi.training.backend.serviceImpl.TransactionServiceImpl;
import citi.training.backend.utils.ResultUtils;
import citi.training.backend.utils.SingleFileUpload;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionServiceImpl transactionServiceImpl;
	
	@PostMapping(value="/transaction")
	public JSONObject addTransaction(@RequestParam("categoryId") int categoryId,@RequestParam("date") String date,
			@RequestParam("expense") float expense ,@RequestParam("description") String description) {
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Transaction transaction = new Transaction();
		try {
			Date t1 = ft.parse(date);
			transaction.setDate(t1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		transaction.setCategoryId(categoryId);
		transaction.setExpense(expense);
		transaction.setDescription(description);
		
		transactionServiceImpl.addTransaction(transaction);
		
		return ResultUtils.success();	
		
	}
	
	@DeleteMapping(value="/transaction/{id}")
	public JSONObject removeTransaction(@PathVariable(value = "id") int id) {
		transactionServiceImpl.removeTransacttion(id);
		return ResultUtils.success();
	}
	
	@GetMapping(value="transaction")
	public JSONObject getTransactions(@RequestParam("categoryIds") List<Integer> categoryIds,
			@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate) {
		
		return ResultUtils.success(transactionServiceImpl.getTransactions(categoryIds, startDate, endDate));
	}
	
	//文件上传
	@PostMapping(value="/fileupload")
	public JSONObject fileUpLoad(@RequestParam("myfile") MultipartFile file) {
		if(SingleFileUpload.upload(file)) {
			
			return ResultUtils.success();
		}
		return ResultUtils.error("There is something wrong in upload file");
	}
	

}
