package com.moviebooking;

import java.util.Scanner;

import com.moviebooking.service.RevenueService;
import com.moviebooking.service.TaxCalculatorService;
import com.moviebooking.service.TaxCalculatorServiceImpl;

public class main {

	private static TaxCalculatorService taxCalculatorService = TaxCalculatorServiceImpl.getServiceInstance();
	private static RevenueService revenueService = RevenueService.getServiceInstance(); 


	public static void main(String [] args){
//		taxCalculatorService.calculateTax(args[0]);
		
		Boolean flag = Boolean.FALSE;
		do {
			try {
				taxCalculatorService.calculateFinalReceipt();
				System.out.println();
				System.out.println("Do you want to print Revenue and quit?");
				Scanner s = new Scanner(System.in);
				String nextLine = s.nextLine();
				if("Y".equalsIgnoreCase(nextLine)) {
					flag = Boolean.TRUE;
					System.out.println();
					System.out.println();
					revenueService.printRevenueCounts();
					System.out.println();
					System.out.println();
					System.out.println("-----------------------");
					System.out.println("-----THANK YOU!---------");
					System.out.println("------------------------");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Incorect input try again");
				System.out.print("\033[H\033[2J");  
			    System.out.flush();
			}
			
			
		}while(Boolean.FALSE.equals(flag));
		
	}

	

}
