package com.beardtrust.webapp.transactionservice.repos;

import com.beardtrust.webapp.transactionservice.entities.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, String> {
	Optional<TransactionType> findByTypeName(String transactionTypeName);
}
