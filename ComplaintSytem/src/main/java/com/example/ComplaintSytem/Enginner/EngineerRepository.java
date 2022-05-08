package com.example.ComplaintSytem.Enginner;

import com.example.ComplaintSytem.Complains.Complains;
import com.example.ComplaintSytem.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer,Integer> {
    Engineer findByUserId(Long id);

}
