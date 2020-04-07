package com.indo.integration.authorization.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String username = authentication.getName();
            String password = authentication.getCredentials().toString();

            if (username.equals("admin")) {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            } else {
                return null;
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

}