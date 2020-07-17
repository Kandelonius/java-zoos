package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Animal;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Animal to the rest of the application
 */
public interface AnimalRepository
        extends CrudRepository<Animal, Long>
{
    /**
     * JPA Query to find a animal by name case insensitive search
     *
     * @param name the name of the animal which you seek
     * @return the first animal matching the given name using a case insensitive search
     */
    Animal findByNameIgnoreCase(String name);
}
