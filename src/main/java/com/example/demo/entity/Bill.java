package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;

@Data
@Entity
public class Bill {

    @Id
    private int id;
    @Column(name = "date_bill")
    private Date date_bill;
    @Column(name = "user_bill")
    private int usuario_id;
    @Column(name = "value")
    private byte valor;
    @Column(name = "type")
    private int tipo;
    @Column(name = "observation")
    private String observacion;

}
