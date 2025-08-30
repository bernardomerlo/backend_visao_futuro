package com.bernardomerlo.backend_visao_futuro.dto;

import com.bernardomerlo.backend_visao_futuro.enums.TransactionType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateTransactionDTO(
        String description,

        @NotNull
        @Positive
        BigDecimal amount,

        @NotNull
        TransactionType type,

        @NotNull
        LocalDate date

) {
}
