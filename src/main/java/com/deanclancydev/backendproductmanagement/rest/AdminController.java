package com.deanclancydev.backendproductmanagement.rest;

import com.deanclancydev.backendproductmanagement.dto.Product;
import com.deanclancydev.backendproductmanagement.dto.Transaction;
import com.deanclancydev.backendproductmanagement.dto.User;
import com.deanclancydev.backendproductmanagement.service.ProductService;
import com.deanclancydev.backendproductmanagement.service.TransactionService;
import com.deanclancydev.backendproductmanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    private final ProductService productService;

    private final TransactionService transactionService;

    @PostMapping("/product-create")
    @Operation(summary = "Create a new product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/product-update")
    @Operation(summary = "Update a product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/product-delete")
    @Operation(summary = "Delete a product")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product.getId());
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/product-all")
    @Operation(summary = "Return all products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product-number")
    @Operation(summary = "Total number of products")
    public ResponseEntity<String> getNumberOfProducts() {
        return new ResponseEntity<>(productService.numberOfProducts(), HttpStatus.OK);
    }

    @PutMapping("/user-update")
    @Operation(summary = "Update a user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/user-delete")
    @Operation(summary = "Delete a user")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/user-all")
    @Operation(summary = "Return all users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user-number")
    @Operation(summary = "Return all users")
    public ResponseEntity<String> getNumberOfUsers() {
        return new ResponseEntity<>(userService.numberOfUsers(), HttpStatus.OK);
    }

    @GetMapping("/transaction-all")
    @Operation(summary = "Return all transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/transaction-number")
    @Operation(summary = "Return all users")
    public ResponseEntity<String> getNumberOfTransactions() {
        return new ResponseEntity<>(transactionService.numberOfTransactions(), HttpStatus.OK);
    }
}
