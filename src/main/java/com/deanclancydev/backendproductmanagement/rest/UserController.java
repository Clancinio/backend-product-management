package com.deanclancydev.backendproductmanagement.rest;

import com.deanclancydev.backendproductmanagement.dto.User;
import com.deanclancydev.backendproductmanagement.service.ProductService;
import com.deanclancydev.backendproductmanagement.service.TransactionService;
import com.deanclancydev.backendproductmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ProductService productService;

    private final TransactionService transactionService;

    @RequestMapping("/registration")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
}
