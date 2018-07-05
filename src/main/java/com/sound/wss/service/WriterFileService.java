package com.sound.wss.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author XPC
 *
 */
public interface WriterFileService {

	/**
	 * 文件下载
	 * 
	 * @param phonenumber
	 * @param filename
	 * @param request
	 * @return
	 */
	public ResponseEntity<Resource> downloadFile(String phonenumber, String filename, HttpServletRequest request);

}
