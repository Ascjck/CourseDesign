package com.software.register.repository;

import com.software.register.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,String> {

    User findByNumber(String number);
}
