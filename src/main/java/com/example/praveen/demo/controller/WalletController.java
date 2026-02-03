package com.example.praveen.demo.controller;



import com.example.praveen.demo.dto.WalletRequest;
import com.example.praveen.demo.dto.WalletResponse;
import com.example.praveen.demo.service.WalletService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public WalletResponse handleWalletOperation(@RequestBody WalletRequest request) {
        return walletService.processOperation(request);
    }

    @GetMapping("/{walletId}")
    public WalletResponse getWalletBalance(@PathVariable UUID walletId) {
        return walletService.getBalance(walletId);
    }
}