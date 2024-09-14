package com.example.cinemareservation.repository;

import com.example.cinemareservation.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findAllByMovieId(Long movieId);
    List<Show> findAllByTheaterId(Long theaterId);
    List<Show> findAllByShowTimeAfter(LocalDateTime showTime);
}
