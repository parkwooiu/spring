package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload from..........");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormActionPost(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "c:\\upload";
		
		for( MultipartFile multipartFile : uploadFile) {
			log.info("-----------------------------------");
			log.info("upload file Name : " + multipartFile.getOriginalFilename());
			log.info("upload file size : " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());  //저장 대상
			
			try {
				multipartFile.transferTo(saveFile);  //파일 저장
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax...........");
	}
	
	
	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		
		String uploadFolder = "c:\\upload";
		
		//make Folder....
		File uploadPath = new File(uploadFolder, getFolder()); //
		
		log.info(uploadPath);
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		for( MultipartFile multipartFile : uploadFile) {
			
			log.info("-----------ajax-----------------------");
			log.info("upload file Name : " + multipartFile.getOriginalFilename());
			log.info("upload file size : " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			log.info(uploadFileName);
			uploadFileName =  uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			log.info(uploadFileName);
			
		    UUID uuid = UUID.randomUUID();
			
		    log.info("uuid" + uuid);
		    
		    
		    
		    //파일명 앞에 랜덤한 영문자 32자를 붙힌다.    fdugbdfjbhgsdjkgbfdsjkfdsadbs_01Apple.jpg
		    uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			File saveFile = new File(uploadPath, uploadFileName);  //저장 대상
			
			try {
				multipartFile.transferTo(saveFile);  //파일 저장
				
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(
							new File(uploadPath, "s_" + uploadFileName)
							);
					
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail, 100,100);
					thumbnail.close();
					
				}
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		
		String str = sdf.format(date);
		
		
		return str.replace("-", File.separator); // 2024\04\29
		
	}
	//  파일이 이미지 파일인 경우 true를 반환하고, 그렇지 않은 경우 false를 반환합니다.
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());

			
			return contentType.startsWith("image"); //이미지파일 맞음
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}