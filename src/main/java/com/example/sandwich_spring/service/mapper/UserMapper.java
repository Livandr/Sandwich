package com.example.sandwich_spring.service.mapper;

import com.example.sandwich_spring.models.entity.User;
import com.example.sandwich_spring.models.form.RegisterForm;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toEntity(RegisterForm form){
        if( form == null )
            return null;

        User user = new User();

        user.setUsername( form.getUsername() );
        user.setPassword( form.getPassword() );
        user.setFirstname( form.getFirstName() );
        user.setLastname( form.getLastName() );
        user.setBirthdate( form.getBirthdate() );

        return user;
    }
}
