package com.example.ComplaintSytem.User;

import com.example.ComplaintSytem.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
@Autowired
    private UserService userService;

@PutMapping("change/{role}")
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal,@PathVariable Role role){
userService.ChangeRole(userPrincipal.getUsername(),role);
return ResponseEntity.ok(true);
}
    @GetMapping("/engineer")
    public List<User> getEngineer(){
        return userService.fetchEngineers();
    }

}
