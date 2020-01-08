package com.example.blog.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {

    int addUser(String username, String password);
}
