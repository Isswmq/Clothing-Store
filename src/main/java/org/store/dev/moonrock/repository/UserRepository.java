package org.store.dev.moonrock.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.store.dev.moonrock.model.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
