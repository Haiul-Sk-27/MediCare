package com.example.MediCare.repository;

import com.example.MediCare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Query("SELECT COUNT(u) > 0 FROM User u Where u.email =:email")
    boolean existsByEmail(String email);
}
