package com.software.query.repository;

import com.software.query.domain.User;
import com.software.query.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoJpaRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUser_Number(String number);
}
