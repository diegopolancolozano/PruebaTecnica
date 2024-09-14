package com.example.cinemareservation.model;

import jakarta.persistence.*;
import java.util.Set;

/**
 * The `Reservation` class represents a reservation made by a client for a show, specifying the
 * client's name, the show, and the reserved chairs.
 */
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientName; // Nombre del cliente

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show; // La proyección para la cual se realiza la reserva

    @ManyToMany
    @JoinTable(
            name = "reservation_chair",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "chair_id")
    )
    private Set<Chair> chairs; // Sillas reservadas

    // Constructor vacío necesario para JPA
    public Reservation() {
    }

    // Constructor con parámetros
    public Reservation(String clientName, Show show, Set<Chair> chairs) {
        this.clientName = clientName;
        this.show = show;
        this.chairs = chairs;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Set<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(Set<Chair> chairs) {
        this.chairs = chairs;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", show=" + show.getMovie().getTitle() +
                ", chairs=" + chairs.size() +
                '}';
    }
}