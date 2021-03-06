/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import javax.ejb.Local;

/**
 *
 * @author dlpuertaj
 */
@Local
public interface FlightLocal {
    //Una interface no implementa los metodos
    
    @Override
    public String toString();

    public Integer getId();

    public void setId(Integer id);

    public Integer getPrice();

    public void setPrice(Integer price);

    public Integer getNumSeats();

    public void setNumSeats(Integer numSeats);

    public String getDestination();

    public void setDestination(String destination);

    public String getFrom();

    public void setFrom(String from);

    public String getAirplainModel();

    public void setAirplainModel(String airplainModel);
}
