package com.example.cinemareservation.repository;

import com.example.cinemareservation.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.time.LocalDate;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    ArrayList<Movie> findByTitle(String title);

    ArrayList<Movie> findByDirector(String director);

    ArrayList<Movie> findByReleaseDateAfter(LocalDate releaseDate);
}