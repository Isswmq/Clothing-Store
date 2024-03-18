package org.store.dev.moonrock.service;

import org.store.dev.moonrock.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Integer id);

    List<User> findAll();
}
