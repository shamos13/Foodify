package com.amos.controller;

import com.amos.config.JwtProvider;
import com.amos.repository.UserRepository;
import com.amos.service.CustomerUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private JwtProvider jwtProvider;

    private CustomerUserDetailsService customerUserDetailsService;

    private

}
