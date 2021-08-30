package com.deanclancydev.backendproductmanagement.service;

import com.deanclancydev.backendproductmanagement.dto.User;

import java.util.List;

public interface UserService {

    User saveUser(final User user);

    User updateUser(final User user);

    void deleteUser(Long id);

    User findByUsername(String userName);

    List<User> findAllUsers();

    String numberOfUsers();
}
