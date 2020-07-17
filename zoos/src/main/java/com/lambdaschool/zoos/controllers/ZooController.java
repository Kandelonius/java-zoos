package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * The entry point for clients to access zoo data
 */
@RestController
@RequestMapping("/zoos")
public class ZooController
{
    /**
     * Using the Zoo service to process zoo data
     */
    @Autowired
    private ZooService zooService;

    /**
     * Returns a list of all zoos
     * <br>Example: <a href="http://localhost:2019/zoos/zoos">http://localhost:2019/zoos/zoos</a>
     *
     * @return JSON list of all zoos with a status of OK
     * @see ZooService#findAll() ZooService.findAll()
     */
    @GetMapping(value = "/zoos",
            produces = "application/json")
    public ResponseEntity<?> listAllZoos()
    {
        List<Zoo> myZoos = zooService.findAll();
        return new ResponseEntity<>(myZoos,
                                    HttpStatus.OK);
    }

    /**
     * Returns a single zoo based off a zoo id number
     * <br>Example: http://localhost:2019/zoos/zoo/7
     *
     * @param zooId The primary key of the zoo you seek
     * @return JSON object of the zoo you seek
     * @see ZooService#findZooById(long) ZooService.findZooById(long)
     */
    @GetMapping(value = "/zoo/{zooId}",
            produces = "application/json")
    public ResponseEntity<?> getZooById(
            @PathVariable
                    Long zooId)
    {
        Zoo u = zooService.findZooById(zooId);
        return new ResponseEntity<>(u,
                                    HttpStatus.OK);
    }

    /**
     * Return a zoo object based on a given zooname
     * <br>Example: <a href="http://localhost:2019/zoos/zoo/name/cinnamon">http://localhost:2019/zoos/zoo/name/cinnamon</a>
     *
     * @param zooName the name of zoo (String) you seek
     * @return JSON object of the zoo you seek
     * @see ZooService#findByName(String) ZooService.findByName(String)
     */
    @GetMapping(value = "/zoo/name/{zooName}",
            produces = "application/json")
    public ResponseEntity<?> getZooByName(
            @PathVariable
                    String zooName)
    {
        Zoo u = zooService.findByName(zooName);
        return new ResponseEntity<>(u,
                                    HttpStatus.OK);
    }

    /**
     * Returns a list of zoos whose zooname contains the given substring
     * <br>Example: <a href="http://localhost:2019/zoos/zoo/name/like/da">http://localhost:2019/zoos/zoo/name/like/da</a>
     *
     * @param zooName Substring of the zooname for which you seek
     * @return A JSON list of zoos you seek
     * @see ZooService#findByNameContaining(String) ZooService.findByNameContaining(String)
     */
    @GetMapping(value = "/zoo/name/like/{zooName}",
            produces = "application/json")
    public ResponseEntity<?> getZooLikeName(
            @PathVariable
                    String zooName)
    {
        List<Zoo> u = zooService.findByNameContaining(zooName);
        return new ResponseEntity<>(u,
                                    HttpStatus.OK);
    }


//    @PostMapping(value = "/zoo",
//            consumes = "application/json")
//    public ResponseEntity<?> addNewZoo(
//            @Valid
//            @RequestBody
//                Zoo newzoo) throws
//            URISyntaxException
//    {
//        newzoo.setZooid(0);
//        newzoo = zooService.save(newzoo);
//
//        // set the location header for the newly created resource
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{zooid}")
//                .buildAndExpand(newzoo.getZooid())
//                .toUri();
//        responseHeaders.setLocation(newZooURI);
//
//        return new ResponseEntity<>(null,
//                                    responseHeaders,
//                                    HttpStatus.CREATED);
//    }


//    @PutMapping(value = "/zoo/{zooid}",
//            consumes = "application/json")
//    public ResponseEntity<?> updateFullZoo(
//            @Valid
//            @RequestBody
//                Zoo updateZoo,
//            @PathVariable
//                    long zooid)
//    {
//        updateZoo.setZooid(zooid);
//        zooService.save(updateZoo);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


//    @PatchMapping(value = "/zoo/{id}",
//            consumes = "application/json")
//    public ResponseEntity<?> updateZoo(
//            @RequestBody
//                Zoo updateZoo,
//            @PathVariable
//                    long id)
//    {
//        zooService.update(updateZoo,
//                           id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


//    @DeleteMapping(value = "/zoo/{id}")
//    public ResponseEntity<?> deleteZooById(
//            @PathVariable
//                    long id)
//    {
//        zooService.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}