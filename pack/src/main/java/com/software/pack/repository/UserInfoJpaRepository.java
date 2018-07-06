package com.software.pack.repository;

import com.software.pack.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoJpaRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUser_Number(String number);
}
