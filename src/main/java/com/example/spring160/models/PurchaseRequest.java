package com.example.spring160.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "purchase_request")
@Data
public class PurchaseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "contact")
    private String contact;

    @Column(name = "Id_product")
    private long idProduct;

    @Column(name = "if_worked")
    private Boolean ifWorked;
}