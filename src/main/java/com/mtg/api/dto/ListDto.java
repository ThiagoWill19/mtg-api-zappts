package com.mtg.api.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mtg.api.models.Card;
import com.mtg.api.models.CardList;

public class ListDto {
	
	private int id;
	
	private String ListName;
	
	private String userName;
	
	@JsonIgnoreProperties({"cardLists"})
	private Set<Card> cards;
	
	
	public ListDto() {
		
	}
	
	public static ListDto ToDto(CardList cardList) {
		
		ListDto listDto = new ListDto();
		
		listDto = new ListDto();
		listDto.setId(cardList.getId());
		listDto.setListName(cardList.getListName());
		listDto.setUserName(cardList.getUserOwner().getName());
		listDto.setCards(cardList.getCards());
		
		return listDto;
		
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

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
	
	
}
