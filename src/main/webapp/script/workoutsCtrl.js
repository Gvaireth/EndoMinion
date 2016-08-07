endoMinion.controller('workoutsCtrl', function($scope, endoService) {

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
	$scope.clicktest = function() {
		window.alert('click!')
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
	endoService.getSimpleData().then(function(result) {
		$scope.serverResponse = result.data;
	});

	endoService.getWorkouts().then(function(result) {
		$scope.workouts = result.data;
		$scope.status = 'Workouts';
	});
});