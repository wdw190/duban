package com.sound.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sound.wss.service.WriterFileService;

@RestController
public class FilesRestController {

	private WriterFileService writerFileService;

	@GetMapping("/filedownload/{fileDir}/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@PathVariable(name = "fileDir") String fileDir,
			@PathVariable(name = "filename") String filename, HttpServletRequest request) {

		return this.writerFileService.downloadFile(fileDir, filename, request);
	}

	public WriterFileService getWriterFileService() {
		return writerFileService;
	}

	@Autowired
	@Required
	public void setWriterFileService(@Qualifier("defaultWriterFileService") WriterFileService writerFileService) {
		this.writerFileService = writerFileService;
	}

}
