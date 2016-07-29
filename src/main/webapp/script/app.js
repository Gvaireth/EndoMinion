var endoMinion = angular.module('endoMinion', []);
 endoMinion.controller('mainCtrl', function($scope) {
 $scope.message='message from controler';
 });
 
 endoMinion.controller('workoutsCtrl', function($scope) {
		$scope.message = 'Workouts page.';
	});

	endoMinion.controller('statisticsCtrl', function($scope) {
		$scope.message = 'Statistics page.';
	});
/*
endoMinion.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/about.html',
		controller : 'mainCtrl'
	}).when('/workouts', {
		templateUrl : '/workouts.html',
		controller : 'workoutsCtrl'
	}).when('/statistics', {
		templateUrl : '/statistics.html',
		controller : 'statisticsCtrl'
	});
});
*/
