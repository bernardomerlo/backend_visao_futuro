package com.bernardomerlo.backend_visao_futuro.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record RegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        @CPF
        String cpf,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String password,

        @NotBlank
        @PositiveOrZero
        BigDecimal initialBalance
) {
}
