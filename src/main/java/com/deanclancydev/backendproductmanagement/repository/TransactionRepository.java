package com.deanclancydev.backendproductmanagement.repository;

import com.deanclancydev.backendproductmanagement.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
