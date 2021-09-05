package com.deanclancydev.backendproductmanagement.constants;

import java.util.Arrays;
import java.util.List;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 432_000_000; // 5 Days

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String JWT_TOKEN_HEADER = "Jwt-Token ";

    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified !";

    public static final String TOKEN_ISSUER = "Clancinio, LLC!";

    public static final String CLANCINIO_ADMINISTRATION = "Clancinio";

    public static final String AUTHORITIES = "Authorities";

    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page!";

    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page!!";

    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";

    public static final List<String> PUBLIC_URLS =
            Arrays.asList("user/login", "/user/register", "user/resetpassword/**", " /user/image/**");

}

