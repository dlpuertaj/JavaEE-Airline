/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import javax.ejb.Stateful;


/**
 *
 * @author dlpuertaj
 */
@Stateful(name = "flightStateful")
//@LocalBean //Solo puede ser accedido por aplicaciones que estan corriendo de manera local
public class FlightServiceStatefulBean implements FlightLocal{

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
    
    public FlightServiceStatefulBean(){
        
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public Integer getNumSeats() {
        return numSeats;
    }

    @Override
    public void setNumSeats(Integer numSeats) {
        this.numSeats = numSeats;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String getAirplainModel() {
        return airplainModel;
    }

    @Override
    public void setAirplainModel(String airplainModel) {
        this.airplainModel = airplainModel;
    }
    
    
    
}
