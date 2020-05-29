package com.moviebooking.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.moviebooking.model.ScreenSeats;
import com.moviebooking.parser.DataInputParser;


public class Input_Parser_Test {
	
	DataInputParser dataInputParser;
	
	@Before
	public void setUp() throws Exception {
		dataInputParser = new DataInputParser(getScannedData());
		
	}
	
	@After
	public void tearDown() throws Exception {
		dataInputParser = null;
	}

	

	private List<String> getScannedData() {
		List<String> scannedData = new ArrayList<>();
		scannedData.add("Seating arrangement:");
		scannedData.add("Show 1 Running in Audi 1:");
		scannedData.add("All Seats:");
		scannedData.add("A1 A2 A3 A4 A5 A6 A7 A8 A9");
		scannedData.add("B1 B2 B3 B4 B5 B6");
		scannedData.add("C2 C3 C4 C5 C6 C7");
		
		return scannedData;
	}



	@Test
	public void testInputReader() {
		
		Map<Integer,ScreenSeats> expectedData = new HashMap<Integer, ScreenSeats>();
		ScreenSeats ss= new ScreenSeats();
		String ps = "A1 A2 A3 A4 A5 A6 A7 A8 A9";
		String gs = "B1 B2 B3 B4 B5 B6";
		String cs = "C2 C3 C4 C5 C6 C7";
		String[] split = ps.split(" ");
		String[] gssplit = gs.split(" ");
		String[] cssplit = cs.split(" ");
		ss.setPlatinumList(Arrays.asList(split));
		ss.setGoldList(Arrays.asList(gssplit));
		ss.setSilverList(Arrays.asList(cssplit));
		
		expectedData.put(1, ss);
		Map<Integer, ScreenSeats> screenData = dataInputParser.parseData();

		Assert.assertEquals(expectedData.get(1).getGoldList(), screenData.get(1).getGoldList());
	}

}