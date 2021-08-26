package com.deanclancydev.backendproductmanagement.service.impl;


import com.deanclancydev.backendproductmanagement.dto.User;
import com.deanclancydev.backendproductmanagement.entity.UserEntity;
import com.deanclancydev.backendproductmanagement.repository.UserRepository;
import com.deanclancydev.backendproductmanagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ObjectMapper objectMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        final UserEntity userEntity = objectMapper.convertValue(user, UserEntity.class);
        userRepository.save(userEntity);
        return objectMapper.convertValue(userEntity, User.class);
    }

    @Override
    public User updateUser(User user) {
        final UserEntity userEntity = objectMapper.convertValue(user, UserEntity.class);
        userRepository.save(userEntity);
        return objectMapper.convertValue(userEntity, User.class);
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User findByUsername(String userName){
        final Optional<UserEntity> userEntity = userRepository.findByUserName(userName);
        if(userEntity.isPresent()){
            throw new RuntimeException("User with the Username " + userName + " does not exist.");
        } else {
            return objectMapper.convertValue(userEntity, User.class);
        }
    }

    public List<User> findAllUsers(){
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(userEntity -> objectMapper.convertValue(userEntity, User.class))
                .collect(Collectors.toList());
    }

    public Long numberOfUsers(){
        return userRepository.count();
    }
}
