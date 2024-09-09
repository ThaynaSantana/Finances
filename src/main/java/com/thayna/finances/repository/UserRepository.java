package com.thayna.finances.repository;

import com.thayna.finances.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}