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