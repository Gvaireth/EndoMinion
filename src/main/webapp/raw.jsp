<%@page import="com.moomeen.endo2java.model.Workout"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Raw Endomondo data</title>
</head>
<body>
<jsp:useBean id="rawdata" 
                    class="org.gvaireth.server.EndoServiceImpl"/> 
Raw Endomondo workouts list<br><br>
<%List<Workout> workouts=rawdata.getRawWorkouts(); 

%>


<table border="1">
<tr>
<td></td><td>Date</td><td>Distance</td><td>Duration</td><td>sport</td>
</tr>
<%int i=1; %>
<%for(Workout workout:workouts) {%>
<tr>
<td><%=i++ %></td><td><%=workout.getStartTime() %></td><td><%=String.format( "%.2f", workout.getDistance()) %></td><td><%=workout.getDuration().getStandardMinutes()%>m</td><td><%=workout.getSport() %></td>
</tr>

<% }%>

</table>

</body>
</html>