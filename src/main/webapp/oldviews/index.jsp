<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EndoMinion</title>
<link rel="stylesheet" href="/EndoMinion/css/style.css">
<link rel="icon" type="image/png" href="/EndoMinion/img/favicon.png">
</head>

<body>
	<center>
		<table class="mainTable">
			<tr>
				<td width="186" height="186" class="mainTable"><a href="/EndoMinion/"
					style="width: 0px; height: 0px; border: 0;"> <img id="logo"
						src="/EndoMinion/img/avatar.jpg" style="border: 0;">
				</a></td>
				<td class="mainTable" width="800">
					<div id="title">EndoMinion</div>
					<div id="subtitle">Endomondo assistant, tools and statistics</div>
				</td>
			</tr>
			<tr>
				<td class="mainTable"
					style="text-align: center; vertical-align: top;" height="500px">
					<a href="/EndoMinion/old?page=about">About</a><br> <a
					href="/EndoMinion/old?page=workouts">Workouts</a><br> <a
					href="/EndoMinion/old?page=statistics">Statistics</a><br> <a
					href="http://howtotrainyourjee.wordpress.com/">Blog</a><br> <a
					href="/EndoMinion/old?page=experiments">Experiments</a><br> <a
					href="/EndoMinion/index.html">New version</a><br> <!-- 
<a href="/EndoMinion/index?page=prototypes">Prototypes</a><br>
 <a href="/EndoMinion/?page=links">Links</a><br>-->
				</td>
				<td class="mainTable" style="vertical-align: top;"><c:choose>
						<c:when test="${param.page=='about'}">
							<jsp:include page="/oldviews/about.jsp" />
						</c:when>

						<c:when test="${param.page=='workouts'}">
							<jsp:include page="/oldviews/workouts.jsp" />
						</c:when>

						<c:when test="${param.page=='statistics'}">
							<jsp:include page="/oldviews/statistics.jsp" />
						</c:when>

						<c:otherwise>
							<jsp:include page="/oldviews/about.jsp" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
		Copyright (c) 2016 <a
			href="http://howtotrainyourjee.wordpress.com/author/">Gvaireth</a><br>
	</center>
</body>

</html>
