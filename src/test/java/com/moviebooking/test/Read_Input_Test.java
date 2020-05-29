package com.moviebooking.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.moviebooking.model.InputReader;


public class Read_Input_Test {
	
     File file;
	

	@Before
	public void setUp() throws Exception {
		file = new File("akshay.txt");
	    String str = "Hello";
	    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	    writer.write(str);
	    writer.close();
		
		
	}

	@After
	public void tearDown() throws Exception {
		file = null;
	}

	@Test
	public void testInputReader() {
		InputReader inputReader = new InputReader(file);
		List<String> expected = new ArrayList<String>();
		expected.add("Hello");
		Assert.assertEquals(expected, inputReader.readInputFile());
	}

}