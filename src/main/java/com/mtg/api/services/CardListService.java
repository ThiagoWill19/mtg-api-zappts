package com.mtg.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtg.api.dto.CardUpdateDto;
import com.mtg.api.dto.ListDto;
import com.mtg.api.dto.NewCardList;
import com.mtg.api.models.Card;
import com.mtg.api.models.CardList;
import com.mtg.api.models.User;
import com.mtg.api.repositories.CardListRepository;
import com.mtg.api.repositories.CardRepository;
import com.mtg.api.repositories.UserRepository;

@Service
public class CardListService {

	@Autowired
	private CardListRepository repository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private UserRepository userRepository;

	
	
	public ListDto save(NewCardList newCardList) throws Exception{
		
		if(!repository.existsByListName(newCardList.getListName())) {
			
			if(userRepository.existsById(newCardList.getUserId())) {
				
				User user = userRepository.findById(newCardList.getUserId()).get();
				
				CardList cardList = new CardList();
				
				cardList.setListName(newCardList.getListName());
				
				cardList.setUserOwner(user);
			    
				return ListDto.ToDto(repository.save(cardList));
			
			}else throw new Exception("User not found");	
			
		}else throw new Exception("This card name already exists");
	}
	
	
	public List<ListDto> getAll() {

		List<ListDto> lists = new ArrayList<>();

		List<CardList> cardLists = repository.findAll();

		for (CardList c : cardLists) {

			lists.add(ListDto.ToDto(c));
		}

		return lists;

	}

	public ListDto findById(int id) throws Exception {

		if (repository.existsById(id)) {

			return ListDto.ToDto(repository.findById(id).get());

		} else
			throw new Exception("Card not found!");

	}

	public ListDto findByListName(String listName) throws Exception {
		
		if (repository.existsByListName(listName)) {

			return ListDto.ToDto(repository.findByListName(listName));

		} else
			throw new Exception("Card not found!");
	}
	
	public ListDto addCard(int listId, int userId, Card card) throws Exception{
		
		if(repository.existsById(listId)) {
			
			CardList cardList = repository.getById(listId);
			
			if(cardList.getUserOwner().getId() == userId) {
				
				cardList.getCards().add(card);
				repository.save(cardList);
				
				return ListDto.ToDto(cardList);
				
			}else throw new Exception("This list does not belong to this userId!");
			
		}else throw new Exception("List not found!");
		
	}
	
	public boolean removeCard(int listId, int userId, int cardId) throws Exception{
		
		if(repository.existsById(listId)) {
			
			CardList cardList = repository.getById(listId);
			
			if(cardList.getUserOwner().getId() == userId) {
				
				if(cardRepository.existsById(cardId)) {
					
					if(cardRepository.findById(cardId).get().getCardLists().contains(cardList)) {
						
						cardRepository.deleteById(cardId);
						return true;
						
					}else throw new Exception("this card does not belong to this list!");
					
				}else throw new Exception("Card not found!");
				
			} else throw new Exception("This list does not belong to this userId!");
			
		}else throw new Exception("List not found!");
	}
	
	public boolean updateCard(int listId, int userId, int cardId, CardUpdateDto cardUpdateDto) throws Exception{
		
		if(repository.existsById(listId)) {
			
			CardList cardList = repository.getById(listId);
			
			if(cardList.getUserOwner().getId() == userId) {
				
				if(cardRepository.existsById(cardId)) {
					
					if(cardRepository.findById(cardId).get().getCardLists().contains(cardList)) {
						
						Card card = cardRepository.findById(cardId).get();
						
						if(cardUpdateDto.getNewPrice() != 0) {
							card.setPrice(cardUpdateDto.getNewPrice());
						}
						if(cardUpdateDto.getNewQuantity() != 0 ) {
							card.setQuantity(cardUpdateDto.getNewQuantity());
						}
						
						cardRepository.save(card);
						return true;
						
					}else throw new Exception("this card does not belong to this list!");
					
				}else throw new Exception("Card not found!");
				
			} else throw new Exception("This list does not belong to this userId!");
			
		}else throw new Exception("List not found!");
		
	}

}
