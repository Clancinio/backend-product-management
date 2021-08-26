package com.deanclancydev.backendproductmanagement.service;

import com.deanclancydev.backendproductmanagement.dto.User;

public interface UserService {

    User saveUser(final User user);

    User updateUser(final User user);

    void deleteUser(Long id);
}
