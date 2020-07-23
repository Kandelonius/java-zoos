package com.lambdashane.newzoo.controllers;

import com.lambdashane.newzoo.models.Zoo;
import com.lambdashane.newzoo.services.ZooService;
import com.lambdashane.newzoo.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/zoos",
        produces = "application/json")
    public ResponseEntity<?> listAllZoos()
    {
        List<Zoo> myZoos = zooService.findAll();
        return new ResponseEntity<>(myZoos,
            HttpStatus.OK);
    }


//    http://localhost:2019/zoos/zoos/5
@GetMapping(value = "/zoo/{zooId}",
    produces = "application/json")
public ResponseEntity<?> getZooById(
    @PathVariable
        Long zooId)
    {
        Zoo z = zooService.findZooById(zooId);
        return new ResponseEntity<>(z,
            HttpStatus.OK);
    }
}
