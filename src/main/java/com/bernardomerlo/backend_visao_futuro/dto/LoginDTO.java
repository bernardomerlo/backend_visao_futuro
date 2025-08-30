package com.bernardomerlo.backend_visao_futuro.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String password
) {
}
