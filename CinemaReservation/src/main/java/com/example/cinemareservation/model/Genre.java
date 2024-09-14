package com.example.cinemareservation.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @Column(nullable = false, length = 50)
    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = new HashSet<>();

    // Constructor vacío necesario para JPA
    public Genre() {
    }

    // Constructor con parámetros
    public Genre(String name) {
        this.name = name;
    }

    // Getter y Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
