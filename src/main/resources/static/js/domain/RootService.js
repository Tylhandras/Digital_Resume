angular
	.module('app')
	.service('RootService', ['$http', function($http) {
		var serv = this;
		
		var locUrl = 'location/';
		var userUrl = 'user/';
		
		this.id;
		
		// Administrator functionality
		this.createLocation = function(location) { return $http.post(locUrl + 'newLocation', location) };
		this.updateLocation = function(location) { return $http.put(locUrl, location) };
		this.deleteLocation = function(areaId) { return $http.delete(locUrl + areaId) };
		this.countLocations = function() { return $http.get(locUrl + 'count') };
		this.index = function() { return $http.get(locUrl) };
		this.frame = function(tFrame, input) {
			if(input === true){
				if(tFrame === 'week') {
					return $http.get(locUrl + 'week/' + input)
				}
				else if(tFrame === 'month') {
					return $http.get(locUrl + 'month/' + input)
				}
				else if(tFrame === 'year') {
					return $http.get(locUrl + 'year/' + input)
				}
				else {
					return $http.get(locUrl + 'all/' + input)
				}
			} else {
				if(tFrame === 'week') {
					return $http.get(locUrl + 'week/' + input)
				}
				else if(tFrame === 'month') {
					return $http.get(locUrl + 'month/' + input)
				}
				else if(tFrame === 'year') {
					return $http.get(locUrl + 'year/' + input)
				}
				else {
					return $http.get(locUrl + 'all/' + input)
				}
			}
		};
		
		// Site visitor functionality
		this.incLocation = function(location) { return $http.post(locUrl + 'increment', location) };
		this.setPlaceId = function(placeId) { serv.id = placeId };
		this.getPlaceId = function() { return serv.id };
		
		// Register functionality
		this.newUser = function(user) { return $http.post(userUrl + 'newUser', user) };
		
		// Login functionality
		this.getLoginDetails = function(login) { return $http.post(userUrl + 'login', login) };
	}]);