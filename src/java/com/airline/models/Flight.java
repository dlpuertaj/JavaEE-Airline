/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dlpuertaj
 */
@NamedQuery(name = "Flight.findById",
            query = "SELECT f FROM Flight f WHERE f.id = :id")//Nos permite agregar query para buscar datos

@Entity
@XmlRootElement
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

    /* Un vuelo tiene muchos pilotos*/
    @OneToMany(mappedBy = "flightForPilot")
    private List<Pilot> pilots;
    
    
    @ManyToMany
    @JoinTable(name = "f_p_join", joinColumns = @JoinColumn(name = "flight_fk"), inverseJoinColumns = @JoinColumn(name = "passenger_fk"))//Nueva tabla en la db para unir vuelos con pasajeros
    private List<Passenger> passengers;

    /*Hacemos que flight tenga una relación una a uno con Airplain.
     * Hacemos que dicha relación sea por medio de la llave foranea*/
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})//Cascade propagation with airplane
    @JoinColumn(name = "airplane_fk")//agrega llave foranea airplain_fk
    private Airplane airplaneDetail;

    
    public Airplane getAirplaneDetail() {
        return airplaneDetail;
    }

    public void setAirplaneDetail(Airplane airplaneDetail) {
        this.airplaneDetail = airplaneDetail;
    }

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

    @XmlTransient
    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
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

    @XmlTransient
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPasengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", flightOrigin=" + flightOrigin + ", flightDestination=" + flightDestination + ", price=" + price + ", flightTime=" + flightTime + ", pilots=" + pilots + ", airplaneDetail=" + airplaneDetail + '}';
    }

}