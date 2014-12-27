'use strict';

/* Services */

angular.module('DSATCApp.services', []).
factory('CalcService', ['$resource', function($resource) {
    return $resource('rest/calc', {}, {
        'calc': {
            method: 'POST'
        }
    });
}]);
