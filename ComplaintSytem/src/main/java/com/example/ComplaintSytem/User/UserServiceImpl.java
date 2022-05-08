package com.example.ComplaintSytem.User;

import com.example.ComplaintSytem.Customer.Customer;
import com.example.ComplaintSytem.Customer.CustomerRepository;
import com.example.ComplaintSytem.Enginner.Engineer;
import com.example.ComplaintSytem.Enginner.EngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EngineerRepository engineerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
user.setPassword(passwordEncoder.encode(user.getPassword()));
//user.setRole(Role.User);
user.setCreatedTime(LocalDateTime.now());
       User user1= userRepository.save(user);
if(user.getRole()==Role.User){
Customer customer=new Customer();
customer .setName(user.getName());
customer.setPincode(user.getPincode());
customer.setUsername(user.getUsername());
customer.setUser(user);
customerRepository.save(customer);
}
else if(user.getRole()==Role.Engineer){
    Engineer engineer=new Engineer();
    engineer .setName(user.getName());
    engineer.setPincode(user.getPincode());
    engineer.setUsername(user.getUsername());
    engineer.setUser(user);
    engineerRepository.save(engineer);
}
return user1 ;
    }

    @Override
    public Optional<User> findByUserName(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void ChangeRole(String username, Role role){
        userRepository.UpdateUserRole(username,role);
    }

    @Override
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @Override
    public List<User> fetchEngineers() {
        return userRepository.findByRole(Role.Engineer);
    }


}
