package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the TelephoneService Interface
 */
@Transactional
@Service(value = "telephoneService")
public class TelephoneServiceImpl
        implements TelephoneService
{
    /**
     * Connects this service to the Telephone model
     */
    @Autowired
    private TelephoneRepository telephonerepos;

    /**
     * Connects this servive to the Zoo Service
     */
    @Autowired
    private ZooService zooService;

    @Override
    public List<Telephone> findAll()
    {
        List<Telephone> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        telephonerepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Telephone findTelephoneById(long id)
    {
        return telephonerepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Telephone with id " + id + " Not Found!"));
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if (telephonerepos.findById(id)
                .isPresent())
        {
            telephonerepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException("Telephone with id " + id + " Not Found!");
        }
    }

//    @Transactional
//    @Override
//    public Telephone update(
//            long telephoneid,
//            String phonenumber)
//    {
//        if (telephonerepos.findById(telephoneid)
//                .isPresent())
//        {
//            Telephone telephone = findTelephoneById(telephoneid);
//            telephone.setPhonenumber(phonenumber.toLowerCase());
//            return telephonerepos.save(telephone);
//        } else
//        {
//            throw new EntityNotFoundException("Telephone with id " + telephoneid + " Not Found!");
//        }
//    }

    @Transactional
    @Override
    public Telephone save(
            long zooid,
            String phonetype,
            String phonenumber)
    {
        Zoo currentZoo = zooService.findZooById(zooid);

        Telephone newTelephone = new Telephone(currentZoo);
        return telephonerepos.save(newTelephone);
    }
}
