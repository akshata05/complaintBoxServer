package com.example.ComplaintSytem.Enginner;

import com.example.ComplaintSytem.Complains.Complains;
import com.example.ComplaintSytem.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="engineer")
@Data
public class Engineer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="engineer_id")
    private int engineerId;

    @Column(name="username")
    private String username;

    @Column(name="name")
    private String name;

    @Column(name="pincode")
    private String pincode;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "engineer")
            @JsonIgnore(true)
    List<Complains> complains=new ArrayList<>();

    @OneToOne()
    @JoinColumn(name="user_id")
    private User user;




}
