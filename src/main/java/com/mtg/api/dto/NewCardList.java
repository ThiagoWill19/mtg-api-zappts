package com.mtg.api.dto;

public class NewCardList {

	private String listName;
	
	private int userId;
	
	public NewCardList() {
		
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
