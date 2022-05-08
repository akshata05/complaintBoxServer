package com.example.ComplaintSytem.User;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="jwt_refresh_token")
@Data
public class JwtRefreshToken {
    @Id
    @Column(name="token_id",nullable = false)
    private String tokenId;

    @Column(name="user_id",nullable = false)
    private Long userId;
    @Column(name="create_date",nullable = false)
    private LocalDateTime createDateTime;

    @Column(name="expiration_date",nullable = false)
    private LocalDateTime expirationDate;

}

