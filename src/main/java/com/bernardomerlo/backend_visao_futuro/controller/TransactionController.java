package com.bernardomerlo.backend_visao_futuro.controller;

import com.bernardomerlo.backend_visao_futuro.domain.Transaction;
import com.bernardomerlo.backend_visao_futuro.domain.User;
import com.bernardomerlo.backend_visao_futuro.dto.CreateTransactionDTO;
import com.bernardomerlo.backend_visao_futuro.dto.CreateTransactionResponseDTO;
import com.bernardomerlo.backend_visao_futuro.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<CreateTransactionResponseDTO> createTransaction(@RequestBody @Valid CreateTransactionDTO createTransactionDTO, @AuthenticationPrincipal User user) {
        Transaction newTransaction = this.transactionService.createTransaction(createTransactionDTO, user);
        CreateTransactionResponseDTO responseDTO = new CreateTransactionResponseDTO(newTransaction);
        return ResponseEntity.status(201).body(responseDTO);
    }

}
