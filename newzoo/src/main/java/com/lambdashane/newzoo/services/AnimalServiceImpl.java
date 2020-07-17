package com.lambdashane.newzoo.services;

import com.lambdashane.newzoo.repository.AnimalRepository;
import com.lambdashane.newzoo.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService
{

    @Autowired
    AnimalRepository animalrepos;

    @Override
    public List<AnimalCount> getCount()
    {
        return animalrepos.getCount();
    }
}
