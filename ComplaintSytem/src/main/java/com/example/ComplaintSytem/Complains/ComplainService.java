package com.example.ComplaintSytem.Complains;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ComplainService {
    public ResponseEntity<?> addComplains(Long id, Complains complains);
    public List<Complains> findComplains(Long id,String status);

    List<Complains> findComplainsForEngineer(Long id, String status);

    List<Complains>  findAllComplains(String status);
    public Complains findComplainById(int ticket_id);
    public String findPincode(int ticket_id);
}
