package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity allowing interaction with the animals table.
 */
@Entity
@Table(name = "animals")
public class Animal
{
    /**
     * The primary key (long) of the animals table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    private String animaltype;

    /**
     * Creates a join table joining Zoos and Animals in a Many-To-Many relations.
     * Contains a List of Zoos Objects using this Animal.
     */
    @ManyToMany(mappedBy = "animals")
    @JsonIgnoreProperties(value = "animals")
    private Set<Zoo> zoos = new HashSet<>();

    /**
     * Default Constructor used primarily by the JPA.
     */
    public Animal()
    {
    }

    public Animal(String animaltype)
    {
        this.animaltype = animaltype;
    }

    /**
     * Getter for animal id
     *
     * @return the animal id, primary key, (long) of this animal
     */
    public long getAnimalid()
    {
        return animalid;
    }

    /**
     * Setter for animal id, used for seeding data
     *
     * @param animalid the new animal id, primary key, (long) for this animal
     */
    public void setAnimalid(long animalid)
    {
        this.animalid = animalid;
    }

    public String getAnimaltype()
    {
        return animaltype;
    }

    public void setAnimaltype(String animaltype)
    {
        this.animaltype = animaltype;
    }

    /**
     * Getter for list of zoos for this animal
     *
     * @return a list of Zoo objects assigned to this animal
     */
    public Set<Zoo> getZoos()
    {
        return zoos;
    }

    /**
     * Setter for list of zoos for this animal
     *
     * @param zoos a new list of Zoo objects to assign to this animal
     */
    public void setZoos(Set<Zoo> zoos)
    {
        this.zoos = zoos;
    }
}
