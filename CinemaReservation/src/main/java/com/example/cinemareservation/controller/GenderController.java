package com.example.cinemareservation.controller;

import com.example.cinemareservation.model.Gender;
import com.example.cinemareservation.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gender")
@CrossOrigin(origins = "http://localhost:3000")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping
    public ResponseEntity<List<Gender>> getAllGender() {
        List<Gender> genders = genderService.getAllGenders();
        return ResponseEntity.ok(genders);
    }

    @PostMapping
    public ResponseEntity<Gender> createGender(@RequestBody Gender gender) {
        Gender savedgender = genderService.saveGender(gender);
        return ResponseEntity.ok(savedgender);
    }


    // Obtener un género por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Gender> getGenderById(@PathVariable String id) {
        Optional<Gender> gender = genderService.getGenderById(Long.valueOf(id));
        return gender.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Eliminar un género por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGender(@PathVariable String id) {
        Optional<Gender> gender = genderService.getGenderById(Long.valueOf(id));
        if (gender.isPresent()) {
            genderService.deleteGender(Long.valueOf(id));
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
