package com.lambdashane.newzoo.repository;

import com.lambdashane.newzoo.models.Animal;
import com.lambdashane.newzoo.views.AnimalCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    @Query(value = "SELECT  a.animaltype as animal, count(z.zooid) as zoocount FROM ANIMAL " +
        "a LEFT JOIN  zooanimals z ON a.animalid = z.animalid " +
        "GROUP BY  animal ORDER BY  zoocount",
        nativeQuery = true)
    List<AnimalCount> getCount();
}
