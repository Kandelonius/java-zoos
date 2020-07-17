package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;

import java.util.List;

/**
 * The Service that works with Zoo Model.
 * <p>
 * Note: Emails are added through the add zoo process
 * Animals are added through the add zoo process
 * No way to delete an assigned animal
 */
public interface ZooService
{
    /**
     * Returns a list of all the Zoos
     *
     * @return List of Zoos. If no zoos, empty list.
     */
    List<Zoo> findAll();

    /**
     * A list of all zoos whose zooname contains the given substring
     *
     * @param zooname The substring (String) of the zooname of the Zoos you seek
     * @return List of zoos whose zooname contains the given substring
     */
    List<Zoo> findByNameContaining(String zooname);

    /**
     * Returns the zoo with the given primary key.
     *
     * @param id The primary key (long) of the zoo you seek.
     * @return The given Zoo or throws an exception if not found.
     */
    Zoo findZooById(long id);

    /**
     * Returns the zoo with the given name
     *
     * @param name The full name (String) of the Zoo you seek.
     * @return The Zoo with the given name or throws an exception if not found.
     */
    Zoo findByName(String name);


//    void delete(long id);


    Zoo save(Zoo zoo);


//    Zoo update(
//            Zoo zoo,
//            long id);
//
//    public void deleteAll();
}