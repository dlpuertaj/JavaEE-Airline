/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author dlpuertaj
 */

@Entity
@XmlRootElement // Para que el webservice lo use y convertir el objeto a XML
public class Passenger implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;

    /* Es un enum Gender. Lo hacemos String para que se guarde en 
     *la base de datos como texto y no como un numero o digito*/
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;

    @ManyToMany(mappedBy = "passengers")
    private List<Flight> flights;
    
    public Passenger() {
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger{" + "firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob + '}';
    }

}
