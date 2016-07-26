<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gvaireth's home "page"</title>
</head>

<style>

.mainTable {
    border: 1px solid grey;
    	padding: 5px;
    		border-collapse: collapse;
}

.innerTable {
border:  0px solid black;
border-collapse: collapse;
}

a:link {
    text-decoration: none;
}

a:visited {
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

</style>
<body>
<center>
<table class="mainTable">
<tr >
<td width="186" height="186" class="mainTable">
 <a href="/home/" style="width:0px;height:0px;border:0;"> 
<img id="logo" src="/home/img/avatar.jpg"  style="border:0;">
</a>
</td>
<td style="font-size:30px;text-align: center" class="mainTable"width="800">Gvaireth's home "page"</td>
</tr>
<tr > 
<td class="mainTable" style="text-align: center;vertical-align: top;" height="500px" >
<a href="http://howtotrainyourjee.wordpress.com/">Blog</a><br> 
<a href="/home/?page=about">About</a><br>
<a href="/home/?page=prototypes">Prototypes</a><br>
<!--  <a href="/home/?page=links">Links</a><br>-->
</td >
<td class="mainTable" style="vertical-align: top;">
   <c:choose>
        <c:when test="${param.page=='prototypes'}">
        <jsp:include page="/prototypes.jsp" />
		</c:when>
        <c:when test="${param.page=='about'}">
         <jsp:include page="/about.jsp" /> 
        </c:when>
            <c:when test="${param.page=='links'}">
         <jsp:include page="/links.jsp" />  
        </c:when>
        <c:otherwise>
        <jsp:include page="/about.jsp" /> 
        </c:otherwise>
    </c:choose>

</td>
</tr>
</table>

</center>
</body>

</html>
