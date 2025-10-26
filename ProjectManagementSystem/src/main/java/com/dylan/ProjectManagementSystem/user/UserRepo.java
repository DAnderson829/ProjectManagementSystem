package com.dylan.ProjectManagementSystem.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByOrganization(String organization);

    Optional<User> findByUsername(String username);
}
