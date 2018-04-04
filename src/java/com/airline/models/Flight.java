/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dlpuertaj
 */
@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private FlightDestinations flightOrigin;

    @Enumerated(EnumType.STRING)
    private FlightDestinations flightDestination;

    private Integer price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date flightTime;

    public FlightDestinations getFlightOrigin() {
        return flightOrigin;
    }

    public void setFlightOrigin(FlightDestinations flightOrigin) {
        this.flightOrigin = flightOrigin;
    }

    public FlightDestinations getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(FlightDestinations flightDestination) {
        this.flightDestination = flightDestination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", flightOrigin=" + flightOrigin + ", flightDestination=" + flightDestination + ", price=" + price + ", flightTime=" + flightTime + '}';
    }

}
