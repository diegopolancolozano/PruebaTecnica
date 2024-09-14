package com.example.cinemareservation.model;

import jakarta.persistence.*;

/**
 * The `Theater` class is a JPA entity representing a theater with properties such as id, name, and
 * capacity, along with constructors and getters/setters.
 */
@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int capacity;

    // Constructor vacío necesario para JPA
    public Theater() {
    }

    // Constructor con parámetros para conveniencia
    public Theater(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        if(capacity <= 0) this.capacity = 1;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}