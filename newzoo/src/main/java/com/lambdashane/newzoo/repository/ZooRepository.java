package com.lambdashane.newzoo.repository;

import com.lambdashane.newzoo.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{
}
