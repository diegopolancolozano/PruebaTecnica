package com.example.cinemareservation.service;

import com.example.cinemareservation.model.Chair;
import com.example.cinemareservation.repository.ChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChairService {

    @Autowired
    private ChairRepository chairRepository;

    public Optional<Chair> getChairById(Long id) {
        return chairRepository.findById(id);
    }

    public Chair saveChair(Chair chair) {
        return chairRepository.save(chair);
    }


    public void deleteChair(Long id) {
        chairRepository.deleteById(id);
    }

}
