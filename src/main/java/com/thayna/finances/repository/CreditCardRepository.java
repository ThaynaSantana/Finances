package com.thayna.finances.repository;

import com.thayna.finances.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> findByUserId(Long userId); 
}