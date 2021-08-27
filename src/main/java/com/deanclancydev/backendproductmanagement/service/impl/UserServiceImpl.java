package com.deanclancydev.backendproductmanagement.service.impl;


import com.deanclancydev.backendproductmanagement.dto.User;
import com.deanclancydev.backendproductmanagement.entity.UserEntity;
import com.deanclancydev.backendproductmanagement.exceptions.DBException;
import com.deanclancydev.backendproductmanagement.repository.UserRepository;
import com.deanclancydev.backendproductmanagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.deanclancydev.backendproductmanagement.constants.ExceptionConstants.*;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ObjectMapper objectMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        try {
            final UserEntity userEntity = objectMapper.convertValue(user, UserEntity.class);
            userRepository.save(userEntity);
            return objectMapper.convertValue(userEntity, User.class);
        } catch (final Exception exception) {
            log.error(exception);
            throw new DBException(SERVICE_SAVE_USER_EXCEPTION_MESSAGE, exception);
        }
    }

    @Override
    public User updateUser(User user) {
        try {
            final UserEntity userEntity = objectMapper.convertValue(user, UserEntity.class);
            userRepository.save(userEntity);
            return objectMapper.convertValue(userEntity, User.class);
        } catch (final Exception exception) {
            log.error(exception);
            throw new DBException(SERVICE_UPDATE_USER_EXCEPTION_MESSAGE, exception);
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (final Exception exception) {
            log.error(exception);
            throw new DBException(SERVICE_DELETE_USER_EXCEPTION_MESSAGE, exception);
        }
    }

    @Override
    public User findByUsername(String userName) {
        try {
            final Optional<UserEntity> userEntity = userRepository.findByUserName(userName);
            if (userEntity.isPresent()) {
                return objectMapper.convertValue(userEntity, User.class);
            } else {
                throw new DBException(String.format(SERVICE_FIND_BY_USERNAME_EXCEPTION_MESSAGE, userName));
            }
        } catch (final Exception exception) {
            log.error(exception);
            throw exception;
        }
    }

    @Override
    public List<User> findAllUsers() {
        try {
            return userRepository.findAll().stream().map(userEntity -> objectMapper.convertValue(userEntity, User.class))
                    .collect(Collectors.toList());
        } catch (final Exception exception) {
            log.error(exception);
            throw new DBException(SERVICE_FIND_ALL_USERS_EXCEPTION_MESSAGE, exception);
        }
    }

    @Override
    public Long numberOfUsers() {
        return userRepository.count();
    }
}
