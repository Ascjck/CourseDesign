package com.software.recharge.repository;

import com.software.recharge.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoJpaRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUser_Number(String number);
}
