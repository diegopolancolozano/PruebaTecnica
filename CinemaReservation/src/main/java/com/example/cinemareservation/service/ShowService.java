package com.example.cinemareservation.service;

import com.example.cinemareservation.model.Show;
import com.example.cinemareservation.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show saveShow(Show show) {
        return showRepository.save(show);
    }

    public Optional<Show> getShowById(Long id) {
        return showRepository.findById(id);
    }

    public List<Show> getShowsByMovieId(Long movieId) {
        return showRepository.findAllByMovieId(movieId);
    }

    public List<Show> getShowsByTheaterId(Long theaterId) {
        return showRepository.findAllByTheaterId(theaterId);
    }

    public List<Show> getShowsByShowTimeAfter(LocalDateTime showTime) {
        return showRepository.findAllByShowTimeAfter(showTime);
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }
}
