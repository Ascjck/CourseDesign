package com.software.recharge.repository;

import com.software.recharge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,String> {

    User findByNumber(String number);
}
