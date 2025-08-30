package com.bernardomerlo.backend_visao_futuro.repository;

import com.bernardomerlo.backend_visao_futuro.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
