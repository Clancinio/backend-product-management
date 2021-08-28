package com.deanclancydev.backendproductmanagement.constants;

public class ExceptionConstants {

    public static final String HANDLE_ALL_EXCEPTIONS_MESSAGE = "Oops! Something went wrong";

    // User Service
    public static final String SERVICE_FIND_ALL_USERS_EXCEPTION_MESSAGE = "Failed to retrieve users";

    public static final String SERVICE_FIND_BY_USERNAME_EXCEPTION_MESSAGE = "User with the username %s does not exist.";

    public static final String SERVICE_DELETE_USER_EXCEPTION_MESSAGE = "Failed to delete user.";

    public static final String SERVICE_UPDATE_USER_EXCEPTION_MESSAGE = "Failed to update user.";

    public static final String SERVICE_SAVE_USER_EXCEPTION_MESSAGE = "Failed to create user.";

    // Product Service
    public static final String SERVICE_UPDATE_PRODUCT_EXCEPTION_MESSAGE = "Failed to update product.";

    public static final String SERVICE_SAVE_PRODUCT_EXCEPTION_MESSAGE = "Failed to create product.";

    public static final String SERVICE_DELETE_PRODUCT_EXCEPTION_MESSAGE = "Failed to delete product";

    public static final String SERVICE_FIND_ALL_PRODUCTS_EXCEPTION_MESSAGE = "ailed to retrieve users";

    // Transaction Service
    public static final String SERVICE_SAVE_TRANSACTION_EXCEPTION_MESSAGE
            = "Failed to create transaction";

    public static final String SERVICE_FIND_ALL_TRANSACTIONS_EXCEPTION_MESSAGE = "Failed to retrieve transactions";

}

