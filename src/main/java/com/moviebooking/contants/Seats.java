package com.moviebooking.contants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum  Seats{
	
	 A1_ALIST_IDENTIFIER {
		@Override
		public List<String> returnList(){
			String values = "A1,A2,A3,A4,A5,A6";
			List<String> s =  Arrays.asList(values.split(","));
			return s;
		}
		
	},
	
	A1_BLIST_IDENTIFIER {
		@Override
		public List<String> returnList(){
			String values = "B1,B2,B3,B4,B5,B6";
			List<String> s =  Arrays.asList(values.split(","));
			return s;
		}
		
	},
	A1_CLIST_IDENTIFIER {
		@Override
		public List<String> returnList(){
			String values = "C1,C2,C3,C4,C5,C6";
			List<String> s =  Arrays.asList(values.split(","));
			return s;
		}
		
	},
	A2_ALIST_IDENTIFIER {
		@Override
		public List<String> returnList(){
			String values = "A1,A2,A3";
			List<String> s =  Arrays.asList(values.split(","));
			return s;
		}
		
	},
	
	A2_BLIST_IDENTIFIER {
		@Override
		public List<String> returnList(){
			String values = "B1,B2,B3,B4,B5,B6,B7";
			List<String> s =  Arrays.asList(values.split(","));
			return s;
		}
		
	},
	A2_CLIST_IDENTIFIER {
		@Override
		public List<String> returnList(){
			String values = "C1,C2";
			List<String> s =  Arrays.asList(values.split(","));
			return s;
		}
		
	};
	
	public abstract List<String> returnList();
		
	
	
}