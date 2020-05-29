package com.moviebooking.service;

import java.util.List;

import com.moviebooking.contants.Tax;

public class ReceiptPrinter implements Printer {
	
	Double totalRevenue;
	Integer screenNumber;
	List<String> bookingList;
	private static RevenueService revenueService = RevenueService.getServiceInstance(); 

	
	

	public ReceiptPrinter(Double totalRevenue, Integer screenNumber, List<String> bookingList) {
		super();
		this.totalRevenue = totalRevenue;
		this.screenNumber = screenNumber;
		this.bookingList = bookingList;
	}



	@Override
	public void print() {
		double calculateServiceTx = calculateServiceTx();
		double calculateSwacchTx = calculateSwacchTx();
		double calculateKrishiTx = calculateKrishiTx();
		double total = calculateServiceTx + calculateSwacchTx + calculateKrishiTx + totalRevenue;
		incRevenueCount(totalRevenue);
		System.out.println("SuccesfullyBooked-Show " + screenNumber.toString());
		System.out.println("Subtotal: Rs." + totalRevenue);
		System.out.println("Service Tax: Rs." + calculateServiceTx);
		System.out.println("Swacch Bharat Cess Tax: Rs." + calculateSwacchTx);
		System.out.println("Krishi Kalya Cess Tax: Rs." + calculateKrishiTx);
		System.out.println("Total: Rs." + total);
		
		

	}



	private void incRevenueCount(double total) {
		revenueService.incrementRevenueTaxCount(total);
	}



	private double calculateServiceTx() {
		double d = (Tax.SERVICE_TAX.getTax()/100) * totalRevenue;
		revenueService.incrementServiceTaxCount(d);
		return d;
	}
	private double calculateSwacchTx() {
		double d = (Tax.SWACH_BHARAT_CESS.getTax()/100) * totalRevenue;
		revenueService.incrementSwachTaxCount(d);
		return d;
	}
	private double calculateKrishiTx() {
		double k = (Tax.KALYAN_CESS.getTax()/100) * totalRevenue;
		revenueService.incrementKrishiTaxCount(k);
		return k ;
	}

}
