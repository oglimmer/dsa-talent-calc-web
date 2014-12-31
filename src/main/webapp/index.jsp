<%@page import="de.oglimmer.dsacalc.services.DsacalcVersion"%>
<%@page import="de.oglimmer.dsa.DSATalentTestCalcVersion"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html>
<html lang="en" ng-app="DSATCApp" class="no-js" xmlns="http://www.w3.org/1999/xhtml" xmlns:ng="http://angularjs.org">
<head>        
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>DSA-Talent-Calc</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="webjars/normalize.css/3.0.1/normalize.css" rel="stylesheet" />
	<link href="webjars/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/html5-boilerplate-main.css" rel="stylesheet" />
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/styles.css" />
</head>
<body ng-controller="DSATCControllerMain">

	<nav class="navbar navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">DSA Talent</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

	<div class="container">
	    <form novalidate class="simple-form">
		    Attribute-1: <input type="number" ng-model="v1" /><br />
		    Attribute-2: <input type="number" ng-model="v2" /><br />
		    Attribute-3: <input type="number" ng-model="v3" /><br />
		    <input type="submit" ng-click="calc()" value="Calc" />
	  	</form>
		<br/>
		<div class="row">
	  		<div class="col-xs-6">Available Talent Points</div>
	  		<div class="col-xs-6">P(taw)</div>
	  	</div>
		<div class="row" ng-repeat="item in data">
	  		<div class="col-xs-6">{{item.taw}}</div>
	  		<div class="col-xs-6">{{item.p}}%</div>
	  	</div>
	  	
	</div>
	  	  	
		<script src="webjars/angularjs/1.3.8/angular.min.js"></script>
		<script src="webjars/angularjs/1.3.8/angular-resource.min.js"></script>
		<script src="webjars/modernizr/2.8.3/modernizr.min.js"></script>
		
		<script src="js/app.js"/></script>
		<script src="js/services.js"/></script>
		<script src="js/controllers.js"/></script>
		<script src="js/filters.js"/></script>
		<script src="js/directives.js"/></script>

	<!--
		Lib: <%=DSATalentTestCalcVersion.INSTANCE.getVersion()%> / Web: <%=DsacalcVersion.INSTANCE.getVersion()%>
	 -->
</body>
</html>
