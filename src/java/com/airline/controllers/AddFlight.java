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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*El nombre del parámetro es el nombre del formulario*/
        
        Flight flight = new Flight();
        
        String from_destination = request.getParameter("from_destination");
        flight.setFlightOrigin(FlightDestinations.valueOf(from_destination));
        
        String to_destination = request.getParameter("to_destination");
        flight.setFlightDestination(FlightDestinations.valueOf(to_destination));
        
        Integer price = Integer.parseInt(request.getParameter("price"));
        flight.setPrice(price);
        
        Integer year = Integer.parseInt(request.getParameter("year"));
        Integer month = Integer.parseInt(request.getParameter("month"));
        Integer day = Integer.parseInt(request.getParameter("day"));
        Integer hour = Integer.parseInt(request.getParameter("hour"));
        Integer minute = Integer.parseInt(request.getParameter("minute"));
        Calendar cal = Calendar.getInstance();
        
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        
        Date date = cal.getTime();

        flight.setFlightTime(date);
        
        Airplane plane = new Airplane();
        
        String airPlaneModel = request.getParameter("airplane_model");
        plane.setModelName(airPlaneModel);
        
        String airPlaneMake = request.getParameter("airplane_make");
        plane.setPlaneMake(airPlaneMake);
        
        Integer seating = Integer.parseInt(request.getParameter("airplane_seating"));
        plane.setSeatingCapacity(seating);
        
        flight.setAirplaneDetail(plane);
        
        fs.addFlight(flight, plane);
        
        response.sendRedirect("Flights");
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
