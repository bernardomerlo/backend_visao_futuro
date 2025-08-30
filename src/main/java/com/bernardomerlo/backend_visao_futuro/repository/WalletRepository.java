package com.bernardomerlo.backend_visao_futuro.repository;

import com.bernardomerlo.backend_visao_futuro.domain.User;
import com.bernardomerlo.backend_visao_futuro.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUser(User user);
}
