package com.example.room.common.config.auth;

import com.example.room.common.config.constants.AuthRoleStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.core.GrantedAuthority;

public class AuthRole implements GrantedAuthority {

    private AuthRoleStatus role;

    @Override
    public String getAuthority() {
        return role.name();
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(AuthRoleStatus.HOST.name()+">"+AuthRoleStatus.GUEST.name());
        return roleHierarchy;
    }
}
