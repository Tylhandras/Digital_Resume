angular
	.module('app')
	.config(['$routeProvider', 'baseRoute', 'homePage',
	         function config($routeProvider, baseRoute, homePage) {
				$routeProvider
				.when('/home', {
					templateUrl: homePage,
					controller: 'HomeController',
					controllerAs: 'homeController'
				})
				.when('/login', {
					templateUrl: baseRoute + 'Login/loginTemplate.html',
					controller: 'LoginController',
		            controllerAs: 'loginController',
		            resolve: {
		            	logAreaId: function($route) {
		            		return $route.current.params.areaId;
		            	}
		            }
				})
				.when('/login/:areaId', {
					templateUrl: baseRoute + 'Login/loginTemplate.html',
					controller: 'LoginController',
		            controllerAs: 'loginController',
		            resolve: {
		            	logAreaId: function($route) {
		            		return $route.current.params.areaId;
		            	}
		            }
				})
				.when('/admin/:loggedIn', {
			        templateUrl: baseRoute + 'Admin/adminTemplate.html',
			        controller: 'AdminController',
			        controllerAs: 'adminController',
			        resolve: {
			        	locationCount: function(RootService) {
			        		return RootService.countLocations();
			        	},
						allLocations: function(RootService) {
							return RootService.index();
						}
			        },
			        redirectTo: function(routeParams, path, search) {
			        	if (routeParams == null) {
			        		return baseRoute + 'Login/loginTemplate.html';
			        	}
			        }
			    })
			    .when('/register', {
			    	templateUrl: baseRoute + 'Register/registerTemplate.html',
			    	controller: 'RegisterController',
			    	controllerAs: 'registerController',
			    	resolve: {
		            	regAreaId: function($route) {
		            		return $route.current.params.areaId;
		            	}
		            }
			    })
			    .when('/register/:areaId', {
			    	templateUrl: baseRoute + 'Register/registerTemplate.html',
			    	controller: 'RegisterController',
			    	controllerAs: 'registerController',
			    	resolve: {
		            	regAreaId: function($route) {
		            		return $route.current.params.areaId;
		            	}
		            }
			    })
			    .when('/user', {
			    	templateUrl: baseRoute + 'User/userTemplate.html',
			    	controller: 'UserController',
			    	controllerAs: 'userController'
			    })
				.otherwise('/home');
    		}
  ]);