/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import javax.ejb.Stateless;

/**
 *
 * @author dlpuertaj
 * Stateless session bean tiene como caracteristica que no tiene.
 */
@Stateless(name = "flightStateless")
//@LocalBean //Solo puede ser accedido por aplicaciones que estan corriendo de manera local
public class FlightServiceStatlessBean implements FlightLocal,FlightRemote{

    private Integer id = 2348357;
    private Integer price = 400;
    private Integer numSeats = 250;
    private String destination = "London";
    private String from = "Los Angeles";
    private String airplainModel = "Boing 787";

    @Override
    public String toString() {
        return "FlightService{" + "id=" + id + ", price=" + price + ", numSeats=" + numSeats + ", destination=" + destination + ", from=" + from + ", airplainModel=" + airplainModel + '}';
    }
    
    public FlightServiceStatlessBean(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(Integer numSeats) {
        this.numSeats = numSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getAirplainModel() {
        return airplainModel;
    }

    public void setAirplainModel(String airplainModel) {
        this.airplainModel = airplainModel;
    }
    
    
    
}
