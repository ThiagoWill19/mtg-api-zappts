package com.mtg.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtg.api.models.Card;

public interface CardRepository extends JpaRepository<Card, Integer>{


}
