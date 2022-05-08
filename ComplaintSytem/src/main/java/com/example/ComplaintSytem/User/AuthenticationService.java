package com.example.ComplaintSytem.User;

public interface AuthenticationService {
    User signInAndReturnJwt(User signInRequest);
}
