var endoMinion = angular.module('endoMinion', [ 'ngRoute', 'ui.grid']);

endoMinion.controller('mainCtrl', function($scope) {
	$scope.message = 'message from controler';

});

endoMinion.factory('endoService', function($http, $rootScope) {
	var service = this;
	return {
		getSimpleData : function() {
			return $http.get('/home/getSimpleData');
		},
		getWorkouts : function() {
			return $http.get('/home/getWorkouts');
		}
	}
});

endoMinion.controller('workoutsCtrl', function($scope, endoService) {
	
	/*$scope.gridOptions = { 
            columnDefs: [{ field: 'id', displayName: 'no', width: 90 },
                         { field: 'readableStartTime', displayName: 'Start time', width: 80 }]}*/
	
    $scope.gridOptions = {
    	      enableColumnResizing: true
    	    };
	
	$scope.status='Loading Workouts...';
	endoService.getSimpleData().then(function(result) {
		$scope.serverResponse = result.data;
	});
	
	endoService.getWorkouts().then(function(result) {
		$scope.workouts = result.data;
		$scope.status='Workouts';
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
