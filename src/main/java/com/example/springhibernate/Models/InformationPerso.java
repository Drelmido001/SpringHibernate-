package com.example.springhibernate.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class InformationPerso {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public InformationPerso(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public InformationPerso() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
