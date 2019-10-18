package com.example.jpa.inter;

import com.example.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserRepository extends JpaRepository<User, Long> {
}
