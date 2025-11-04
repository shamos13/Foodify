package com.amos.repository;

import com.amos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email); // for custom methods in this repo you write findBy<field_name> followed by the field name in the entity of which you want to get the data
}
