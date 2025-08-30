package com.bernardomerlo.backend_visao_futuro.service;

import com.bernardomerlo.backend_visao_futuro.domain.Transaction;
import com.bernardomerlo.backend_visao_futuro.domain.User;
import com.bernardomerlo.backend_visao_futuro.domain.Wallet;
import com.bernardomerlo.backend_visao_futuro.dto.CreateTransactionDTO;
import com.bernardomerlo.backend_visao_futuro.enums.TransactionType;
import com.bernardomerlo.backend_visao_futuro.repository.TransactionRepository;
import com.bernardomerlo.backend_visao_futuro.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Transactional
    public Transaction createTransaction(CreateTransactionDTO transactionDTO, User user) {
        Wallet wallet = walletRepository.findByUser(user).orElseThrow(()-> new IllegalArgumentException("Conta não encontrada para o usuário"));

        BigDecimal newBalance;
        if(transactionDTO.type() == TransactionType.INCOME){
            newBalance = wallet.getCurrentBalance().add(transactionDTO.amount());
        }else{
            newBalance = wallet.getCurrentBalance().subtract(transactionDTO.amount());
        }
        wallet.setCurrentBalance(newBalance);
        walletRepository.save(wallet);

        Transaction transaction = new Transaction(null, wallet, transactionDTO.description(), transactionDTO.amount(), transactionDTO.type(), transactionDTO.date());
        return transactionRepository.save(transaction);
    }
}
