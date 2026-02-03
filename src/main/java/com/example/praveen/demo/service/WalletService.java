package com.example.praveen.demo.service;

import com.example.praveen.demo.dto.WalletRequest;
import com.example.praveen.demo.dto.WalletResponse;
import com.example.praveen.demo.entity.Wallet;

import com.example.praveen.demo.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    @Transactional(readOnly = true)
    public WalletResponse getBalance(UUID walletId) {
        Wallet wallet = walletRepository.findByIdReadOnly(walletId)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found"));
        return new WalletResponse(wallet.getId(), wallet.getBalance());
    }

    @Transactional
    public WalletResponse processOperation(WalletRequest request) {
        Wallet wallet = walletRepository.findByIdForUpdate(request.getWalletId())
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found"));

        BigDecimal amount = request.getAmount();
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        switch (request.getOperationType().toUpperCase()) {
            case "DEPOSIT":
                wallet.setBalance(wallet.getBalance().add(amount));
                break;
            case "WITHDRAW":
                if (wallet.getBalance().compareTo(amount) < 0) {
                    throw new IllegalArgumentException("Insufficient funds");
                }
                wallet.setBalance(wallet.getBalance().subtract(amount));
                break;
            default:
                throw new IllegalArgumentException("Invalid operation type");
        }

        walletRepository.save(wallet);
        return new WalletResponse(wallet.getId(), wallet.getBalance());
    }
}
