package com.bernardomerlo.backend_visao_futuro.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank
        String nome,

        @NotBlank
        @CPF
        String cpf,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String senha
) {
}
