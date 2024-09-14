package com.example.cinemareservation.service;

import com.example.cinemareservation.model.Genre;
import com.example.cinemareservation.model.Movie;
import com.example.cinemareservation.repository.GenreRepository;
import com.example.cinemareservation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public void assignGenreToMovie(String genreName, Long movieId) {
        Optional<Genre> genreOpt = genreRepository.findById(genreName);
        Optional<Movie> movieOpt = movieRepository.findById(movieId);

        if (genreOpt.isPresent() && movieOpt.isPresent()) {
            Genre genre = genreOpt.get();
            Movie movie = movieOpt.get();

            movie.getGenres().add(genre);
            genre.getMovies().add(movie);

            // Guardamos las entidades para actualizar la relación
            movieRepository.save(movie);
            genreRepository.save(genre);
        }
    }
}
