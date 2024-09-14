package com.example.cinemareservation.service;

import com.example.cinemareservation.model.Theater;
import com.example.cinemareservation.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    // Guardar un nuevo teatro
    public Theater saveTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    // Obtener un teatro por ID
    public Optional<Theater> getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }

    // Obtener todos los teatros
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    // Eliminar un teatro por ID
    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
