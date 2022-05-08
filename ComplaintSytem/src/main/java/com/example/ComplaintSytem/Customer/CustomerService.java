package com.example.ComplaintSytem.Customer;

import com.example.ComplaintSytem.Complains.ComplainStatus;
import com.example.ComplaintSytem.Complains.Complains;

public interface CustomerService {
    public Customer addCustomer(Customer customer);
    public Complains GiveFeedback(int id, ComplainStatus complainStatus);
}
