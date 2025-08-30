package com.bernardomerlo.backend_visao_futuro.dto;

import com.bernardomerlo.backend_visao_futuro.domain.Wallet;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record WalletResponseDTO(
        Long id,
        BigDecimal initialBalance,
        BigDecimal currentBalance,
        LocalDateTime createdAt,
        String username
) {
    public WalletResponseDTO(Wallet wallet) {
        this(
                wallet.getId(),
                wallet.getInitialBalance(),
                wallet.getCurrentBalance(),
                wallet.getCreatedAt(),
                wallet.getUser().getName()
        );
    }

}
