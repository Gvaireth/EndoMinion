endoMinion.controller('workoutsCtrl', function($scope, $rootScope, endoService) {

	$scope.order='distance';
	$scope.orderById = function() {
		$scope.order='id'
	}
	$scope.orderByDurationRank = function() {
		$scope.order='durationRank'
	}
	
	$scope.visibleTable = true;
	$scope.visibleGrid = false;
	$scope.showGrid = function() {
		$scope.visibleTable = false;
		$scope.visibleGrid = true;
		console.log(" table "+$scope.visibleTable+" grid "+$scope.visibleGrid)
	}
	$scope.showTable = function() {
		$scope.visibleTable = true;
		$scope.visibleGrid = false;
	}
	
	$scope.setCurrentWorkout = function(workout) {
		$rootScope.currentWorkout=workout;
	}
	
	$scope.fetchWorkouts = function() {
		$scope.status = 'Updating Workouts...';
		$scope.workouts=null; 
		endoService.fetchWorkouts().then(function(result) {
			$scope.workouts = result.data;
			$scope.status = '';
		});
	}

	$scope.gridOptions = {
		data : 'workouts',
		headerRowHeight : 130,
		columnDefs : [ {
			field : 'id',
			displayName : 'no.',
			width : '50'
		}, {
			field : 'readableStartTime',
			displayName : 'Start time',
			width : '150'
		}, {
			field : 'readableDuration',
			displayName : 'Duration',
			width : '100'
		}, {
			field : 'durationRank',
			displayName : 'Duration#',
			width : '100'
		}, {
			field : 'distance',
			displayName : 'Distance',
			width : '100'
		}, {
			field : 'distanceRank',
			displayName : 'Distance#',
			width : '100'
		}, {
			field : 'calories',
			displayName : 'Calories',
			width : '100'
		}, {
			field : 'speedAvg',
			displayName : 'Avg speed',
			width : '100'
		}, {
			field : 'speedAvgRank',
			displayName : 'Avg speed#',
			width : '100'
		}, {
			field : 'sport',
			displayName : 'Activity',
			width : '120'
		}, ]
	}

	$scope.status = 'Loading Workouts...';

	endoService.getWorkouts().then(function(result) {
		$scope.workouts = result.data;
		$scope.status = '';
	});
	endoService.getSports().then(function(result) {
		$scope.sports = result.data;
		$scope.selectedSport="All";
	});
});