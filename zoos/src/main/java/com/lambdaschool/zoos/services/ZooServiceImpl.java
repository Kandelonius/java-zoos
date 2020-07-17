package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements ZooService Interface
 */
@Transactional
@Service(value = "zooService")
public class ZooServiceImpl
        implements ZooService
{
    /**
     * Connects this service to the Zoo table.
     */
    @Autowired
    private ZooRepository zoorepos;

    /**
     * Connects this service to the Animal table
     */
    @Autowired
    private AnimalService animalService;


    public Zoo findZooById(long id) throws
            EntityNotFoundException
    {
        return zoorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo id " + id + " not found!"));
    }

    @Override
    public List<Zoo> findByNameContaining(String zooname)
    {
        return zoorepos.findByZoonameContainingIgnoreCase(zooname.toLowerCase());
    }

    @Override
    public List<Zoo> findAll()
    {
        List<Zoo> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        zoorepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        zoorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo id " + id + " not found!"));
        zoorepos.deleteById(id);
    }

    @Override
    public Zoo findByName(String name)
    {
        Zoo uu = zoorepos.findByZooname(name.toLowerCase());
        if (uu == null)
        {
            throw new EntityNotFoundException("Zoo name " + name + " not found!");
        }
        return uu;
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo)
    {
        Zoo newZoo = new Zoo();

        if (zoo.getZooid() != 0)
        {
            zoorepos.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException("Zoo id " + zoo.getZooid() + " not found!"));
            newZoo.setZooid(zoo.getZooid());
        }

//        newZoo.setZooname(zoo.getZooname()
//                                    .toLowerCase());
//        newZoo.setPassword(zoo.getPassword());
//        newZoo.setPrimaryemail(zoo.getPrimaryemail()
//                                        .toLowerCase());

        newZoo.getAnimals()
                .clear();
        for (Animal r : zoo.getAnimals())
        {
            Animal newAnimal = animalService.findAnimalById(r.getAnimalid());

            newZoo.getAnimals()
                    .add(newAnimal);
        }

        newZoo.getTelephones()
                .clear();
        for (Telephone ue : zoo.getTelephones())
        {
            newZoo.getTelephones()
                    .add(new Telephone(newZoo,
                                       ue.getPhonenumber()));
        }

        return zoorepos.save(newZoo);
    }

//    @Transactional
//    @Override
//    public Zoo update(
//            Zoo zoo,
//            long id)
//    {
//        Zoo currentZoo = findZooById(id);
//
//        if (zoo.getZooname() != null)
//        {
//            currentZoo.setZooname(zoo.getZooname()
//                                            .toLowerCase());
//        }

//        if (zoo.getPassword() != null)
//        {
//            currentZoo.setPassword(zoo.getPassword());
//        }
//
//        if (zoo.getPrimaryemail() != null)
//        {
//            currentZoo.setPrimaryemail(zoo.getPrimaryemail()
//                                                .toLowerCase());
//        }

//        if (zoo.getAnimals()
//                .size() > 0)
//        {
//            currentZoo.getAnimals()
//                    .clear();
//            for (Animal r : zoo.getAnimals())
//            {
//                Animal newAnimal = animalService.findAnimalById(r.getAnimalid());
//
//                currentZoo.getAnimals()
//                        .add(newAnimal);
//            }
//        }

//        if (zoo.getTelephones()
//                .size() > 0)
//        {
//            currentZoo.getTelephones()
//                    .clear();
//            for (Telephone ue : zoo.getTelephones())
//            {
//                currentZoo.getTelephones()
//                        .add(new Telephone(currentZoo,
//                                           ue.getTelephone()));
//            }
//        }
//
//        return zoorepos.save(currentZoo);
//    }

//    @Transactional
//    @Override
//    public void deleteAll()
//    {
//        zoorepos.deleteAll();
//    }
}
