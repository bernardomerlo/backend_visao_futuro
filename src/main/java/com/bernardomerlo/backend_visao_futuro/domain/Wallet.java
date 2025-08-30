package com.bernardomerlo.backend_visao_futuro.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Wallet")
@Table(name = "wallets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name="initial_balance", nullable = false)
    private BigDecimal initialBalance;

    @Column(name="current_balance", nullable = false)
    private BigDecimal currentBalance;

    @Column(name="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Wallet(User user, BigDecimal initialBalance){
        this.user = user;
        this.initialBalance = initialBalance;
        this.currentBalance = initialBalance;
        this.createdAt = LocalDateTime.now();
    }
}
