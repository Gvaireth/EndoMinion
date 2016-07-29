var endoMinion = angular.module('endoMinion', [ 'ngRoute' ]);

endoMinion.controller('mainCtrl', function($scope) {
	$scope.message = 'message from controler';

});

endoMinion.factory('endoService', function($http, $rootScope) {
	var service = this;
	return {
		getWorkouts : function() {
			return "workouts list";
		},
		getWorkouts2 : function() {
			return $http.get('/home/getWorkouts').then(function(result) {
				// this works but its ugly
				 $rootScope.serverResponse=result.data;
				window.alert('server said: ' + result.data.first);
			});
		}
	}
});

endoMinion.controller('workoutsCtrl', function($scope, endoService) {
	$scope.message = 'Workouts page.';
	$scope.workouts = endoService.getWorkouts();
	endoService.getWorkouts2();
	/*.then(function(result) {
		$scope.serverResponse = result;
	});*/
});

endoMinion.controller('statisticsCtrl', function($scope) {
	$scope.message = 'Statistics page.';
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
	});
});
