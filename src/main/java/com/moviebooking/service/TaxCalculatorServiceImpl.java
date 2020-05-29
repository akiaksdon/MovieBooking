package com.moviebooking.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.moviebooking.contants.Audi;
import com.moviebooking.contants.Seats;
import com.moviebooking.model.ScreenSeats;

public class TaxCalculatorServiceImpl implements TaxCalculatorService {
	
	private static TaxCalculatorServiceImpl INSTANCE;
	
	private  TaxCalculatorServiceImpl() {		
	}
	
	public static TaxCalculatorServiceImpl getServiceInstance() {
		if (INSTANCE == null)
			INSTANCE = new TaxCalculatorServiceImpl();
		return INSTANCE;
	}
	
	protected Object readResolve() {
		return INSTANCE;
	}

	@Override
	public void calculateFinalReceipt() {
		
//		InputReader allInputFilesReader = new FileReadOperationService().getAllInputFilesReader();
//		List<String> readInputFile = allInputFilesReader.readInputFile();
//		DataInputParser dataInputParser = new DataInputParser(readInputFile);
//		Map<Integer, ScreenSeats> parseData = dataInputParser.parseData();
		
		
		
		
		
		Map<Integer, ScreenSeats> prepareScreenData = prepareScreenData();
		
		
//		String data = InputData.ALIST_IDENTIFIER.getData();
//		String dataB = InputData.BLIST_IDENTIFIER.getData();
//		String datac = InputData.CLIST_IDENTIFIER.getData();
//		
//		String[] splitA = data.split(",");
//		String[] splitB = data.split(",");
//		String[] splitC = data.split(",");
		
		
		
		ScreenPrinter screenPrinter = new ScreenPrinter(prepareScreenData);
		Map<Integer, List<String>> processInput = processInput(screenPrinter,prepareScreenData);
		FinalReceipt finalReceipt = new FinalReceipt(processInput,prepareScreenData);
		finalReceipt.calculateFinalValue();
		finalReceipt.printReceipt();
	
	}
	
	
		private Map<Integer, ScreenSeats> prepareScreenData() {
		// TODO Auto-generated method stub
			Map<Integer,ScreenSeats> preparedScreenData = new HashMap<>();
			Audi[] audiValues = Audi.values();
			Seats[] seatValues = Seats.values();
			Integer screenNo =1;
			for(Audi audi : audiValues ) {
				ScreenSeats screenSeats = new ScreenSeats();
				preparedScreenData.put(screenNo,screenSeats );
				for(Seats seat : seatValues) {
					if(audi.getPLATINUM().equalsIgnoreCase(seat.name())) {
						if(preparedScreenData.containsKey(screenNo)) {
							preparedScreenData.get(screenNo).setPlatinumList(seat.returnList());
						}
					}
					if(audi.getGOLD().equalsIgnoreCase(seat.name())) {
						if(preparedScreenData.containsKey(screenNo)) {
							preparedScreenData.get(screenNo).setGoldList(seat.returnList());
						}
					}
					if(audi.getSILVER().equalsIgnoreCase(seat.name())) {
						if(preparedScreenData.containsKey(screenNo)) {
							preparedScreenData.get(screenNo).setSilverList(seat.returnList());
						}
					}
					
				}
				screenNo++;
			}
			
			return preparedScreenData;
			
		
	}

		private static Map<Integer, List<String>> processInput(ScreenPrinter screenPrinter,Map<Integer, ScreenSeats> parseData) {
			Boolean valid = Boolean.FALSE;
			Map<Integer,List<String>> asList = new HashMap<>();
			do {
				try {
					System.out.println();
					System.out.println("Please Enter the screen number to Book: ");
					Scanner s = new Scanner(System.in);
					int screenNumber = Integer.parseInt(s.nextLine());
					screenPrinter.printSpecificScreen(screenNumber);
					System.out.println("Please Enter the number of tickets: ");
					int numberOfTckts= Integer.parseInt(s.nextLine());
					
					String[] arItems = s.nextLine().split(",");
					s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
					
					 List<String> seatlist = Arrays.asList(arItems);
					 valid = checkAvailibility(screenNumber,seatlist,parseData);
					 
					 if(valid) {
						 asList.put(screenNumber, seatlist);
					 }
					 else {
						 System.out.println("Seat not available try again");
						 System.out.print("\033[H\033[2J");  
						 System.out.flush();
						    
					 }
				} catch (NumberFormatException e) {
					System.out.println("Incorect input try again");
					System.out.print("\033[H\033[2J");  
				    System.out.flush();
				}
				
				
			}while(Boolean.FALSE.equals(valid));
			return asList;
			
		}

		

	private static boolean checkAvailibility(Integer screenNumber, List<String> asList,
			Map<Integer, ScreenSeats> parseData) {
		boolean containsAll = false;
		List<String> collect = asList.stream().distinct().collect(Collectors.toList());
		 if(collect.size()==asList.size()) {
			 
			 List<String> s = new ArrayList<String>();
			 ScreenSeats screenSeats = parseData.get(screenNumber);
			 s.addAll(screenSeats.getPlatinumList());
			 s.addAll(screenSeats.getGoldList());
			 s.addAll(screenSeats.getSilverList());
			 
			  containsAll = s.containsAll(asList);
		 }

		return containsAll;

	}
	

}