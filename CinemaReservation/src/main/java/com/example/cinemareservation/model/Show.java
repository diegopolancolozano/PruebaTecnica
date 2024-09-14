package com.example.cinemareservation.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * The `Show` class represents a show with details such as show time, associated movie, and theater in
 * a Java application using JPA annotations.
 */
@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime showTime; // Fecha y hora de la proyección

    // Relación con Movie
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    // Relación con Theater
    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    // Constructor vacío necesario para JPA
    public Show() {
    }

    // Constructor con parámetros
    public Show(LocalDateTime showTime, Movie movie, Theater theater) {
        this.showTime = showTime;
        this.movie = movie;
        this.theater = theater;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", showTime=" + showTime +
                ", movie=" + movie.getTitle() +
                ", theater=" + theater.getName() +
                '}';
    }
}
