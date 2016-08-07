var endoMinion = angular.module('endoMinion', [ 'ngRoute', 'ui.grid' ]);

endoMinion.controller('mainCtrl', function($scope) {
	$scope.message = 'message from controler';

});

endoMinion.controller('statisticsCtrl', function($scope) {
	$scope.message = 'Statistics page.';
});

endoMinion.controller('workoutDetailsCtrl', function($scope,$location) {
	$scope.message = 'Workout Details page.';
	$scope.id=$location.search().id;
});


endoMinion.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/home/about.html',
		controller : 'mainCtrl'
	}).when('/about', {
		templateUrl : '/home/about.html',
		controller : 'mainCtrl'
	}).when('/workouts', {
		templateUrl : '/home/workouts.html',
		controller : 'workoutsCtrl'
	}).when('/statistics', {
		templateUrl : '/home/statistics.html',
		controller : 'statisticsCtrl'
	}).when('/workoutDetails', {
		templateUrl : '/home/workoutDetails.html',
		controller : 'workoutDetailsCtrl'
	});;
});
