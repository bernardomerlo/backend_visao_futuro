package com.bernardomerlo.backend_visao_futuro.controller;

import com.bernardomerlo.backend_visao_futuro.domain.Transaction;
import com.bernardomerlo.backend_visao_futuro.domain.User;
import com.bernardomerlo.backend_visao_futuro.dto.CreateTransactionDTO;
import com.bernardomerlo.backend_visao_futuro.dto.CreateTransactionResponseDTO;
import com.bernardomerlo.backend_visao_futuro.dto.TransactionResponseDTO;
import com.bernardomerlo.backend_visao_futuro.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getTransactions(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate
    ) {
        List<TransactionResponseDTO> transactions = this.transactionService.getTransactions(user, startDate, endDate);
        return ResponseEntity.ok(transactions);
    }
}
