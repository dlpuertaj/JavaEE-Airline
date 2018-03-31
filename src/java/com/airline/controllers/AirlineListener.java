/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controllers;

import com.airline.models.Passenger;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author dlpuertaj
 */
@WebListener
public class AirlineListener implements ServletContextListener {

    /*Como al iniciar la aplicación, la lista no existe, por lo que 
     * existe el peligro de que sea nulo cuando se quiera agregar el
     * primer pasajero, lo que hacemos es crear este listener para
     * que en la inicialización del contexto, quiere decir, en la 
     * inicialización de la aplicación se cree la lista de pasajeros
     * y se agregue en el contexto del servlet*/
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        ArrayList<Passenger> pList = (ArrayList<Passenger>) context.getAttribute("passengers");
        if(pList == null){
            System.out.println("No passenger list");
            pList = new ArrayList<>();
            context.setAttribute("passengers", pList);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
