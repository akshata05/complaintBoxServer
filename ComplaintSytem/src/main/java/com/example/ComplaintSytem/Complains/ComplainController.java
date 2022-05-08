package com.example.ComplaintSytem.Complains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/complain")
public class ComplainController {
    @Autowired
    private ComplainService complainService;

   @GetMapping("/{status}")
    public List<Complains> GetAllComplains(@PathVariable String status){
return complainService.findAllComplains(status);
    }
    @GetMapping("/{status}/{customer_id}")
    public List<Complains> GetComplainsByStatus(@PathVariable Long customer_id,@PathVariable String status){
        return complainService.findComplains(customer_id,status);
    }
    @GetMapping("/engineer/{status}/{engineer_id}")
    public List<Complains> GetComplainsByStatusForEngineer(@PathVariable Long engineer_id,@PathVariable String status){
        return complainService.findComplainsForEngineer(engineer_id,status);
    }
    @GetMapping("/fetch/{ticket_id}")
    public Complains GetComplainsByStatus(@PathVariable int ticket_id){
        return complainService.findComplainById(ticket_id);
    }

    @GetMapping("/fetch/{ticket_id}/customer")
    public String GetPincode(@PathVariable int ticket_id){
        return complainService.findPincode(ticket_id);
    }
    
    @PostMapping("/customer/{customer_id}/addcomplains")
    public ResponseEntity<?> PostComplain(@PathVariable Long customer_id, @RequestBody Complains complains){
            return complainService.addComplains(customer_id,complains);
    }

}
