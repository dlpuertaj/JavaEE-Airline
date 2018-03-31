<%-- 
    Document   : add_passenger
    Created on : 29/03/2018, 10:04:50 PM
    Author     : dlpuertaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>World Adventures Airlines</title>
       
        <link rel="stylesheet" href="/resources/css/theme.css">
    </head>
    <body>
        <div class="container">
            <div class="title">Add passenger</div>
            <%
                if(request.getAttribute("errors") != null){   
            %>
            <fieldset>
                <legend>Errors</legend>
                    
                    <ul> 
                        <% if(request.getAttribute("firstNameError") != null){ %>
                            <li class="error">First name error</li>
                        <% } %>
                            
                        <% if(request.getAttribute("lastNameError") != null){ %>
                            <li class="error">Last name error</li>
                        <% } %>
                        
                        <% if(request.getAttribute("date_format_error") != null){ %>
                            <li class="error">Date format error</li>
                        <% } %>
                    </ul>
                
            </fieldset>
            <% 
                }
            %>
            
            <fieldset>
                
                <legend>Passenger details</legend>
                <form action="addPassenger" method="post">
                    <div class="inputField">
                        <label for="first-name" class="inputlabel">
                            First name:<input name="first-name" type="text" value="<%= request.getAttribute("first_name")%>">
                        </label>
                    </div>
                    <div class="inputField">
                        <label for="last-name" class="inputlabel">
                            Last name name:<input name="last-name" type="text" value="<%= request.getAttribute("last_name")%>">
                        </label>
                    </div>
                    <div class="inputField">
                        <label for="dob" class="inputlabel">
                            Date of birth:<input name="dob" type="text" value="<%= request.getAttribute("dob")%>"
                        </label>
                    </div>
                    <div class="inputField">
                        <label for="first-name" class="inputlabel">
                            Gender:<select name="gender">
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                   </select>
                        </label>
                    </div>
                     </fieldset>
                    <div class="inputField" id="submitField">
                        <input id="submitBtn" value="Add new passenger" type="submit">
                    </div>
                </form>
            
            
        </div>
    </body>
</html>
