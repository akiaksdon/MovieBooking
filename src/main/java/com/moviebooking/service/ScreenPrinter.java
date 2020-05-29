package com.moviebooking.service;

import java.util.HashMap;
import java.util.Map;

import com.moviebooking.model.ScreenSeats;

public class ScreenPrinter implements Printer {

	private Map<Integer, ScreenSeats> scrennInfo = new HashMap<Integer, ScreenSeats>();
	
	ScreenPrinter(Map<Integer, ScreenSeats> scrennInfo){
		this.scrennInfo = scrennInfo;
	}
	
	@Override
	public void print() {
		
		scrennInfo.forEach((k,v) -> {
			System.out.println("----------------------------------------- ");
			System.out.println("Screen: " + k);
			System.out.println("platinum seats: " + v.getPlatinumList());
			System.out.println("gold seats: " + v.getGoldList());
			System.out.println("silver seats: " + v.getSilverList());
			System.out.println("----------------------------------------- ");
			
		});
		
	}
	
	public void printSpecificScreen(Integer screenNumber) {
		
		scrennInfo.forEach((k,v) -> {
			if(k==screenNumber) {
				
				System.out.println("----------------------------------------- ");
				System.out.println("Screen: " + k);
				System.out.println("platinum seats: " + v.getPlatinumList());
				System.out.println("gold seats: " + v.getGoldList());
				System.out.println("silver seats: " + v.getSilverList());
				System.out.println("----------------------------------------- ");
			}
			
		});
		
	}

}
