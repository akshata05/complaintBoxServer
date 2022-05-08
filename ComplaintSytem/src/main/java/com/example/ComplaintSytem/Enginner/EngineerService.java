package com.example.ComplaintSytem.Enginner;

import com.example.ComplaintSytem.Complains.ComplainStatus;
import com.example.ComplaintSytem.Complains.Complains;

import java.util.List;

public interface EngineerService {
    public Complains AssignEngineer(Long engineer_id, int ticket_id);
    public Engineer AddEngineer(Engineer engineer);
    public List<Engineer> GetEngineer();
    public Complains GiveResolution(int id, ComplainStatus complainStatus);
}
