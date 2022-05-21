package com.mtg.api.dto;

public class DeleteCardDto {

	private int cardId;
	
	private int userId;
	
	private int listId;
	
	
	public DeleteCardDto() {
		
	}


	public int getCardId() {
		return cardId;
	}


	public void setCardId(int cardId) {
		this.cardId = cardId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getListId() {
		return listId;
	}


	public void setListId(int listId) {
		this.listId = listId;
	}
	
	
	
}
