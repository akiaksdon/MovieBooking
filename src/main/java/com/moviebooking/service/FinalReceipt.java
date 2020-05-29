package com.moviebooking.service;

import java.util.List;
import java.util.Map;

import com.moviebooking.contants.SeatPrice;
import com.moviebooking.model.ScreenSeats;

public class FinalReceipt {
	private Map<Integer, List<String>> bookingList;
	private Map<Integer, ScreenSeats> screenData;
	private Double finalCalculatedValue;
	private ReceiptPrinter receiptPrinter=null;
	

	public ReceiptPrinter getReceiptPrinter() {
		return receiptPrinter;
	}


	public void setReceiptPrinter(ReceiptPrinter receiptPrinter) {
		this.receiptPrinter = receiptPrinter;
	}


	public FinalReceipt(Map<Integer, List<String>> processInput, Map<Integer, ScreenSeats> parseData) {
		this.bookingList = processInput;
		this.screenData = parseData;
		
	}


	public Map<Integer, List<String>> getBookingList() {
		return bookingList;
	}


	public Map<Integer, ScreenSeats> getScreenData() {
		return screenData;
	}


	public Double getFinalCalculatedValue() {
		return finalCalculatedValue;
	}


	public void setBookingList(Map<Integer, List<String>> bookingList) {
		this.bookingList = bookingList;
	}


	public void setScreenData(Map<Integer, ScreenSeats> screenData) {
		this.screenData = screenData;
	}

	public Integer calculateFinalValue(){
		Integer seatTotal = 0;
		Object sn = getBookingList().keySet().toArray()[0];
		Integer scrennNumber = Integer.valueOf((int) sn);
		ScreenSeats screenSeatsData = getScreenData().get(scrennNumber);
		List<String> bookingList = getBookingList().get(scrennNumber);
		for(String seat :bookingList) {
			if(screenSeatsData.getPlatinumList().contains(seat)) {
				//platinum seat 
				seatTotal = seatTotal + SeatPrice.PLATINUM.getPrice();
			}
			if(screenSeatsData.getGoldList().contains(seat)) {
				//gold seat 
				seatTotal = seatTotal + SeatPrice.GOLD.getPrice();
			}
			if(screenSeatsData.getSilverList().contains(seat)) {
				//silver seat 
				seatTotal = seatTotal + SeatPrice.SILVER.getPrice();

			}
			
		}
		ReceiptPrinter receiptPrinter2 = new ReceiptPrinter(Double.valueOf(seatTotal), scrennNumber, bookingList);
		this.setReceiptPrinter(receiptPrinter2);
		return seatTotal;
	}
	
	public void printReceipt() {
		receiptPrinter.print();
	}

}
