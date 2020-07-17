package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The CRUD repository connecting Zoo to the rest of the application
 */
public interface ZooRepository
        extends CrudRepository<Zoo, Long>
{
    /**
     * Find a zoo based off over zooname
     *
     * @param zooname the name (String) of zoo you seek
     * @return the first zoo object with the name you seek
     */
    Zoo findByZooname(String zooname);

    /**
     * Find all zoos whose name contains a given substring ignoring case
     *
     * @param name the substring of the names (String) you seek
     * @return List of zoos whose name contain the given substring ignoring case
     */
    List<Zoo> findByZoonameContainingIgnoreCase(String name);
}
