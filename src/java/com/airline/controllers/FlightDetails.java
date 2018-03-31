/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controllers;

import com.airline.service.FlightLocal;
import com.airline.service.FlightRemote;
import com.airline.service.FlightServiceStatlessBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dlpuertaj
 */
@WebServlet(name = "FlightDetails", urlPatterns = {"/flightDetails"})
public class FlightDetails extends HttpServlet {

    //Le preguntamos al contenedor EJB darnos una instancia del bean desde su pool
    //Inyectamos el objeto FlightServiceStatlessBean
    /* Es posible que se este refiriendo a un objeto diferente
     * ya que el pool contiene muchos objetos. Esta caracteristica
     * se da por ser Stateless*/
    @EJB(beanName = "flightStateless") // comentado para probar sin usarlo y obtener el objeto manuelmente
    private FlightLocal fs; 
    /**/
    
    @EJB(beanName = "flightStateless") // comentado para probar sin usarlo y obtener el objeto manuelmente
    private FlightLocal fs2; 
        
    @EJB(beanName = "flightStatefull") // comentado para probar sin usarlo y obtener el objeto manuelmente
    private FlightLocal fsStatefull;
    
    @EJB(beanName = "flightStatefull") // comentado para probar sin usarlo y obtener el objeto manuelmente
    private FlightLocal fsStatefull2; 
    
    /*Al usar el bean remoto, está consumiendo mas recursos computacionales
     * y fisicos ya que con el local, el servidor ya presupone que es local*/
//    @EJB
//    private FlightRemote remote;

    /** 
     * Son tres objetos pero con la misma referencia. Como el bean de sesión es Stateless, el contenedor
     * le da un mismo objeto a cada variable FLightService*/
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        try {
//            /*JNDI contiene referencias a recursos*/
//            Context context = new InitialContext();
//            Object fObj = context.lookup("java:global/WebOne/FlightService!com.airline.service.FlightServiceStatlessBean");
//            fs = (FlightServiceStatlessBean) fObj;
//            
//        } catch (NamingException e) {
//            System.out.println("Naming exception has occured when truing to lookup the FlightServiceStatlessBean Enterprise Java Bean");
//            e.printStackTrace();
//        } 
       
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FlightDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h2>The flights details has been called...<h2>");
            
            //Stateless
            out.println("<h3> Flight details "+fs.getFrom()+" to "+fs.getDestination()+"</h3>");
            fs2.setFrom("Paris");
            fs2.setDestination("Rome");
            out.println("<h3> Flight details "+fs.getFrom()+" to "+fs.getDestination()+"</h3>");
            /* Se corre el metodo de una instancea aleatoria del pool
             * ya que es statless*/
            //Statefull
            out.println("<h3> Flight details "+fsStatefull.getFrom()+" to "+fsStatefull.getDestination()+"</h3>");
            fsStatefull2.setFrom("Bogotá");
            fsStatefull2.setDestination("Cartagena");
            out.println("<h3> Flight details "+fsStatefull.getFrom()+" to "+fsStatefull.getDestination()+"</h3>");
            out.println("<h3> Flight details "+fsStatefull2.getFrom()+" to "+fsStatefull2.getDestination()+"</h3>");

            /* En este claso solo se crea un objeto, asi que la referencia
             * sera la misma que se ha creado   
             * */
            out.println("</body>");
            out.println("</html>");
        
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
