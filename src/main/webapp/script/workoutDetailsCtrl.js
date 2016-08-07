endoMinion.controller('workoutDetailsCtrl', function($scope,$location,$rootScope, endoService) {
	$scope.message = 'Workout Details page.';
	$scope.status = 'Loading Workout Details...';
	$scope.id=$location.search().id;
	
	endoService.getDetailedWorkout($rootScope.currentWorkout.endomondoId).then(function(result) {
		$scope.detailedWorkout = result.data;
		$scope.status = 'Workout Details';
	})
});