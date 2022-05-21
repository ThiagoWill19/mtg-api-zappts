package com.mtg.api.dto;

import com.mtg.api.models.Card;

public class NewCardDto {

	private int listId;
	
	private int userId;
	
	private Card card;
	
	
	public NewCardDto() {
		
	}


	public int getListId() {
		return listId;
	}


	public void setListId(int listId) {
		this.listId = listId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}
	
	
	
}
