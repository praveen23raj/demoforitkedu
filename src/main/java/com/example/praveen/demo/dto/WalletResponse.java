package com.example.praveen.demo.dto;


import java.math.BigDecimal;
import java.util.UUID;

public class WalletResponse {
    private UUID walletId;
    private BigDecimal balance;

    public WalletResponse(UUID walletId, BigDecimal balance) {
        this.walletId = walletId;
        this.balance = balance;
    }

    // getters
    public UUID getWalletId() { return walletId; }
    public BigDecimal getBalance() { return balance; }
}
