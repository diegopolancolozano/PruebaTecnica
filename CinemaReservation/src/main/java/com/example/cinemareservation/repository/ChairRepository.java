package com.example.cinemareservation.repository;

import com.example.cinemareservation.model.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Long> {
    Optional<Chair> findById(Long id);
}