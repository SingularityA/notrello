package com.epam.notrello.service;

import com.epam.notrello.dto.UserRegistrationDto;
import com.epam.notrello.entity.BasicUser;
import com.epam.notrello.repository.BasicUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasicUserService implements UserService {

    private final BasicUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final BasicUser user = userRepository.findByName(username);
        if (user == null) throw new UsernameNotFoundException("Invalid username or password.");
        return new User(
                user.getName(),
                user.getPassword(),
                Arrays.stream(user.getRoles().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public BasicUser findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<BasicUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public BasicUser save(UserRegistrationDto registrationDto) {
        final BasicUser user = BasicUser.builder()
                .name(registrationDto.getName())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .roles("ROLE_USER")
                .registered(LocalDateTime.now())
                .notes(Collections.emptyList())
                .build();
        return userRepository.save(user);
    }
}
