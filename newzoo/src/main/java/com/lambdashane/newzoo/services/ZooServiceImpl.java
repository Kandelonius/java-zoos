package com.lambdashane.newzoo.services;

import com.lambdashane.newzoo.models.Zoo;
import com.lambdashane.newzoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{

    @Autowired
    private ZooRepository zoorepos;

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

    public Zoo findZooById(long id) throws
                                      EntityNotFoundException
    {
        return zoorepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Zoo id " + id + " not found!"));
    }
}
