<%-- 
    Document   : flight_list
    Created on : 11/04/2018, 01:43:16 AM
    Author     : dlpuertaj
--%>

<%@page import="com.airline.models.Pilot"%>
<%@page import="com.airline.models.Flight"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resources/css/jpaStyles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flights List</title>
    <body>
        <h1>List of flights</h1>

        <table>
            <tr>
                <th>Id</th>
                <th>From</th>
                <th>To</th>
                <th>Time</th>
                <th>Price</th>
                <th>Airplane</th>
                <th>Seating</th>
                <th>Number of pilots</th>
                <th>Pilot names</th>
            </tr>
            <%
                List<Flight> fList = (List<Flight>) request.getAttribute("flight_list");
                for (int i = 0; i < fList.size(); i++) {
            %>
            <tr>
                <td><%= fList.get(i).getId()%></td>
                <td><%= fList.get(i).getFlightOrigin()%></td>
                <td><%= fList.get(i).getFlightDestination()%></td>
                <td><%= fList.get(i).getFlightTime()%></td>
                <td><%= fList.get(i).getPrice()%></td>

                <td><%= fList.get(i).getAirplainDetail().getPlaneMake() + " " + fList.get(i).getAirplainDetail().getModelName()%></td>
                <td><%= fList.get(i).getAirplainDetail().getSeatingCapacity()%></td>

                <td>

                    <%

                        if (fList.get(i).getPilots() != null) {

                    %>

                    <%= fList.get(i).getPilots().size()%>

                    <%
                    } else {
                    %>
                    No pilots yet
                    <%
                        }
                    %>                        
                </td>

                <td>

                    <%
                        if (fList.get(i).getPilots() != null) {
                            List<Pilot> pList = (List<Pilot>) fList.get(i).getPilots();

                            for (int j = 0; j < pList.size(); j++) {

                    %>

                    <%=(j + 1) + ") " + pList.get(j).getFirstName() + " " + pList.get(j).getLastName() + " (" + pList.get(j).getPilotRank() + ")" + "<br/>"%>

                    <%
                        }//for
                    %>

                    <%
                        }//if
                    %>                        
                </td>
            </tr>
            <tr>
                <td colspan="8" style="text-align: center">No passengers on this flight yet</td>
            </tr>

            <%
                }
            %>
        </table>
    </body>
</html>
