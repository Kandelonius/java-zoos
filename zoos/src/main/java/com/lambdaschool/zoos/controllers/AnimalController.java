package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * The entry point for clients to access animal data
 * <p>
 * Note: we cannot update a animal
 * we cannot update a animal
 * working with the "non-owner" object in a many to many relationship is messy
 * we will be fixing that!
 */
@RestController
@RequestMapping("/animals")
public class AnimalController
{
    /**
     * Using the Animal service to process Animal data
     */
    @Autowired
    AnimalService animalService;


    @GetMapping(value = "/animals",
            produces = "application/json")
    public ResponseEntity<?> listAnimals()
    {
        List<Animal> allAnimals = animalService.findAll();
        return new ResponseEntity<>(allAnimals,
                                    HttpStatus.OK);
    }


    @GetMapping(value = "/animal/{animalId}",
            produces = "application/json")
    public ResponseEntity<?> getAnimalById(
            @PathVariable
                    Long animalId)
    {
        Animal r = animalService.findAnimalById(animalId);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }


    @GetMapping(value = "/animal/name/{animalName}",
            produces = "application/json")
    public ResponseEntity<?> getAnimalByName(
            @PathVariable
                    String animalName)
    {
        Animal r = animalService.findByName(animalName);
        return new ResponseEntity<>(r,
                                    HttpStatus.OK);
    }


//    @PostMapping(value = "/animal",
//            consumes = "application/json")
//    public ResponseEntity<?> addNewAnimal(
//            @Valid
//            @RequestBody
//                Animal newAnimal)
//    {
//        // ids are not recognized by the Post method
//        newAnimal.setAnimalid(0);
//        newAnimal = animalService.save(newAnimal);
//
//        // set the location header for the newly created resource
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newAnimalURI = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{animalid}")
//                .buildAndExpand(newAnimal.getAnimalid())
//                .toUri();
//        responseHeaders.setLocation(newAnimalURI);
//
//        return new ResponseEntity<>(null,
//                                    responseHeaders,
//                                    HttpStatus.CREATED);
//    }
}
