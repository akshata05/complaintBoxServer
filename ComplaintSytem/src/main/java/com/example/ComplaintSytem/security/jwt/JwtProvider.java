package com.example.ComplaintSytem.security.jwt;

import com.example.ComplaintSytem.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

    boolean isTokenValid(HttpServletRequest request);

    Authentication getAuthentication(HttpServletRequest request);
}
