package com.mtg.api.dto;

public class CardUpdateDto {

	private double newPrice;
	
	private int newQuantity;
	
	
	
	public CardUpdateDto() {
		
	}

	
	
	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public int getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(int newQuantity) {
		this.newQuantity = newQuantity;
	}
	
	
	
	
}
