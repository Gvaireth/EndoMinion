var endoMinion = angular.module('endoMinion', ['ngRoute']);
 endoMinion.controller('mainCtrl', function($scope) {
 $scope.message='message from controler';
 });
 
 endoMinion.controller('workoutsCtrl', function($scope) {
		$scope.message = 'Workouts page.';
	});

	endoMinion.controller('statisticsCtrl', function($scope) {
		$scope.message = 'Statistics page.';
	});

endoMinion.config(function($routeProvider) {
	$routeProvider.when('/about', {
		templateUrl : '/home/about.html',
		controller : 'mainCtrl'
	}).when('/workouts', {
		templateUrl : '/home/workouts.html',
		controller : 'workoutsCtrl'
	}).when('/statistics', {
		templateUrl : '/home/statistics.html',
		controller : 'statisticsCtrl'
	});
});

