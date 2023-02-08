package com.example.sandwich_spring.service.Impl;

import com.example.sandwich_spring.exception.EmailAlreadyTakenException;
import com.example.sandwich_spring.models.entity.User;
import com.example.sandwich_spring.models.form.RegisterForm;
import com.example.sandwich_spring.repository.UserRepository;
import com.example.sandwich_spring.service.AuthService;
import com.example.sandwich_spring.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void register(RegisterForm form) {

        if( userRepository.existsByEmail(form.getEmail()) )
            throw new EmailAlreadyTakenException();

        User user = userMapper.toEntity(form);
        user.setRole("CUSTOMER");

        userRepository.save( user );

    }
}
