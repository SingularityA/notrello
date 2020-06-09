package com.epam.notrello.repository;

import com.epam.notrello.entity.BasicUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicUserRepository extends JpaRepository<BasicUser, Long> {
    BasicUser findByName(String name);
}
