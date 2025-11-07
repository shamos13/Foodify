package com.amos.service;

import com.amos.config.JwtProvider;
import com.amos.model.User;
import com.amos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserByJwtToken(String jwtToken) throws Exception {
        String email = jwtProvider.getEmailFromToken(jwtToken);
        User user = userRepository.findByEmail(email);

        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
       User user =  userRepository.findByEmail(email);

        if(user== null){
            throw new Exception("User not found");
        }
        return user;
    }
}
