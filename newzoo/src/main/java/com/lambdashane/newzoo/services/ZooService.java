package com.lambdashane.newzoo.services;

import com.lambdashane.newzoo.models.Zoo;
import com.lambdashane.newzoo.views.AnimalCount;

import java.util.List;

public interface ZooService
{
    List<Zoo> findAll();

    Zoo findZooById(long id);



}
