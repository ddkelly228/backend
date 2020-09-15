package citi.training.backend.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class SingleFileUpload {
	
	public static boolean upload(MultipartFile file) {
		if(file.isEmpty()) {
			return false;
		}
		
		//创建输入输出流
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			//指定上传的位置
			String path = "D:/upload/";
			//获取文件输入流
			inputStream = file.getInputStream();
			//获取上传时的文件名
			String fileName = file.getOriginalFilename();
			//路径+文件名
			File targetFile = new File(path + fileName);
			
			//判断文件父目录是否存在
			if(!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdir();
			}
			
			//获取文件输出流
			outputStream = new FileOutputStream(targetFile);
			//最后使用资源访问器FileCopyUtils的copy方法拷贝文件
			FileCopyUtils.copy(inputStream, outputStream);
			
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}finally {
			//无论成功与否，都关闭输入输出流
			if(inputStream!=null) {
				try {
					inputStream.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(outputStream != null) {
				try {
					outputStream.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
