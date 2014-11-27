package com.test.cron.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.test.cron.controller.HomeController;
import com.test.cron.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	private static final String FILE = "feed_file.csv";

	@Override
	public void readFileLineByLine() {
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		String strLine;
		
		try {
			while((strLine = reader.readLine())!= null) {
				LOGGER.info("Reading line: {}", strLine);
				// TODO write to DB - use batch processing + JDBC DAO
			}
		} catch (IOException e) {
			LOGGER.error("Error reading file: {}", FILE);
		}
	}

}
