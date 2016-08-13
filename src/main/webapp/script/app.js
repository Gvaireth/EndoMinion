var endoMinion = angular.module('endoMinion', [ 'ngRoute', 'ui.grid' ]);

endoMinion.controller('mainCtrl', function($scope) {
	$scope.message = 'message from controler';

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
	}).when('/workoutDetails', {
		templateUrl : '/EndoMinion/workoutDetails.html',
		controller : 'workoutDetailsCtrl'
	});
});
