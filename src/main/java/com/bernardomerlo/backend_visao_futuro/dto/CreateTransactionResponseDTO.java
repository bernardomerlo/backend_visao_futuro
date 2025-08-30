package com.bernardomerlo.backend_visao_futuro.dto;

import com.bernardomerlo.backend_visao_futuro.domain.Transaction;
import com.bernardomerlo.backend_visao_futuro.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateTransactionResponseDTO(
        Long id,
        String description,
        BigDecimal amount,
        TransactionType type,
        LocalDate date
) {

    public CreateTransactionResponseDTO(Transaction transaction){
        this(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getDate()
        );
    }
}
