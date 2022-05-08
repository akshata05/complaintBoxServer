package com.example.ComplaintSytem.User;

import com.example.ComplaintSytem.Enginner.Engineer;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUserName(String username);

    void ChangeRole(String username, Role role);

    List<User> findAllUser();
    List<User> fetchEngineers();
}
