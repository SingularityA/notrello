package com.epam.notrello.dto;

import com.epam.notrello.validator.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class UserRegistrationDto {

    @NotBlank(message = "User name shouldn't be blank!")
    private String name;

    @NotBlank(message = "Password shouldn't be blank!")
    @Size(min = 5, message = "Password should contain at least 5 characters")
    private String password;

    @NotBlank
    private String confirmPassword;
}
