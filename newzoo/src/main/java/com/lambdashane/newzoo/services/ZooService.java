package com.lambdashane.newzoo.services;

import com.lambdashane.newzoo.models.Zoo;

import java.util.List;

public interface ZooService
{
    List<Zoo> findAll();

    Zoo findZooById(long id);

}
