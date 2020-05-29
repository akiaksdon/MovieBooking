package com.moviebooking.contants;

public enum  Audi{
	
	
	AUDI_1("A1_ALIST_IDENTIFIER","A1_BLIST_IDENTIFIER","A1_CLIST_IDENTIFIER"),
	AUDI_2("A2_ALIST_IDENTIFIER","A2_BLIST_IDENTIFIER","A2_CLIST_IDENTIFIER");

	private String PLATINUM;
	private String GOLD;
	private String SILVER;

	Audi(String platinum,String gold,String silver) {
		this.PLATINUM = platinum;
		this.GOLD = gold;
		this.SILVER = silver;
	}

	public String getPLATINUM() {
		return this.PLATINUM;
	}

	public String getGOLD() {
		return this.GOLD;
	}

	public String getSILVER() {
		return this.SILVER;
	}
	
	
			
	
	
}