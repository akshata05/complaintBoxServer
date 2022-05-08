package com.example.ComplaintSytem.Complains;

import com.example.ComplaintSytem.Customer.Customer;
import com.example.ComplaintSytem.Enginner.Engineer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="complains")
@Data
public class Complains {
    @Override
    public String toString() {
        return "Complains{" +
                "ticket_id=" + ticketId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                '}';
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ticket_id")
    private int ticketId;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    @JsonIgnore(true)
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name="engineer_id")
    @JsonIgnore(true)
    private Engineer engineer;

    public void AddEngineer(Engineer engineer){

        this.setEngineer(engineer);
    }

    @Embedded
    private ComplainStatus complainStatus;

}
