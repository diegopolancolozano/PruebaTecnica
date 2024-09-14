package com.example.cinemareservation.model;

import jakarta.persistence.*;

@Entity
public class Chair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int chairNumber; // Número de la silla

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    // Constructor vacío necesario para JPA
    public Chair() {
    }

    // Constructor con parámetros
    public Chair(int chairNumber, Theater theater) {
        this.chairNumber = chairNumber;
        this.theater = theater;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + id +
                ", chairNumber=" + chairNumber +
                ", theater=" + (theater != null ? theater.getName() : "null") +
                '}';
    }
}
