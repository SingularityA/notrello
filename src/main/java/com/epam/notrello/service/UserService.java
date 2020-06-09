package com.epam.notrello.service;

import com.epam.notrello.dto.UserRegistrationDto;
import com.epam.notrello.entity.BasicUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<BasicUser> findAll();
    BasicUser findByName(String name);
    BasicUser save(UserRegistrationDto registrationDto);
}
