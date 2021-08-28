package com.deanclancydev.backendproductmanagement.service;

import com.deanclancydev.backendproductmanagement.dto.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    List<Transaction> findAllTransactions();

    Long numberOfTransactions();
}
