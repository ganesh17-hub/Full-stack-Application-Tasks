package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name="fruits")
public class Fruit {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String name;
private int quantity;

public Fruit(){}

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

public int getQuantity() {
 return quantity;
}

public void setQuantity(int quantity) {
 this.quantity = quantity;
}

}