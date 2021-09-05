package com.deanclancydev.backendproductmanagement.security;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ApplicationUserPermission {

    DELETE("delete"),
    UPDATE("update"),
    CREATE("create"),
    EDIT("edit"),
    READ("read");

    private final String permission;

    public String getPermission() {
        return permission;
    }
}
