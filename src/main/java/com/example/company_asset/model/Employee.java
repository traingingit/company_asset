package com.example.company_asset.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Data
@Entity
public class Employee {
    @Id
    int id;
    String name;

    public Employee() {
    }
//
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
