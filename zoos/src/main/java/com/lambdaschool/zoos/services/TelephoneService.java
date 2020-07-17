package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Telephone;

import java.util.List;


/**
 * The Service that works with the Telephone Model
 * <p>
 * Note: Emails are added through the add zoo process
 */
public interface TelephoneService
{
    /**
     * Returns a list of all zoos and their emails
     *
     * @return List of zoos and their emails
     */
    List<Telephone> findAll();

    /**
     * Returns the zoo email combination associated with the given id
     *
     * @param id The primary key (long) of the zoo email combination you seek
     * @return The zoo email combination (Telephone) you seek
     */
    Telephone findTelephoneById(long id);


//    void delete(long id);


//    Telephone update(
//            long telephoneid,
//            String emailaddress);


    Telephone save(
            long zooid,
            String emailaddress);
}
