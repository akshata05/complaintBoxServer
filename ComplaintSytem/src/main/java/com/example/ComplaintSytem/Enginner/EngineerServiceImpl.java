package com.example.ComplaintSytem.Enginner;

import com.example.ComplaintSytem.Complains.ComplainRepository;
import com.example.ComplaintSytem.Complains.ComplainStatus;
import com.example.ComplaintSytem.Complains.Complains;
import com.example.ComplaintSytem.Complains.Status;
import org.apache.catalina.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineerServiceImpl implements EngineerService {
    @Autowired
    ComplainRepository complainRepository;
    @Autowired
    EngineerRepository engineerRepository;

    @Override
    public Complains AssignEngineer(Long engineer_id, int ticket_id) {
        Complains complains = complainRepository.findById(ticket_id).get();
        Engineer engineer=engineerRepository.findByUserId(engineer_id);
        complains.AddEngineer(engineer);
        ComplainStatus complainStatus=new ComplainStatus();
        complainStatus.setStatus(String.valueOf(Status.Escalated));
        complains.setComplainStatus(complainStatus);
        return complainRepository.save(complains);
    }

    @Override
    public Engineer AddEngineer(Engineer engineer) {
        return engineerRepository.save(engineer);
    }

    @Override
    public List<Engineer> GetEngineer() {
        return engineerRepository.findAll();
    }

    @Override
    public Complains GiveResolution(int id, ComplainStatus complainStatus) {

        complainStatus.setStatus(String.valueOf(Status.Resolved));
        Complains complains = complainRepository.findById(id).get();
        complains.setComplainStatus(complainStatus);
        return complainRepository.save(complains);

    }
}