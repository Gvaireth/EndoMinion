endoMinion.factory('endoService', function($http, $rootScope) {
	var service = this;
	return {
		getSimpleData : function() {
			return $http.get('/EndoMinion/getSimpleData');
		},
		getWorkouts : function() {
			return $http.get('/EndoMinion/getWorkouts');
		},
		fetchWorkouts : function() {
			return $http.get('/EndoMinion/fetchWorkouts');
		},
		getStatistics : function() {
			return $http.get('/EndoMinion/getStatistics');
		},
		getAccountInfo : function() {
			return $http.get('/EndoMinion/getAccountInfo');
		},
		getDetailedWorkout : function(endomondoId) {
			return $http.get('/EndoMinion/getDetailedWorkout?endomondoId='+endomondoId);
		}
	}
});