package com.thayna.finances.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public void getId(){
        return id;
    }

    public Long setId(Long id){
        this.id = id;
    }

    public void getName(){
        return name;
    }

    public String setName(String name){
        this.name = name;
    }

    public void getEmail(){
        return email;
    }

    public String setEmail(String email){
        this.email = email;
    }

    public void getPassword(){
        return password;
    }

    public String setPassword(String password){
        this.password = password;
    }
}