package org.store.dev.moonrock.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.store.dev.moonrock.model.user.User;
import org.store.dev.moonrock.repository.UserRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        return userRepository.findById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    return "user/user";
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
