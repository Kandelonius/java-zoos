package com.lambdashane.newzoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "zoos")
public class Zoo
{
    /**
     * The primary key (long) of the zoos table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    @OneToMany(mappedBy = "zoo",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private List<Telephone> telephones = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "zooanimals",
        joinColumns = @JoinColumn(name = "zooid"),
        inverseJoinColumns = @JoinColumn(name = "animalid"))
    @JsonIgnoreProperties(value = "zoos")
    private Set<Animal> animals = new HashSet<>();

    /**
     * The zooname (String). Cannot be null and must be unique
     */
    @Column(nullable = false,
        unique = true)
    private String zooname;

    public Zoo()
    {
    }

    public Zoo(String zooname)
    {
        this.zooname = zooname;
    }
}
