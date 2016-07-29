app.controller('fetchController', function($scope, $http) {
	$scope.getTime=
	$http.get('/angular/getTime').success(function(data) {
		alert("success");
		$scope.time = data;
	}).error(function(data) {
		alert("failure");
	});
});