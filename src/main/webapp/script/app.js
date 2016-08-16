var endoMinion = angular.module('endoMinion', [ 'ngRoute', 'ui.grid'/* ,'ngMap' */]);

endoMinion.controller('mainCtrl', function($scope, endoService) {
	$scope.status = 'prefetching...';
	$scope.statusLine2 = '';
	endoService.prefetchData().then(function(result) {
		$scope.prefetchStatus = result.data;
		$scope.status = $scope.prefetchStatus.workoutsFetched + ' workouts fetched in ' + $scope.prefetchStatus.fetchTime + ' ms'
	});

});

endoMinion.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/EndoMinion/about.html',
		controller : 'mainCtrl'
	}).when('/about', {
		templateUrl : '/EndoMinion/about.html',
		controller : 'mainCtrl'
	}).when('/workouts', {
		templateUrl : '/EndoMinion/workouts.html',
		controller : 'workoutsCtrl'
	}).when('/statistics', {
		templateUrl : '/EndoMinion/statistics.html',
		controller : 'statisticsCtrl'
	}).when('/signin', {
		templateUrl : '/EndoMinion/signIn.html',
		controller : 'signInCtrl'
	}).when('/workoutDetails/:endomondoId', {
		templateUrl : '/EndoMinion/workoutDetails.html',
		controller : 'workoutDetailsCtrl'
	});
});
