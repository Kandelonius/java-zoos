package com.lambdashane.newzoo.controllers;

import com.lambdashane.newzoo.services.AnimalService;
import com.lambdashane.newzoo.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController
{
    @Autowired
    AnimalService animalService;

    @GetMapping(value = "/count",
    produces = "application/json")
    public ResponseEntity<?> getZooAnimalCounts()
    {
        List<AnimalCount> myAnimals = animalService.getZooCountAnimals();
        return new ResponseEntity<>(myAnimals,
            HttpStatus.OK);
    }
}
