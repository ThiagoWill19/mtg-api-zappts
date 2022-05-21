package com.mtg.api.dto;



import javax.validation.constraints.NotNull;

import com.mtg.api.models.Card;

public class NewCardDto {

	@NotNull(message = "Insert listId")
	private Integer listId;
	
	@NotNull(message = "Insert userID")
	private Integer userId;
	
	@NotNull(message = "Card cannot be null")
	private Card card;
	
	
	public NewCardDto() {
		
	}


	public Integer getListId() {
		return listId;
	}


	public void setListId(Integer listId) {
		this.listId = listId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}
	
	
	
}
