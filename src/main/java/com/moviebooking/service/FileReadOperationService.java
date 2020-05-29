package com.moviebooking.service;

import java.io.File;

import com.moviebooking.model.InputReader;


public class FileReadOperationService {
	
	private static final String SCREEN_DATA = "input/screen.txt";
	
	public InputReader getAllInputFilesReader() {
		return new InputReader(new File(SCREEN_DATA));
	}
	

}
