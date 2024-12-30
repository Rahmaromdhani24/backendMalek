package com.Blacher.Blacher.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Blacher.Blacher.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Blacher.Blacher.models.Role;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);


}