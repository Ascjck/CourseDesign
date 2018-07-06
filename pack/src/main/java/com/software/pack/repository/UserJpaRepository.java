package com.software.pack.repository;

import com.software.pack.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,String> {

    User findByNumber(String number);
}
