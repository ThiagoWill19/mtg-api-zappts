package com.mtg.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtg.api.dto.CardUpdateDto;
import com.mtg.api.dto.DeleteCardDto;
import com.mtg.api.dto.ListDto;
import com.mtg.api.dto.NewCardDto;
import com.mtg.api.dto.NewCardList;
import com.mtg.api.services.CardListService;

@RestController
@RequestMapping("/lists")
public class CardListController {

	@Autowired
	private CardListService service;
	
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody NewCardList newCardList){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newCardList));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<ListDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}
	
	@GetMapping("/{listname}")
	public ResponseEntity<Object> findByListName(@PathVariable("listname") String listName){
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findByListName(listName));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCard(@Valid @RequestBody NewCardDto newCard){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.addCard(newCard.getListId(), newCard.getUserId(), newCard.getCard()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/remove")
	public ResponseEntity<Object> removeCard(@RequestBody DeleteCardDto deleteCard){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.removeCard(deleteCard.getListId(), deleteCard.getUserId(), deleteCard.getCardId()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateCard(@RequestBody CardUpdateDto updateCard){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.updateCard(updateCard));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
