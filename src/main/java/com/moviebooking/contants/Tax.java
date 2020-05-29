package com.moviebooking.contants;

public enum  Tax{
		
	SERVICE_TAX(14.0),SWACH_BHARAT_CESS(0.5),KALYAN_CESS(0.5);

	private Double taxation;

	Tax(Double taxation) {
		this.taxation = taxation;
	}
	
	public Double getTax() {
		return this.taxation;
	}
	
}