package com.mtg.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtg.api.models.Card;
import com.mtg.api.repositories.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository repository;
	
	public Card save(Card card) throws Exception{
		
		if(card.getLanguage().equals("pt-br") || card.getLanguage().equals("en") || card.getLanguage().equals("jp")) {
			return repository.save(card);
		}else throw new Exception("The language should be in :pt-br, en, jp only!");
	}
}
