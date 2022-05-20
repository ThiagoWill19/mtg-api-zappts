package com.mtg.api.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "lists")
public class CardList {

	private static long serialVersionUID = 1L;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public static void setSerialVersionUID(long serialVersionUID) {
		CardList.serialVersionUID = serialVersionUID;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, length = 60)
	private String listName;
		
	@ManyToMany
	@JoinTable(name = "lists_cards",
			joinColumns = {@JoinColumn(name = "list_id")},
			inverseJoinColumns = {@JoinColumn(name = "card_id")})
	@JsonIgnoreProperties({"cardList"})
	private Set<Card> cards;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties({"lists"})
	private User userOwner;

	public CardList() {
		
	}

	public CardList(int id, String listName, User userOwner) {
		super();
		this.id = id;
		this.listName = listName;
		this.userOwner = userOwner;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public int getId() {
		return id;
	}

	public String getListName() {
		return listName;
	}

	public User getUserOwner() {
		return userOwner;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}
	
	
}
