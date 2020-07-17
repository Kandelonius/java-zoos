package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.repository.AnimalRepository;
import com.lambdaschool.zoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the AnimalService Interface
 */
@Transactional
@Service(value = "animalService")
public class AnimalServiceImpl
        implements AnimalService
{
    /**
     * Connects this service to the Animal Model
     */
    @Autowired
    AnimalRepository animalrepos;

    /**
     * Connect this service to the Zoo Model
     */
    @Autowired
    ZooRepository zoorepos;

    @Override
    public List<Animal> findAll()
    {
        List<Animal> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        animalrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }


    @Override
    public Animal findAnimalById(long id)
    {
        return animalrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal id " + id + " not found!"));
    }

    @Override
    public Animal findByName(String name)
    {
        Animal rr = animalrepos.findByNameIgnoreCase(name);

        if (rr != null)
        {
            return rr;
        } else
        {
            throw new EntityNotFoundException(name);
        }
    }

    @Transactional
    @Override
    public Animal save(Animal animal)
    {
        if (animal.getZoos()
                .size() > 0)
        {
            throw new EntityExistsException("Zoo Animals are not updated through Animal.");
        }

        return animalrepos.save(animal);
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        animalrepos.deleteAll();
    }
}
