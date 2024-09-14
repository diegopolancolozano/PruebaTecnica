package com.example.cinemareservation.service;

import com.example.cinemareservation.model.Gender;
import com.example.cinemareservation.model.Movie;
import com.example.cinemareservation.repository.GenderRepository;
import com.example.cinemareservation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Gender saveGender(Gender gender) {
        return genderRepository.save(gender);
    }

    public void assignGenderToMovie(String genderName, Long movieId) {
        Optional<Gender> genderOpt = genderRepository.findById(genderName);
        Optional<Movie> movieOpt = movieRepository.findById(movieId);

        if (genderOpt.isPresent() && movieOpt.isPresent()) {
            Gender gender = genderOpt.get();
            Movie movie = movieOpt.get();

            movie.getGender().add(gender);
            gender.getMovies().add(movie);

            // Guardamos las entidades para actualizar la relación
            movieRepository.save(movie);
            genderRepository.save(gender);
        }
    }

    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    public Optional<Gender> getGenderById(Long id) {
        return genderRepository.findById(id);
    }

    // Método para eliminar un género por ID
    public void deleteGender(Long id) {
        genderRepository.deleteById(String.valueOf(id));
    }
}
