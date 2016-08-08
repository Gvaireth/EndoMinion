<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Workouts</title>
</head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    	padding: 3px;
}
</style>
<body>
	Workouts 
	<br><br>
	<form action="/EndoMinion/?page=workouts" method="GET">
	 <button type="submit" name="action" value="update">Update data</button>
	 </form>
	<table>
	<tr>
	<td>no.</td>
	<td>Start time</td>
	<td>Duration</td>
	<td>Duration<br>rank #</td>
	<td>Distance<br>km</td>
	<td>Distance<br>rank #</td>
	<td>Calories</td>
	<td>Avg speed<br>km/h</td>
	<td>Avg speed<br>rank #</td>
	<td>Activity</td>
	</tr>
		<c:forEach items="${data}" var="workout" varStatus="status">
			<tr>
			<td>${size-status.index }</td>
				<td>${workout.readableStartTime} </td>
				<td>${workout.readableDuration} </td>
				<td>${workout.durationRank} </td>
				<td>${workout.distance}</td>
				<td>${workout.distanceRank} </td>
				<td>${workout.calories} </td>
				<td>${workout.speedAvg} </td>
				<td>${workout.speedAvgRank} </td>
				<td>${workout.sport} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>