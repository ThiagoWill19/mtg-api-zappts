package com.mtg.api.dto;

import java.util.List;

import com.mtg.api.models.Card;

public class ListDto {
	
	private int id;
	
	private String ListName;
	
	private String userName;
	
	private List<Card> cards;
	
	public ListDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return ListName;
	}

	public void setListName(String listName) {
		ListName = listName;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
	
	
}
