package com.bernardomerlo.backend_visao_futuro.dto;

import com.bernardomerlo.backend_visao_futuro.domain.Transaction;
import com.bernardomerlo.backend_visao_futuro.enums.TransactionType;

public record TransactionResponseDTO(
        Long id,
        TransactionType type,
        String description,
        String category,
        String date,
        String amount
) {
    public TransactionResponseDTO(Transaction transaction) {
        this(
                transaction.getId(),
                transaction.getType(),
                transaction.getDescription(),
                transaction.getType().toString(),
                transaction.getDate().toString(),
                transaction.getAmount().toString()
        );
    }
}
