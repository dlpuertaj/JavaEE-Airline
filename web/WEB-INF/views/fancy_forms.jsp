<%-- 
    Document   : fancy_forms
    Created on : 12/04/2018, 08:34:51 PM
    Author     : dlpuertaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forms</title>
    </head>
    <body>
        <h1 style="text-decoration:underline;">Fancy Forms</h1>
        <a href="index.html">Inicio</a><br/>
        
        <h1>Add flight and airplane</h1>
        
        <form method="POST" action="addFlight">
            From:
            <select id="from_destination" name="from_destination">
                <option value="San_Francisco">San Francisco</option>
                <option value="Los_Angeles">Los Angeles</option>
                <option value="New_York">New York</option>
                <option value="London">London</option>
                <option value="Paris">Paris</option>
                <option value="Rome">Rome</option>
                <option value="Cartagena">Cartagena</option>
                <option value="Amsterdam">Amsterdam</option>
            </select>
            <br/><br/>
            To:
            <select name="to_destination">
                <option value="San_Francisco">San Francisco</option>
                <option value="Los_Angeles">Los Angeles</option>
                <option value="New_York">New York</option>
                <option value="London">London</option>
                <option value="Paris">Paris</option>
                <option value="Rome">Rome</option>
                <option value="Cartagena">Cartagena</option>
                <option value="Amsterdam">Amsterdam</option>
            </select>
            <hr/>
            
            <h4>Time of flight</h4>
            
            Year:
            <select name="year">
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
            </select>
           <br/><br/>
            Month:
            <select name="month">
                <option value="0">January</option>
                <option value="1">February</option>
                <option value="2">March</option>
                <option value="3">April</option>
                <option value="4">May</option>
                <option value="5">June</option>
                <option value="6">July</option>
                <option value="7">August</option>
                <option value="8">September</option>
                <option value="9">October</option>
                <option value="10">November</option>
                <option value="11">December</option>
            </select>
            <br/><br/>
            Day of month:
            <input name="day" type="text">
            <br/><br/>
            
            Hour of day (0-23):
            <input name="hour" type="text">
            <br/><br/>
            
            Minute (0-59):
            <input name="minute" type="text">
            <br/><br/>
                    
            Price:
            <input name="price" type="text">
            <hr/>
            
            <h4>Airplane</h4>
            Plane make:
            <input name="airplane_make" type="text">
            <br/><br/>
            
            Model name:
            <input name="airplane_model" type="text">
            <br/><br/>
            
            Seating:
            <input name="airplane_seating" type="text">
            
            <hr/>
            <button type="submit">Add flight and airplane</button>
            <hr/>
        </form>
            
        <h1>Add pilot to flight</h1>  
        <form method="POST" action="addPilotToFlight">
            First name:
            <input name="first_name" type="text">
            <br/><br/>
            
            Last name:
            <input name="last_name" type="text">
            <br/><br/>
            
            License:
            <input name="license" type="text">
            <br/><br/>
            
            Pilot rank:
            <select name="pilot_rank">
                <option value="Captain">Captain</option>
                <option value="First_Officer">First Officer</option>
                <option value="Junior_Officer">Junior Officer</option>
            </select>
            
            <br /><br />
            
            Flight Id:
            <input name="fId" type="text">
            
            <hr />
            <button type="submit">Add pilot to flight</button>
            <hr />
            
        </form>
        
        <h1>Add Passenger</h1>  
        <form method="POST" action="addPassenger">
            First name:
            <input name="first_name" type="text">
            <br /><br />
            
            Last name:
            <input name="last_name" type="text">
            <br /><br />
            
            Date of birth:
            <input name="dob" type="text">
            <br /><br />
            
            Gender:
            <select name="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
            
            <hr/>
            <button type="submit">Add passenger</button>
            <hr/>
        </form>
        
        
        <h1>Add passenger to flight</h1>
        
        <form method="POST" action="AddPassengerToFlight">
            Add a passenger with an id of 
            <input name="pId" type="text">
            
            to a flight with an id of 
            <input name="fId" type="text">
            
            <hr />
            
            <button type="submit">Add passenger to flight</button>
            
            <hr />
        </form>
        
        <h1>
            Add flight to passenger <span style="font-size: 16px; vertical-align: middle;">
            (Give a passenger another flight ticket to his\her collection of
             flight tickets)</span>
        </h1>
        
        <form method="post" action="AddFlightTicketToPassenger">
            Add a ticket for a flight with an id of
            
            <input name="fId" type="text">
            
            to a passenger with an id of
            <input name="pId" type="text">
            
            <br /><br />
            <span style="font-weight: bold;">(In real world terms -  add the 
                                              flight ticket t the passenger's 
                                              collection of flight tickets)</span>
            <hr />
            <button type="submit">Add flight (ticket) to passenger's flight tickets</button>
            <hr />
        </form>
    </body>
</html>
