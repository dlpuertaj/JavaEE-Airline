/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controllers;

import com.airline.models.FlightClass;
import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.PassengerService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dlpuertaj
 */
@WebServlet({"/addPassenger"})
public class AddPassenger extends HttpServlet {

    @EJB
    PassengerService ps;
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
        

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        Integer license = Integer.parseInt(request.getParameter("license"));
        String rank = request.getParameter("pilot_rank");
        
        
        Passenger p = new Passenger();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setPilotLicense(license);
        p.setPilotRank(PilotRank.valueOf(rank));
        
        String flightId = request.getParameter("fId");
        
        ps.addNewPilotToFlight(p, flightId);
        
        response.sendRedirect("Flights");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Guardamos el atributo error en el request como falso
        request.setAttribute("errors", false);
        Passenger p = new Passenger();//Creamos objeto Passenger para guardar los atributos

        /* Para obtener los datos del formulario en la pagina
         * add_passenger.jsp, usamos request.getärameter en donde
         * le pasamos como parametro el atributo name de la etiqueta
         * input usada en el formulario*/
        String firstName = request.getParameter("first-name");
        
        String dob_raw = request.getParameter("dob");        
        String gender = request.getParameter("gender");
        p.setGender(Gender.valueOf(gender));
        
        /* Condicioones para mostrar mensaje de error cuando el usuario
         * no escribió datos en alguno de los campos del formulario*/
        if(firstName.length() == 0){
            request.setAttribute("errors", true);//Hacemos atriburo errors = true
            request.setAttribute("firstNameError", true);//Cada campo tendrá su atributo
            request.setAttribute("first_name", "");
        }else{
            /* si el usuario escribió en el campo, asignarlo al objeto}
             * y guardarlo en atributo.
             * En el jsp usamos <%= %> para darle el valor a la etiqueta value*/
            p.setFirstName(firstName);
            request.setAttribute("first_name", firstName);
        }
        
        String lastName = request.getParameter("last-name");
        if(lastName.length() == 0){
            request.setAttribute("errors", true);
            request.setAttribute("lastNameError", true);
            request.setAttribute("last_name", lastName);
        }else{
            p.setFirstName(lastName);
            request.setAttribute("last_name", lastName);
        }
        
        /* Usamos patron para verificar la fecha de nacimiento*/
        String[] dobArray = dob_raw.split("\\/");
        
        String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
        Pattern r = Pattern.compile(pattern);
        
        Matcher m = r.matcher(dob_raw);

        if(m.find()){
            String month = dobArray[0];
            String day = dobArray[1];
            String year = dobArray[2];

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, Integer.parseInt(year));
            cal.set(Calendar.MONTH, Integer.parseInt(month));
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

            Date date = cal.getTime();
            p.setDob(date);
            request.setAttribute("dob", dob_raw);
        }else{
            request.setAttribute("errors", true);
            request.setAttribute("date_format_error", true);
            request.setAttribute("dob",dob_raw);
            if(dob_raw.length() == 0){
                request.setAttribute("dob", dob_raw);
            }
        }
        
        /* Si hay error, retornamos al formulario. Si no, agregamos al pasajero
         * a la lista de pasajeros*/
        if((Boolean)request.getAttribute("errors")){
            RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
            view.forward(request, response);
        }else{
            /* Como es una lista de pasajeros, queremos que se mantenga. Ya que
             * si se guarda como atributo en el request, apenas salgamos del formulario
             * o querramos agregar otro pasajero, la lista se perderá, por lo tanto,
             * guardamos la lista en el contexto del servlet.*/
            ServletContext context = this.getServletContext();
            
            /* para evitar que dos o mas personas al tiempo modifiquen la lista
             * hacemos que esto se haga de manera sincronizada*/
            synchronized(this){
                /* Para no crear un lista nueva cada vez que un usuario
                 * agregue una pasajero, lo que hace que solo este el 
                 * pasajero que agrega el usuario. extraemos o retornamos
                 * la lista del contexto de la aplicación, la cual
                 * debe ser creada cuando se inicia la aplicaión por medio
                 * del Listener que escucha cuando se crea la aplicación*/
                ArrayList<Passenger> pList = (ArrayList<Passenger>) context.getAttribute("passengers");
                pList.add(p);           
                context.setAttribute("passengers", pList);
            }
            response.sendRedirect("");
        }
        
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
