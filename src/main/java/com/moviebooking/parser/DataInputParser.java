package com.moviebooking.parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.moviebooking.contants.PatternMatcher;
import com.moviebooking.model.ScreenSeats;

public class DataInputParser implements parser {

	private List<String> inputString;

	public DataInputParser(List<String> inputString) {
		super();
		this.inputString = inputString;
	}


	@Override
	public Map<Integer, ScreenSeats> parseData() {

		
		Map<Integer,ScreenSeats> screenMap = new HashMap<>();
		int screenNumber = 0;
		
		
		for (String string : inputString) {
			PatternMatcher[] values = PatternMatcher.values();
			Matcher match = null;
			for (PatternMatcher value : values) {
				Boolean found = false;
				switch(value.name()) {
				
				case "SCREEN_IDENTIFIER":
					match = extracted(string,value);
					if(match!=null) {
						if(match.find()) {
							screenNumber = Integer.parseInt(match.group(2));
							found = true;
							break;
						}
					}
					break;
				
				case "ALIST_IDENTIFIER":
					match = extracted(string,value);
					if(match!=null) {
						if (match.find()) {
							String[] split = string.split(" ");
							List<String> aList = Arrays.asList(split);
							if(!screenMap.containsKey(screenNumber)) {
								screenMap.put(screenNumber, new ScreenSeats());
								screenMap.get(screenNumber).setPlatinumList(aList);
								
							}
							found=true; 
							break;
						}
					}
					break;
				case "BLIST_IDENTIFIER":
					match = extracted(string,value);
					if(match!=null) {
						if (match.find()) {
							String[] split = string.split(" ");
							List<String> bList = Arrays.asList(split);
							if(screenMap.containsKey(screenNumber)) {
								screenMap.get(screenNumber).setGoldList(bList);								
							}
							found=true; 
							break;
						}
					}
					break;
				case "CLIST_IDENTIFIER":
					match = extracted(string,value);
					if(match!=null) {
						if (match.find()) {
							String[] split = string.split(" ");
							List<String> cList = Arrays.asList(split);
							if(screenMap.containsKey(screenNumber)) {
								screenMap.get(screenNumber).setSilverList(cList);								
							}
							found=true; 
							break;
						}
					}
					break;
				default:
					break;
					
				}
				
				if(found) {
					break;
				}
				
				
			}
			

		}
		
		return screenMap;
	}


	private Matcher extracted(String string,PatternMatcher identifier) {
		Pattern patternText = Pattern.compile(identifier.getRegexPattern());
		Matcher match = patternText.matcher(string);
		return match;
	}

	private String group(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
