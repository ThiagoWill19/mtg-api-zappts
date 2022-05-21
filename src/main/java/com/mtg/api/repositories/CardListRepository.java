package com.mtg.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtg.api.models.CardList;

public interface CardListRepository extends JpaRepository<CardList, Integer>{

	boolean existsByListName(String listName);
	
	CardList findByListName(String listName);
}
