endoMinion.factory('endoService', function($http, $rootScope) {
	var service = this;
	return {
		getSimpleData : function() {
			return $http.get('/EndoMinion/getSimpleData');
		},
		getWorkouts : function() {
			return $http.get('/EndoMinion/getWorkouts');
		},
		getDetailedWorkout : function(endomondoId) {
			return $http.get('/EndoMinion/getDetailedWorkout?endomondoId='+endomondoId);
		}
	}
});