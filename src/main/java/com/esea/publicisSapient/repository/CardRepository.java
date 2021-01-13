package com.esea.publicisSapient.repository;

import com.esea.publicisSapient.repository.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardRepository extends JpaRepository<Card, Long> {
/*
* JPA repository for Card Entity in DB
* */

}
