package com.example.cinemareservation.service;

import com.example.cinemareservation.model.Reservation;
import com.example.cinemareservation.model.Chair;
import com.example.cinemareservation.model.Show;
import com.example.cinemareservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ShowService showService;

    @Autowired
    private ChairService chairService;

    public Reservation createReservation(String clientName, Long showId, Set<Long> chairIds) {
        Optional<Show> showOpt = showService.getShowById(showId);
        Set<Chair> chairs = new HashSet<>();
        for (Long chairId : chairIds) {
            Optional<Chair> chairOpt = chairService.getChairById(chairId);
            chairOpt.ifPresent(chairs::add);
        }

        if (showOpt.isPresent()) {
            Show show = showOpt.get();
            Reservation reservation = new Reservation(clientName, show, chairs);
            return reservationRepository.save(reservation);
        }

        return null; // En caso de que la proyección no exista
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public void cancelReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
