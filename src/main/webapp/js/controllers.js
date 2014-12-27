'use strict';

/* Controllers */

angular.module('DSATCApp.controllers', []).
controller('DSATCControllerMain', ['$scope', 'CalcService', function($scope, CalcService) {
      $scope.data = [];
      $scope.v1 = 10;
      $scope.v2 = 10;
      $scope.v3 = 10;

      $scope.calc = function() {
    	  console.log($scope.v1);
    	  CalcService.calc({values:[$scope.v1, $scope.v2, $scope.v3]}, function(result) {
    		  console.log(result.values);
    		  $scope.data = result.values;
    	  });
      };

      
    }]);