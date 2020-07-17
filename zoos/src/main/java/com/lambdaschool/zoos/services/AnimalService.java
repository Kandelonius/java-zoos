package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;

import java.util.List;

/**
 * The service that works with the Animal Model.
 * <p>
 * Note: no method update Animal name
 */
public interface AnimalService
{
    /**
     * Returns a list of all Animal objects
     *
     * @return list of all Animal object
     */
    List<Animal> findAll();

    /**
     * Return the first Animal matching the given primary key
     *
     * @param id The primary key (long) of the Animal you seek
     * @return The Animal object you seek
     */
    Animal findAnimalById(long id);

    /**
     * Given a complete Animal object, saved that Animal object in the database.
     * If a primary key is provided, the record is completely replaced
     * If no primary key is provided, one is automatically generated and the record is added to the database.
     * <p>
     * Note that Zoos are not added to Animals through this process
     *
     * @param animal the animal object to be saved
     * @return the saved animal object including any automatically generated fields
     */
    Animal save(Animal animal);

    /**
     * Find the first Animal object matching the given name
     *
     * @param name The name (String) of the animal you seek
     * @return The Animal object matching the given name
     */
    Animal findByName(String name);

    public void deleteAll();
}