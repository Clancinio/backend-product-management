package com.deanclancydev.backendproductmanagement.repository;

import com.deanclancydev.backendproductmanagement.dto.User;
import com.deanclancydev.backendproductmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // findBy -> Username
    Optional<UserEntity> findByUserName(String userName);
}
