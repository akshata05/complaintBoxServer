package com.example.ComplaintSytem.security;

import com.example.ComplaintSytem.User.User;
import com.example.ComplaintSytem.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utils.SecurityUtils;

import java.util.Set;

@Service
public class CustomeDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.findByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException("Username not found"+username));
        Set<GrantedAuthority> authorities=Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
        return UserPrincipal.builder().user(user).id(user.getId()).username(user.getUsername()).password(user.getPassword())
                .authorities(authorities).build();
    }
}
