package com.bernardomerlo.backend_visao_futuro.controller;

import com.bernardomerlo.backend_visao_futuro.domain.User;
import com.bernardomerlo.backend_visao_futuro.dto.LoginDTO;
import com.bernardomerlo.backend_visao_futuro.dto.RegisterDTO;
import com.bernardomerlo.backend_visao_futuro.service.AuthenticationService;
import com.bernardomerlo.backend_visao_futuro.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO){
        try{
            authenticationService.registerUser(registerDTO);
            return ResponseEntity.ok("Usuário registrado com sucesso");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginDTO){
        var userNamePassword = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(token);
    }
}
