package com.software.pack.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @Column(length = 11,nullable = false)
    @NotBlank(message = "号码必填")
    @Length(max = 11,min = 11,message = "手机号码长度为11")
    private String number;
    @NotBlank(message = "用户名必填")
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false)
    @NotBlank(message = "密码必填")
    private String passwd;

    public User(){

    }

    public String getNumber() {
        return number;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
