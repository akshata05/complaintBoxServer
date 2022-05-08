package com.example.ComplaintSytem.Complains;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
@Data
public class ComplainStatus {
    private String status;
    private String resolution;
    private  String feedback;

}
