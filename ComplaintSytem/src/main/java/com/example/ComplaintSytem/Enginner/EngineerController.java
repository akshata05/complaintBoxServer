package com.example.ComplaintSytem.Enginner;

import com.example.ComplaintSytem.Complains.ComplainStatus;
import com.example.ComplaintSytem.Complains.Complains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.CoderMalfunctionError;
import java.util.List;

@RestController
public class EngineerController {

    @Autowired
    EngineerService engineerService;
    @GetMapping("/engineer")
    public List<Engineer> GetEnginner(){
        return engineerService.GetEngineer();
    }

    @PostMapping("/addengineer")
    public Engineer AddEngineer(@RequestBody Engineer engineer){
        System.out.println(engineer);
        return engineerService.AddEngineer(engineer);
    }

    @PutMapping("/complain/{id}/assignengineer/{engineer_id}")
    public Complains AssignEngineer(@PathVariable int id, @PathVariable Long engineer_id){
        return engineerService.AssignEngineer(engineer_id,id);
    }

    @PutMapping("complain/{id}/resolution")
    public Complains AddResolution(@PathVariable int id, @RequestBody ComplainStatus complainStatus){
        return engineerService.GiveResolution(id,complainStatus);
    }
}
