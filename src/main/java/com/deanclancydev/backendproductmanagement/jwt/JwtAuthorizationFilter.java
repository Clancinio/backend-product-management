package com.deanclancydev.backendproductmanagement.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.deanclancydev.backendproductmanagement.constants.SecurityConstants.OPTIONS_HTTP_METHOD;
import static com.deanclancydev.backendproductmanagement.constants.SecurityConstants.TOKEN_PREFIX;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getMethod().equalsIgnoreCase(OPTIONS_HTTP_METHOD)) {
            httpServletResponse.setStatus(OK.value());
        } else {
            String authorizationHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader == null || authorizationHeader.startsWith(TOKEN_PREFIX)) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        }
    }
}
