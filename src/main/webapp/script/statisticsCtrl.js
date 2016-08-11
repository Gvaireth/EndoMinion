endoMinion.controller('statisticsCtrl', function($scope, endoService) {
	$scope.message = 'Statistics page.';
	$scope.status = 'Loading Statistics...';
	endoService.getStatistics().then(function(result) {
		$scope.statistics = result.data;
		$scope.status = '';
	});
});