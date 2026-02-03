package com.example.praveen.demo.service;

public class InvalidWalletRequestException extends RuntimeException {
    public InvalidWalletRequestException(String message) { super(message); }
}
