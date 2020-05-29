package com.moviebooking.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader implements Reader {

	private File file;
	
	

	public InputReader(File screen1) {
		super();
		this.file = screen1;
		
		
	}

	public List<String> readInputFile()  {
		
		List<String> fileLines = new ArrayList<>();
		
			
			try(Scanner s = new Scanner(new FileReader(file))){
				while (s.hasNext()) {
					String nextLine = s.nextLine();
					fileLines.add(nextLine);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			
		
		
		
		return fileLines;
	}

}
