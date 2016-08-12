endoMinion.controller('workoutDetailsCtrl', function($scope,$location,$rootScope, endoService) {
	$scope.status = 'Loading Workout Details...';
	$scope.id=$location.search().id;
	
	
	endoService.getDetailedWorkout($rootScope.currentWorkout.endomondoId).then(function(result) {
		$scope.details = result.data;
		$scope.status = '';
		$scope.pointsNumber=result.data.points.length;
		$scope.workout=$rootScope.currentWorkout;
	})
});