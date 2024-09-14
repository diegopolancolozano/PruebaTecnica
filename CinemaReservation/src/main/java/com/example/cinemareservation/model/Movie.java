package com.example.cinemareservation.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 50)
    private String director;

    private int duration; // Duración en minutos

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany
    @JoinTable(
            name = "movie_genre", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_name")
    )
    private Set<Gender> genders = new HashSet<>();

    // Constructor vacío necesario para JPA
    public Movie() {
    }

    // Constructor con parámetros
    public Movie(String title, String director, int duration, LocalDate releaseDate) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<Gender> getGender() {
        return genders;
    }

    public void setGenders(Set<Gender> genres) {
        this.genders = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", genders=" + genders +
                '}';
    }
}
