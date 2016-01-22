package com.rds.platform.model.common;

import lombok.Data;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Data
public class RdsPlatformFileUploadModel {
	
	private CommonsMultipartFile file;
	
	private String filename;
	
	private String tid;
	   
    public CommonsMultipartFile getFile() {  
        return file;  
    }  
   
    public void setFile(CommonsMultipartFile file) {  
        this.file = file;  
    } 

}
