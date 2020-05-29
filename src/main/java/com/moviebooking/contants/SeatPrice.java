package com.moviebooking.contants;

public enum SeatPrice {
		
	PLATINUM(320),GOLD(280),SILVER(240);

	private Integer price;

	SeatPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	
	
	
	

}