package com.example.ComplaintSytem.Customer;

import com.example.ComplaintSytem.Complains.ComplainRepository;
import com.example.ComplaintSytem.Complains.ComplainStatus;
import com.example.ComplaintSytem.Complains.Complains;
import com.example.ComplaintSytem.Complains.Status;
import com.example.ComplaintSytem.User.User;
import com.example.ComplaintSytem.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ComplainRepository complainRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Complains GiveFeedback(int id, ComplainStatus complainStatus) {
        Complains complains = complainRepository.findById(id).orElseThrow(()->new NotFound("not found"));
        ComplainStatus complainStatus1=complains.getComplainStatus();
        complainStatus1.setStatus(String.valueOf(Status.Completed));
        complainStatus1.setFeedback(complainStatus.getFeedback());
        complains.setComplainStatus(complainStatus1);
        return complainRepository.save(complains);

    }

}
