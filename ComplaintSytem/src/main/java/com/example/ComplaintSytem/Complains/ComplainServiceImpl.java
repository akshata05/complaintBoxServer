package com.example.ComplaintSytem.Complains;

import com.example.ComplaintSytem.Customer.Customer;
import com.example.ComplaintSytem.Customer.CustomerRepository;
import com.example.ComplaintSytem.Enginner.Engineer;
import com.example.ComplaintSytem.Enginner.EngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainServiceImpl implements ComplainService{

    @Autowired
    private ComplainRepository complainRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EngineerRepository engineerRepository;


    @Override
    public ResponseEntity<?> addComplains(Long id, Complains complains) {

        Customer customer=customerRepository.findByUserId(id);
        System.out.print(complains);
        customer.addComplain(complains);
        customerRepository.save(customer);
        return new ResponseEntity(HttpStatus.OK);

    }
    @Override
    public String findPincode(int ticket_id){
            Complains complains=complainRepository.findByTicketId(ticket_id);
            Customer customer=customerRepository.findByCustomerId(complains.getCustomer().getCustomerId());
            return customer.getPincode();
    }
    @Override
    public List<Complains> findComplains(Long id,String status) {
        Customer customer=customerRepository.findByUserId(id);
        List<Complains> complains=complainRepository.findByComplainStatusStatusAndCustomerCustomerId(status,customer.getCustomerId());
       // System.out.print(complains);
        return  complains;
    }
    @Override
    public List<Complains> findComplainsForEngineer(Long id, String status) {
        Engineer engineer=engineerRepository.findByUserId(id);
        List<Complains> complains=complainRepository.findByComplainStatusStatusAndEngineerEngineerId(status,engineer.getEngineerId());
        // System.out.print(complains);
        return  complains;
    }

public List<Complains> findAllComplains(String status){
    List<Complains> complains=complainRepository.findByComplainStatusStatus(status);
    return complains;
}
public Complains findComplainById(int ticket_id){
        Complains complain =complainRepository.findByTicketId(ticket_id);
        return complain;
}

}
