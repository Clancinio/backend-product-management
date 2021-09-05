package com.deanclancydev.backendproductmanagement.security;

import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.deanclancydev.backendproductmanagement.security.ApplicationUserPermission.*;

@RequiredArgsConstructor
public enum ApplicationUserRole {

    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(DELETE, UPDATE, CREATE, EDIT, READ));

    private final Set<ApplicationUserPermission> permissions;

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
