angular
  .module('app')
  .controller('RegisterController', ['RootService', '$location', 'regAreaId', function(RootService, $location, regAreaId) {
	  var ctrl = this;
	  
	  this.init = function() {
		  var location = {
				  "areaId": RootService.getPlaceId()
		  };
		  RootService.incLocation(location);
	  };
	  
	  this.regUser = function() {
		  var locId;
		  if (regAreaId !== null)
			  locId = regAreaId;
		  else
			  locId = null;
		  
		  var user = {
				  "username" : ctrl.username,
				  "password" : ctrl.password,
				  "locationId" : { "areaId" : locId },
				  "role": 'user'
		  };
		  RootService.newUser(user)
		  .then(function(result) {
			  valid = result.data;
			  if (valid !== null)
				  $location.path('/login/regAreaId');
			  else
				  alert('Username already exists');
		  });
	  };
  }]);