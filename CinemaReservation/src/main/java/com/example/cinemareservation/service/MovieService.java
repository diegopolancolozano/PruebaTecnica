package com.example.cinemareservation.service;

import com.example.cinemareservation.model.Movie;
import com.example.cinemareservation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getMoviesByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> getMoviesByDirector(String director) {
        return movieRepository.findByDirector(director);
    }

    public List<Movie> getMoviesReleasedAfter(LocalDate releaseDate) {
        return movieRepository.findByReleaseDateAfter(releaseDate);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}