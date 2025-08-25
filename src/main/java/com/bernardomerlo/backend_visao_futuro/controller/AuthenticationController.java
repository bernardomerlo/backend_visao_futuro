package com.bernardomerlo.backend_visao_futuro.controller;

import com.bernardomerlo.backend_visao_futuro.dto.RegisterDTO;
import com.bernardomerlo.backend_visao_futuro.infra.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO){
        try{
            authenticationService.registerUser(registerDTO);
            return ResponseEntity.ok("Usuário registrado com sucesso");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
