<%-- 
    Document   : flight_list
    Created on : 11/04/2018, 01:43:16 AM
    Author     : dlpuertaj
--%>

<%@page import="com.airline.models.Passenger"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resources/css/jpaStyles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passengers List</title>
    <body>
        <h1>List of Passengers</h1>

        <table>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Gender</th>
                <th>Date of birth</th>
            </tr>
            <%
                List<Passenger> pList = (List<Passenger>) request.getAttribute("passenger_list");
                for (int i = 0; i < pList.size(); i++) {
            %>
            <tr>
                <td><%= pList.get(i).getFirstName() %></td>
                <td><%= pList.get(i).getLastName() %></td>
                <td><%= pList.get(i).getDob() %></td>
                <td><%= pList.get(i).getGender() %></td>

            </tr>
            
            <tr>
                <td colspan="4">No flight tickets yet</td>
            </tr>

            <%
                }
            %>
        </table>
    </body>
</html>
