/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * Esta entidad la conectado con una relación Uno a Muchos con vuelo
 * @author dlpuertaj
 */
@NamedQuery(name = "Pilot.findById",
            query = "SELECT p FROM Pilot P WHERE p.id = :id")//Nos permite agregar query para buscar datos
@Entity
public class Pilot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    private Integer pilotLicense;
    
    @Enumerated(EnumType.STRING)
    private PilotRank pilotRank;
    
    @ManyToOne
    @JoinColumn(name = "flight_fk")
    private Flight flightForPilot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPilotLicense() {
        return pilotLicense;
    }

    public void setPilotLicense(Integer pilotLicense) {
        this.pilotLicense = pilotLicense;
    }

    public PilotRank getPilotRank() {
        return pilotRank;
    }

    public void setPilotRank(PilotRank pilotRank) {
        this.pilotRank = pilotRank;
    }

    public Flight getFlightForPilot() {
        return flightForPilot;
    }

    public void setFlightForPilot(Flight flightForPilot) {
        this.flightForPilot = flightForPilot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilot)) {
            return false;
        }
        Pilot other = (Pilot) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
    
    
}
