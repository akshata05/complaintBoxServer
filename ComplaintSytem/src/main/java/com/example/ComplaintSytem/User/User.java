package com.example.ComplaintSytem.User;

import com.example.ComplaintSytem.Customer.Customer;
import com.example.ComplaintSytem.Enginner.Engineer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="username",nullable = false,unique = true)
    private String username;

    @Column(name="password",nullable = false)
    private String password;
    @Column(name="name",nullable = false)
    private String name;

    @Column(name="createdtime",nullable = false)
    private LocalDateTime createdTime;

    @Enumerated(EnumType.STRING)
    @Column(name="role",nullable = false)
    private Role role;
    @Column(name="pincode",nullable = false)
    private String pincode;
    @Transient
    private String accessToken;
    @Transient
    private String refreshToken;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonIgnore(true)
    private Engineer engineer;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonIgnore(true)
    private Customer customer;
}
