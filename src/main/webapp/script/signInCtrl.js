endoMinion.controller('signInCtrl', function($scope, endoService) {
	$scope.status = 'Loading Account Info...';
	endoService.getAccountInfo().then(function(result) {
		$scope.account = result.data;
		$scope.status = '';
	});
});