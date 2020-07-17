package com.lambdashane.newzoo.repository;

import com.lambdashane.newzoo.models.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
}
