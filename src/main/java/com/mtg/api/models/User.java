package com.mtg.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
public class User {
	
	private static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(nullable = false, length = 60, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "userOwner")
	@JsonIgnoreProperties({"userOwner"})
	private List<CardList> lists = new ArrayList<>();
	
	private User() {
		
	}
	
	private User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		User.serialVersionUID = serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<CardList> getLists() {
		return lists;
	}
	
	public void setLists(List<CardList> lists) {
		this.lists = lists;
	}
}
