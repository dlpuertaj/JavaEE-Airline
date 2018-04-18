<%-- 
    Document   : flight_list
    Created on : 11/04/2018, 01:43:16 AM
    Author     : dlpuertaj
--%>

<%@page import="com.airline.models.Airplane"%>
<%@page import="com.airline.models.Passenger"%>
<%@page import="com.airline.models.Pilot"%>
<%@page import="com.airline.models.Flight"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resources/css/jpaStyles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airplanes List</title>
    <body>
        <h1>List of Airplanes</h1>

        <table>
            <tr>
                <th>Id</th>
                <th>Maker</th>
                <th>Model</th>
                <th>Capacity</th>
            </tr>
            <%
                List<Airplane> planesList = (List<Airplane>) request.getAttribute("airplanes");
                for (int i = 0; i < planesList.size(); i++) {
            %>
            <tr>
                <td><%= planesList.get(i).getId()%></td>
                <td><%= planesList.get(i).getPlaneMake()%></td>
                <td><%= planesList.get(i).getModelName()%></td>
                <td><%= planesList.get(i).getSeatingCapacity()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
