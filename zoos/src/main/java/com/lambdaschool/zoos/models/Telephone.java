package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

/**
 * The entity allowing interaction with the telephones table
 */
@Entity
@Table(name = "telephones")
public class Telephone
{
    /**
     * The primary key (long) of the telephones table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    private String phonetype;
    /**
     * Email (String) for this zoo. Cannot be nullable.
     * Must be in the format zooid@domain.upperLevelDomain
     */
    @Column(nullable = false)
    private String phonenumber;

    /**
     * The zooid of the zoo assigned to this email is what is stored in the database.
     * This is the entire zoo object!
     * <p>
     * Forms a Many to One relationship between telephones and zoos.
     * A zoo can have many emails.
     */
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "telephones",
            allowSetters = true)
    private Zoo zoo;

    /**
     * The default controller is required by JPA
     */
    public Telephone()
    {
    }

    public Telephone(
        String phonetype,
        String phonenumber,
        Zoo zoo)
    {
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
        this.zoo = zoo;
    }

    public long getPhoneid()
    {
        return phoneid;
    }

    /**
     * Setter for telephoneid. Used for seeding data
     *
     * @param phoneid the new primary key (long) of this telephone object
     */
    public void setPhoneid(long phoneid)
    {
        this.phoneid = phoneid;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    /**
     * Getter for zoo
     *
     * @return the zoo object associated with this telephone.
     */
    public Zoo getZoo()
    {
        return zoo;
    }

    /**
     * Setter for zoo
     *
     * @param zoo the zoo object to replace the one currently assigned to this telephone object
     */
    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }
}
