package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    private int id;
    private String username;
    private String pass;
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Bill> bills;
}
