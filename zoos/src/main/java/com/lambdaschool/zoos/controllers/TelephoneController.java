package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * The entry point for client to access zoo, email combinations
 */
@RestController
@RequestMapping("/telephones")
public class TelephoneController
{
    /**
     * Using the Telephone service to process zoo, email combinations data
     */
    @Autowired
    TelephoneService telephoneService;

    /**
     * List of all zoos emails
     * <br>Example: <a href="http://localhost:2019/telephones/telephones">http://localhost:2019/telephones/telephones</a>
     *
     * @return JSON list of all zoos emails
     */
    @GetMapping(value = "/telephones",
            produces = "application/json")
    public ResponseEntity<?> listAllTelephones()
    {
        List<Telephone> allTelephones = telephoneService.findAll();
        return new ResponseEntity<>(allTelephones,
                                    HttpStatus.OK);
    }

    @GetMapping(value = "/telephone/{phoneId}",
            produces = "application/json")
    public ResponseEntity<?> getTelephoneById(
            @PathVariable
                    Long phoneId)
    {
        Telephone ue = telephoneService.findTelephoneById(phoneId);
        return new ResponseEntity<>(ue,
                                    HttpStatus.OK);
    }


//    @DeleteMapping(value = "/telephone/{phoneid}")
//    public ResponseEntity<?> deleteTelephoneById(
//            @PathVariable
//                    long phoneid)
//    {
//        telephoneService.delete(phoneid);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PutMapping("/telephone/{phoneid}/email/{emailaddress}")
//    public ResponseEntity<?> updateTelephone(
//            @PathVariable
//                    long telephoneid,
//            @PathVariable
//                    String emailaddress)
//    {
//        telephoneService.update(telephoneid,
//                                emailaddress);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PostMapping(value = "/zoo/{zooid}/email/{emailaddress}")
//    public ResponseEntity<?> addNewTelephone(
//            @PathVariable
//                    long zooid,
//            @PathVariable
//                    String emailaddress) throws
//            URISyntaxException
//    {
//        Telephone newTelephone = telephoneService.save(zooid,
//                                                       emailaddress);
//
//        // set the location header for the newly created resource
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newTelephoneURI = ServletUriComponentsBuilder.fromCurrentServletMapping()
//                .path("/telephones/telephone/{telephoneid}")
//                .buildAndExpand(newTelephone.getPhoneid())
//                .toUri();
//        responseHeaders.setLocation(newTelephoneURI);
//
//        return new ResponseEntity<>(null,
//                                    responseHeaders,
//                                    HttpStatus.CREATED);
//    }
}
