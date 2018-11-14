package org.redik.CustomerApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_card")
public class Customer_card {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="card_number")
    private String card_number;

    @OneToOne(mappedBy="customer_card")  //mappedBy is name of property in Customer
    private Customer customer;
    
    public Customer_card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    

}
