angular
  .module('app')
  .controller('AdminController', ['RootService', '$location', '$route', 'loginPage', 'allLocations', 'locationCount',
    function(RootService, $location, $route, loginPage, allLocations, locationCount) {
	  	var ctrl = this;
	  	
	  	this.times = ['Weekly', 'Monthly', 'Yearly', 'All Time'];
	  	
		this.address = loginPage;
		this.places = allLocations.data;
		this.tab = 1;
		this.outputInfo;

	    this.setTab = function(tabValue){
	      this.tab = tabValue;
	    };
	    
	    this.isSet = function(tabName){
	      return this.tab === tabName;
	    };
	    
	    this.goToUser = function() {
	    	$location.path('/user')
	    };
	    
	    this.login = function(placeId) {
	    	RootService.setPlaceId(placeId);
	    	$location.path('/login/' + placeId);
	    };
	    
	    this.createEntry = function() {  // link number will need a rework to account for deletions
	    	var num = locationCount.data; 
	    	var location = {
	    			"title" : ctrl.title,
	    			"areaId" :  num + 1,
	    			"link" : loginPage + '/' + (num + 1)
	    	};
	    	RootService.createLocation(location)
	    	.then((result) => {
	    		$route.reload();
	    	});
	    };
	    
	    this.updateEntry = function(placeId) {
	    	var location = {
	    			"areaId" : placeId,
	    			"description" : ctrl.description
	    	};
	    	RootService.updateLocation(location)
	    	.then((result) => {
	    		$route.reload();
	    	})
	    };
	    
	    this.deleteEntry = function(placeId) {
	    	RootService.deleteLocation(placeId)
	    	.then((result) => {
	    		$route.reload();
	    	})
	    };
	    
	    this.display = function(tFrame, input) {
	    	RootService.frame(tFrame, input)
	    	.then(function(result) {
	    		ctrl.outputInfo = result.data;
	    	});
	    };
	}]);