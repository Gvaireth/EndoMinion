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
	
	$scope.gridOptions = { data : 'workouts',
			headerRowHeight: 130,
            columnDefs: [{ field: 'id', displayName: 'no.', width: '50' },
                         { field: 'readableStartTime', displayName: 'Start time', width: '150' },
                         { field: 'readableDuration', displayName: 'Duration', width: '100' },
                         { field: 'durationRank', displayName: 'Duration#', width: '100' },
                         { field: 'distance', displayName: 'Distance', width: '100' },
                         { field: 'distanceRank', displayName: 'Distance#', width: '100' },
                         { field: 'calories', displayName: 'Calories', width: '100' },
                         { field: 'speedAvg', displayName: 'Avg speed', width: '100' },
                         { field: 'speedAvgRank', displayName: 'Avg speed#', width: '100' },
                         { field: 'sport', displayName: 'Activity', width: '120' },
            ]}
	

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
