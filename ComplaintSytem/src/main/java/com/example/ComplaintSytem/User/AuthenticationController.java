package com.example.ComplaintSytem.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {
@Autowired
    private AuthenticationService authenticationService;
@Autowired
    private UserService userService;
@Autowired
    private JwtRefreshTokenService jwtRefreshTokenService;

@PostMapping("signUp")
public ResponseEntity<?> signUp(@RequestBody User user){
if(userService.findByUserName(user.getUsername()).isPresent()){
    return new ResponseEntity<>(HttpStatus.CONFLICT);
}
return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
}

@PostMapping("signin")
    public ResponseEntity<?> signIn(@RequestBody User user){
return new ResponseEntity<>(authenticationService.signInAndReturnJwt(user),HttpStatus.OK);
}
    @PostMapping("refresh_token")
public ResponseEntity<?> refreshToken(@RequestParam String token){
    return ResponseEntity.ok(jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token));
    }
}
