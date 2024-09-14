package com.example.cinemareservation.repository;

import com.example.cinemareservation.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderRepository extends JpaRepository<Gender, String> {
    Optional<Gender> findById(Long id);
}
