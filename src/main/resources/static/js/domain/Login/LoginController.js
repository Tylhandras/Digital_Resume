angular
  .module('app')
  .controller('LoginController', ['RootService', '$location', 'logAreaId', function(RootService, $location, logAreaId) {
	var ctrl = this;
	
	this.init = function() {
		var location = {
				"areaId": RootService.getPlaceId()
		}
		RootService.incLocation(location);
	};
	
	this.login = function() {
	  var login = {
	  "username" : ctrl.username,
	  "password" : ctrl.password,
	  "areaId": logAreaId
	  }
	  RootService.getLoginDetails(login)
	  .then(function(result) {
		ctrl.user = result.data;
		if (ctrl.user != null) {
			if(ctrl.user.role === 'admin')
				$location.path('admin/true');
			else if (ctrl.user.role === 'user')
				$location.path('user');
		}
	  });
	};
	
	this.goReg = function() {
		$location.path('/register/' + logAreaId);
	};
}]);