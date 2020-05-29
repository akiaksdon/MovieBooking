package com.moviebooking.contants;
public enum  PatternMatcher{
		
	SCREEN_IDENTIFIER("(^Show\\s+?)(\\d+)"),
	All_IDENTIFIER("(^All\\s+?)"),
	SEATING_IDENTIFIER("(^Seating\\s+?)"),
	ALIST_IDENTIFIER("(^A\\d\\s+?)"),
	BLIST_IDENTIFIER("(^B\\d\\s+?)"),
	CLIST_IDENTIFIER("(^C\\d\\s+?)"),
	;

	private String regexPattern;

	PatternMatcher(String regexPattern) {
		this.regexPattern = regexPattern;
	}
	
	public String getRegexPattern() {
		return this.regexPattern;
	}
	
}