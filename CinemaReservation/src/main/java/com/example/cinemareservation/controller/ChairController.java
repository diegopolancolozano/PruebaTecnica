package com.example.cinemareservation.controller;

import com.example.cinemareservation.model.Chair;
import com.example.cinemareservation.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.Optional;

/**
 * The `ChairController` class in Java is a REST controller that handles CRUD operations for chairs
 * using Spring annotations.
 */
@RestController
@RequestMapping("/chairs")
public class ChairController {

    @Autowired
    private ChairService chairService;

    @PostMapping
    public ResponseEntity<Chair> createChair(@RequestBody Chair chair) {
        Chair createdChair = chairService.saveChair(chair);
        return ResponseEntity.ok(createdChair);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chair> getChairById(@PathVariable Long id) {
        Optional<Chair> chair = chairService.getChairById(id);
        return chair.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChair(@PathVariable Long id) {
        chairService.deleteChair(id);
        return ResponseEntity.noContent().build();
    }
}
