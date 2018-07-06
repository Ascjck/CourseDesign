package com.software.query.repository;

import com.software.query.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,String> {

    User findByNumber(String number);
}
