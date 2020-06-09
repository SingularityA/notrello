package com.epam.notrello.controller;

import com.epam.notrello.dto.UserRegistrationDto;
import com.epam.notrello.entity.BasicUser;
import com.epam.notrello.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "users/login";
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication) {
        final BasicUser user = userService.findByName(authentication.getName());
        model.addAttribute("user", user);
        return "users/profile";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", UserRegistrationDto.builder().build());
        return "users/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                               BindingResult result) {
        val existing = userService.findByName(userDto.getName());
        if (existing != null) {
            result.rejectValue("name", "",
                    "There is already an account registered with that name");
        }

        if (result.hasErrors()) {
            return "users/register";
        }

        userService.save(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/admin/panel")
    public String adminPanel(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/panel";
    }
}
