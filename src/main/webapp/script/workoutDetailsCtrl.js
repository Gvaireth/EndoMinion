endoMinion.controller('workoutDetailsCtrl', function($scope, $routeParams,endoService,NgMap) {
	$scope.status = 'Loading Workout Details...';
	endoService.getAccountInfo().then(function(result) {
		$scope.account = result.data;
	});
	  NgMap.getMap().then(function(map) {
		    console.log(map.getCenter());
		    console.log('markers', map.markers);
		    console.log('shapes', map.shapes);
		  });

	endoService.getDetailedWorkout($routeParams.endomondoId).then(
			function(result) {
				$scope.details = result.data;
				$scope.status = '';
				$scope.pointsNumber = result.data.points.length;
				$scope.workout = result.data.basicWorkoutData
				if ($scope.pointsNumber != 0) {
					$scope.workout.trackingResolution = $scope.workout.distance
							* 1000 / $scope.pointsNumber;
					$scope.workout.trackingResolution=$scope.workout.trackingResolution.toFixed(2);
					$scope.workout.trackingResolution+=' m';
				} else {
					$scope.workout.trackingResolution = 'N/A';
				}
			})
});