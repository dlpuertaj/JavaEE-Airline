/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controllers;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightDestinations;
import com.airline.service.FlightService;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dlpuertaj
 */
@WebServlet("/addFlight")
public class AddFlight extends HttpServlet {

    @EJB
    FlightService fs;
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Flight flight = new Flight();
        
        flight.setFlightOrigin(FlightDestinations.New_York);
        flight.setFlightDestination(FlightDestinations.Los_Angeles);
        flight.setPrice(400);
        Calendar cal = Calendar.getInstance();
        
        cal.set(Calendar.YEAR, 2014);
        cal.set(Calendar.MONTH, 10);
        cal.set(Calendar.DAY_OF_MONTH, 14);
        cal.set(Calendar.HOUR_OF_DAY, 19);
        cal.set(Calendar.MINUTE, 0);
        
        Date date = cal.getTime();
        
        System.out.println(date);
        
        flight.setFlightTime(date);
        
        Airplane plane = new Airplane();
        
        plane.setModelName("747");
        plane.setPlaneMake("Boeing");
        plane.setSeatingCapacity(250);
        
        flight.setAirplainDetail(plane);
        
        System.out.println(flight);
        System.out.println(plane);
        
        fs.addFlight(flight, plane);
    }

    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
