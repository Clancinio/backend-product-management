package com.deanclancydev.backendproductmanagement.service.impl;

import com.deanclancydev.backendproductmanagement.dto.Transaction;
import com.deanclancydev.backendproductmanagement.entity.TransactionEntity;
import com.deanclancydev.backendproductmanagement.exceptions.DBException;
import com.deanclancydev.backendproductmanagement.repository.TransactionRepository;
import com.deanclancydev.backendproductmanagement.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.deanclancydev.backendproductmanagement.constants.ExceptionConstants.SERVICE_SAVE_TRANSACTION_EXCEPTION_MESSAGE;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final ObjectMapper objectMapper;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        try {
            final TransactionEntity transactionEntity = objectMapper.convertValue(transaction, TransactionEntity.class);
            transactionRepository.save(transactionEntity);
            return transaction;
        } catch (final Exception exception) {
            log.error(exception);
            throw new DBException(SERVICE_SAVE_TRANSACTION_EXCEPTION_MESSAGE, exception);
        }
    }

    @Override
    public Long numberOfTransactions() {
        return transactionRepository.count();
    }
}
