var endoMinion = angular.module('endoMinion', [ 'ngRoute' ]);

endoMinion.controller('mainCtrl', function($scope) {
	$scope.message = 'message from controler';

});

endoMinion.factory('endoService', function($http, $rootScope) {
	var service = this;
	return {
		getSimpleData : function() {
			return $http.get('/home/getSimpleData');
		}
	}
});

endoMinion.controller('workoutsCtrl', function($scope, endoService) {
	endoService.getSimpleData().then(function(result) {
		$scope.serverResponse = result.data;
	});
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
