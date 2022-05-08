package com.example.ComplaintSytem.Complains;

import com.example.ComplaintSytem.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComplainRepository extends JpaRepository<Complains,Integer> {
   // List<Complains> findByStatus(String status);
    List<Complains> findByComplainStatusStatusAndCustomerCustomerId(String status,int id);
    List<Complains> findByComplainStatusStatusAndEngineerEngineerId(String status,int id);
    List<Complains> findByComplainStatusStatus(String status);
   Complains findByTicketId(int ticket_id);
   Complains findByCustomerCustomerId(int customerId);
}
