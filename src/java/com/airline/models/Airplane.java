/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dlpuertaj
 */
@Entity
@XmlRootElement
public class Airplane implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String planeMake;

    private String modelName;

    private Integer seatingCapacity;

    /* Confirmamos la relacion airplain - flight.
     * Le ponemos el mappedBy para que mapée con el atributo airline
     * que está en Flight.*/
    @OneToOne(mappedBy = "airplaneDetail")
    private Flight flight;

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getPlaneMake() {
        return planeMake;
    }

    public void setPlaneMake(String planeMake) {
        this.planeMake = planeMake;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
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
        if (!(object instanceof Airplane)) {
            return false;
        }
        Airplane other = (Airplane) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Airplain{" + "id=" + id + ", planeMake=" + planeMake + ", modelName=" + modelName + ", seatingCapacity=" + seatingCapacity + '}';
    }

}
