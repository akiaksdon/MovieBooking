package com.moviebooking.model;

import java.util.List;

public class ScreenSeats {
	
	private List<String> platinumList;
	private List<String> goldList;
	private List<String> silverList;
	
	
	public List<String> getPlatinumList() {
		return platinumList;
	}
	public List<String> getGoldList() {
		return goldList;
	}
	public List<String> getSilverList() {
		return silverList;
	}
	public void setPlatinumList(List<String> platinumList) {
		this.platinumList = platinumList;
	}
	public void setGoldList(List<String> goldList) {
		this.goldList = goldList;
	}
	public void setSilverList(List<String> silverList) {
		this.silverList = silverList;
	}
	
	
	

}