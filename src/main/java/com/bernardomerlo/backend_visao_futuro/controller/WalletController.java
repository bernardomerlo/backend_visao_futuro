package com.bernardomerlo.backend_visao_futuro.controller;

import com.bernardomerlo.backend_visao_futuro.domain.User;
import com.bernardomerlo.backend_visao_futuro.dto.WalletResponseDTO;
import com.bernardomerlo.backend_visao_futuro.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping
    public ResponseEntity<WalletResponseDTO> getWallet(@AuthenticationPrincipal User user){
        WalletResponseDTO walletResponseDTO = walletService.getWalletByUser(user);
        return ResponseEntity.ok(walletResponseDTO);
    }
}
