package com.example.cinemareservation.repository;

import com.example.cinemareservation.model.Chair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChairRepository extends JpaRepository<Chair, Long> {
}
