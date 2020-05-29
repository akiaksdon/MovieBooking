package com.moviebooking.parser;

import java.util.Map;

import com.moviebooking.model.ScreenSeats;

public interface parser {
	
	Map<Integer, ScreenSeats> parseData();
	
	
}