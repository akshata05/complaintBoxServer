package com.example.ComplaintSytem.Customer;

import com.example.ComplaintSytem.Complains.ComplainService;
import com.example.ComplaintSytem.Complains.ComplainStatus;
import com.example.ComplaintSytem.Complains.Complains;
import com.example.ComplaintSytem.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer customer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/complain/{id}/feedback")
    public Complains GiveFeedback(@PathVariable int id,@RequestBody ComplainStatus complainStatus) {
    return customerService.GiveFeedback(id,complainStatus);
    }


}
