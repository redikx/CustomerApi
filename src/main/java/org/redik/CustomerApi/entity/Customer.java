package org.redik.CustomerApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

    
public Customer() {}    
    
public Customer(String first_name, String last_name, String email, int card_id) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
	this.card_id = card_id;
    }


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;

@OneToOne
@JoinColumn(name="Card_id") //card_id is column in owning (customer) which is FK
private Customer_card customer_card;


public Customer_card getCustomer_card() {
    return customer_card;
}

public void setCustomer_card(Customer_card customer_card) {
    this.customer_card = customer_card;
}


@Column(name="first_name")
private String first_name;

@Column(name="last_name")
private String last_name;

@Column(name="email")
private String email;

@Column(name="card_id")
private int card_id;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getFirst_name() {
    return first_name;
}

public void setFirst_name(String first_name) {
    this.first_name = first_name;
}

public String getLast_name() {
    return last_name;
}

public void setLast_name(String last_name) {
    this.last_name = last_name;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public int getCard_id() {
    return card_id;
}

public void setCard_id(int card_id) {
    this.card_id = card_id;
}

@Override
public String toString() {
    return "Customer [id=" + id + ", customer_card=" + customer_card.getCard_number() + ", first_name=" + first_name + ", last_name="
	    + last_name + ", email=" + email + "]";
}


}
