package com.deanclancydev.backendproductmanagement.repository;

import com.deanclancydev.backendproductmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // findBy -> Username
    Optional<User> findByUserName(String username);
}
