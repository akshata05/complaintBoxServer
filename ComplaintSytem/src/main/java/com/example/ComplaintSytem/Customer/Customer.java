package com.example.ComplaintSytem.Customer;

import com.example.ComplaintSytem.Complains.ComplainService;
import com.example.ComplaintSytem.Complains.ComplainStatus;
import com.example.ComplaintSytem.Complains.Complains;
import com.example.ComplaintSytem.Complains.Status;
import com.example.ComplaintSytem.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
@Data
public class Customer {
    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customerId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", pincode='" + pincode + '\'' +
                ", complains=" + complains +
                ", user=" + user +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id",
            nullable = false,unique = true,columnDefinition = "int")
    private int customerId;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="username")
    private String username;

  /*  @Column(name="email",nullable = false,unique = true)
    private String email;
*/
    @Column(name="pincode")
    private String pincode;

    @OneToMany(mappedBy="customer",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore(true)
    private List<Complains> complains=new ArrayList<Complains>();

@OneToOne()
@JoinColumn(name="user_id")
private User user;

    public void addComplain(Complains complain){
        ComplainStatus complainStatus=new ComplainStatus();
        complainStatus.setStatus(String.valueOf(Status.New));
        complain.setComplainStatus(complainStatus);
        complains.add(complain);
        complain.setCustomer(this);
    }

}
