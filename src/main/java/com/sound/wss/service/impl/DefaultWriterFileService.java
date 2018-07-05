package com.sound.wss.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sound.wss.service.WriterFileService;
import com.sound.wss.storage.StorageService;
import com.sound.wss.utils.WSSUtils;

@Service("defaultWriterFileService")
public class DefaultWriterFileService implements WriterFileService {

	private static Logger logger = LogManager.getLogger(DefaultWriterFileService.class);

	@Autowired
	private ApplicationContext appContext;

	@Override
	public ResponseEntity<Resource> downloadFile(String fileDir, String filename, HttpServletRequest request) {

		// 获取操作文件的BEAN
		StorageService storageService = (StorageService) appContext.getBean("fileSystemStorageService");

		logger.info("download:" + new StringBuilder().append(WSSUtils.getRealPath(request)).append("/uploadfiles/")
				.append(fileDir).toString());
		logger.info("filename:" + filename);
		// 初始化文件目录
		storageService.init(new StringBuilder().append(WSSUtils.getRealPath(request)).append("/uploadfiles/")
				.append(fileDir).toString());
		// 加载文件
		Resource file = storageService.loadAsResource(filename);
		// 返回
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

}
