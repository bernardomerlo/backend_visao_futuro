package com.bernardomerlo.backend_visao_futuro.service;

import com.bernardomerlo.backend_visao_futuro.domain.User;
import com.bernardomerlo.backend_visao_futuro.domain.Wallet;
import com.bernardomerlo.backend_visao_futuro.dto.WalletResponseDTO;
import com.bernardomerlo.backend_visao_futuro.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public WalletResponseDTO getWalletByUser(User user){
        Wallet wallet = walletRepository.findByUser(user).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        return new WalletResponseDTO(wallet);
    }

}
