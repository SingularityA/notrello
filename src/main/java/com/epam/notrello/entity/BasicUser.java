package com.epam.notrello.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "user_credentials")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private String roles;

    private LocalDateTime registered;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OrderBy("lastUpdated DESC")
    private Collection<Note> notes;

}
