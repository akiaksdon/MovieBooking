package com.moviebooking.service;
public class RevenueService {
	
	private static RevenueService INSTANCE;
	private Double revenueCount;
	private Double serviceTaxCount;
	private Double swachTaxCount;
	private Double krishiTaxCount;
	
	private  RevenueService() {
		this.revenueCount = 0d;
		this.serviceTaxCount = 0d;
		this.swachTaxCount = 0d;
		this.krishiTaxCount = 0d;
	}
	
	public Double getRevenueCount() {
		return revenueCount;
	}

	public Double getServiceTaxCount() {
		return serviceTaxCount;
	}

	public Double getSwachTaxCount() {
		return swachTaxCount;
	}

	public Double getKrishiTaxCount() {
		return krishiTaxCount;
	}

	public void incrementRevenueTaxCount(double total) {
		this.revenueCount = this.revenueCount + total;
	}

	public void incrementServiceTaxCount(Double serviceTaxCount) {
		this.serviceTaxCount = this.serviceTaxCount + serviceTaxCount;
	}

	public void incrementSwachTaxCount(Double swachTaxCount) {
		this.swachTaxCount = this.swachTaxCount + swachTaxCount;
	}

	public void incrementKrishiTaxCount(Double krishiTaxCount) {
		this.krishiTaxCount = this.krishiTaxCount + krishiTaxCount;
	}

	public static RevenueService getServiceInstance() {
		if (INSTANCE == null)
			INSTANCE = new RevenueService();
		return INSTANCE;
	}
	
	public void printRevenueCounts() {
		System.out.println();
		System.out.println("Revenue: "+ getRevenueCount());
		System.out.println("Service Tax: Rs." + getServiceTaxCount());
		System.out.println("Swacch Bharat Cess Tax: Rs." + getSwachTaxCount());
		System.out.println("Krishi Kalya Cess Tax: Rs." + getKrishiTaxCount());
		
	}
	
	protected Object readResolve() {
		return INSTANCE;
	}	
	

}