package com.software.query.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserInfo")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "number", referencedColumnName = "number")
    private User user;

    @Column(length = 1,nullable = false)
    private String pack;

    @Column(nullable = false)
    private Double balance;

    public UserInfo() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public String getPack() {
        return pack;
    }

    public Double getBalance() {
        return balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
