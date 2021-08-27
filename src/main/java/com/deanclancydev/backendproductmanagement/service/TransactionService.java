package com.deanclancydev.backendproductmanagement.service;

import com.deanclancydev.backendproductmanagement.dto.Transaction;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    Long numberOfTransactions();
}
