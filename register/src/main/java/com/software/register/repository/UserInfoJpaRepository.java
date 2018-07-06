package com.software.register.repository;

import com.software.register.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoJpaRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUser_Number(String number);
}
