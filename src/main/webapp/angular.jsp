<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<body>
boo
   
<div ng-app >
Binding2
  
  <p>Name : <input type="text" ng-model="name"></p>
  <h1>Hello {{name}}</h1>
<!--
  Fetching data from server<br>  
  <button id = "fetch" ng-click="getTime()">load</button>
  Msg from server:{{$scope.time}}
  -->
</div>

</body>
</html>