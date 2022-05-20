package com.mtg.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card implements Comparable<Card> {
	
	private static long serialVersionUID = 1L;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public static void setSerialVersionUID(long serialVersionUID) {
		Card.serialVersionUID = serialVersionUID;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, length = 60)
	private String name;
	
	@Column(nullable = false, length = 60)
	private String edition;
	
	@Column(nullable = false, length = 60)
	private String language;
	
	@Column(nullable = false)
	private boolean foil;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false)
	private int quantity;

	@ManyToMany(mappedBy = "cards")
	private List<CardList> cardLists = new ArrayList<>();

	public Card() {
		
	}

	public Card(int id, String name, String edition, String language, boolean foil, Double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.edition = edition;
		this.language = language;
		this.foil = foil;
		this.price = price;
		this.quantity = quantity;
	}

	public List<CardList> getCardLists() {
		return cardLists;
	}

	public String getEdition() {
		return edition;
	}

	public int getId() {
		return id;
	}

	public String getLanguage() {
		return language;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean isFoil() {
		return foil;
	}

	public void setCardLists(List<CardList> cardLists) {
		this.cardLists = cardLists;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public void setFoil(boolean foil) {
		this.foil = foil;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Card otherCard) {
		
		if(this.price > otherCard.getPrice()) return -1;
		
		if(this.price < otherCard.getPrice()) return 1;
		
		return 0;
	}

	
	
	
}
