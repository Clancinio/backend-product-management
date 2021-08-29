package com.deanclancydev.backendproductmanagement.rest;

import com.deanclancydev.backendproductmanagement.dto.Product;
import com.deanclancydev.backendproductmanagement.dto.Transaction;
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

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ProductService productService;

    private final TransactionService transactionService;

    @RequestMapping("/registration")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @RequestMapping("/login")
    public ResponseEntity<?> getUser(Principal principal) {
        if (principal == null || principal.getName() == null) {
            return ResponseEntity.ok(principal);
        }
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
    }

    @RequestMapping("/purchase")
    public ResponseEntity<Transaction> purchaseProduct(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }
}
