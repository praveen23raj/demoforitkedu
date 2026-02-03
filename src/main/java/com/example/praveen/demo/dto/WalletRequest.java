package com.example.praveen.demo.dto;



import java.math.BigDecimal;
import java.util.UUID;

public class WalletRequest {
    private UUID walletId;
    private String operationType; // "DEPOSIT" or "WITHDRAW"
    private BigDecimal amount;

    // getters and setters
    public UUID getWalletId() { return walletId; }
    public void setWalletId(UUID walletId) { this.walletId = walletId; }
    public String getOperationType() { return operationType; }
    public void setOperationType(String operationType) { this.operationType = operationType; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
