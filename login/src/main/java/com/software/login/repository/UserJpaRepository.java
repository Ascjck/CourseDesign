package com.software.login.repository;

import com.software.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,String> {

    User findByNumber(String number);
}
