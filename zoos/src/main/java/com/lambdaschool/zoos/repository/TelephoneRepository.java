package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Telephone;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Telephone to the rest of the application
 */
public interface TelephoneRepository
        extends CrudRepository<Telephone, Long>
{
}
