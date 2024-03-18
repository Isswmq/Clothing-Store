package org.store.dev.moonrock.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.store.dev.moonrock.model.user.User;
import org.store.dev.moonrock.repository.UserRepository;
import org.store.dev.moonrock.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        return userService.findById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    return "user/user";
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/users")
    public String findAll(Model model, Pageable pageable /*UserFilter filter*/) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/users";
    }

    public String create() {

    }
}
