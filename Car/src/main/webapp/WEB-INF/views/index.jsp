<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec" %>
 <%@ taglib uri="/WEB-INF/tags/implicit.tld" prefix="custom"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script src="/js/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<title>Car</title>

<style>
	ul>li.decoration_li{
		font-weight: 700;
    	color: #C7C5C2;
   		line-height: 18px;
   	    cursor: pointer;
	}
	div>button{
		margin-top: 7px;
	}
	.row {
		margin-right: 0;
		margin-left: 0;
	}

	.block_cars{
		border: 1px solid #e3e3e3;
		box-sizing: border-box;
		padding: 5px;
		margin-bottom: 10px;
	}

	.block_cars:hover {
		border-color: #256799;
	}
	.decor_mark,
	.decor_model{
		color: #256799;
		font-weight: bold;
		font-family: sans-serif;
		font-size: 15px;
	}
	.decor_mark_model_year{
		background-color: #eff2f9;
	}
	.decor_mark_model_year>a{
		cursor: pointer;
	}
	.decor_year{
		color:#7a7a7a;
		font-weight: bold;
	}
	.col-sm-12.decor_mark_model_year,
	.col-sm-7.decor_sm_7{
		padding-left: 7px;
		padding-right: 5px;
	}
	.decor_price{
		color: #5d9000;
		font-weight: bold;
		font-size: 17px;
	}
	.decor_currency{
		font-weight: 500;
		font-size: 15px;
	}
	.col-sm-12.dec_price_currency,
	.col-sm-12.dec_fuel_gearbox_mileage,
	.col-sm-12.dec_body_carDriveType{
		padding-left: 8px;
		margin-top: 10px;
	}
	.decor_fuel,
	.decor_mileage,
	.decor_body{
		margin-right: 5px;
	}
	.btn-top{
		display: none;
		position: fixed;
		bottom: 20px;
		right: 40px;
		z-index: 95;
		border: none;
		outline: none;
		background-color: #2ecc71;
		color: #fff;
		cursor: pointer;
		padding: 15px;
		border-radius: 10px;
	}
	.btn-top:hover{
		background-color: #27ae60;
	}
	.footer{
		margin-top: 10px;
		margin-bottom: 5px;
	}
</style>
</head>
<body>

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					 <div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#bs-navbar-collapse-1"
							aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> 
							<span class="icon-bar"></span> <span class="icon-bar"></span> 
							<span class="icon-bar"></span>
						</button>
						<a href="" class="navbar-brand"><span style="color:white;">AutoLife</span></a>
					</div>
					<div class="collapse navbar-collapse" id="bs-navbar-collapse-1">
						<sec:authorize access="!isAuthenticated()">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown decoration_li">
							   <a class="dropdown-toggle" data-toggle="dropdown">Вхід / реєстрація<b class="caret"></b></a>
							     <ul class="dropdown-menu">
							   	   <li class="height_li"><a href="/login">Вхід</a></li>
							   	   <li><a href="/registration">Реєстрація</a></li>
							   	  </ul>
							</li>
						</ul>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_USER')">
						<form:form action="/logout" class="form-inline navbar-form navbar-right">
							<div class="from-group">
							  <button type="submit" class="btn btn-default btn-xs">
							  <span class="glyphicon glyphicon-log-out"></span> Logout</button>	
							</div>					   	   		
					    </form:form>
						<!--  <ul class="nav navbar-nav navbar-right">
							<li class="dropdown decoration_li">
							   <a class="dropdown-toggle" data-toggle="dropdown">Особистий кабінет<b class="caret"></b></a>
							     <ul class="dropdown-menu">
							   	   	<li class="height_li"><a href="/">Особисті дані</a></li>		   	
							   	 </ul>
							</li>
						</ul>  -->
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_OWNER')">
						<form:form action="/logout" class="form-inline navbar-form navbar-right">
							<div class="from-group">
							  <button type="submit" class="btn btn-default btn-xs">
							  <span class="glyphicon glyphicon-log-out"></span> Logout</button>	
							</div>					   	   		
					    </form:form>
						 <ul class="nav navbar-nav navbar-right">
							<li class="dropdown decoration_li">
							   <a class="dropdown-toggle" data-toggle="dropdown">Особистий кабінет<b class="caret"></b></a>
							     <ul class="dropdown-menu">
							   	   	<li class="height_li"><a href="/car">Додати авто</a></li>
							   	   	<li class="height_li"><a href="/addPhoto">Додати фото</a></li>		   	
							   	 </ul>
							</li>
						</ul> 
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<form:form action="/logout" class="form-inline navbar-form navbar-right">
							<div class="from-group">
							  <button type="submit" class="btn btn-default btn-xs">
							 	  <span class="glyphicon glyphicon-log-out"></span> Logout
							  </button>						  
							</div>					   	   		
					    </form:form>
						 <ul class="nav navbar-nav navbar-right">
							<li><a href="/admin/mark">Адміністратор</a></li>
						</ul> 
						</sec:authorize>
					</div>
				</div>
			</nav>
			
		<div class="container-fluid">
		 	 	<div class="row">
					 		<div class="col-sm-3">
					 			
					 		</div>
					 		<div class="col-sm-7">
					 		  <c:forEach items="${cars.content}" var="car">				 		  
					 			<div class="row block_cars">
					 			  <div class="col-sm-4">
					 				<a href="/car/${car.id}"><img src="/images/${car.photourl}?version=${car.version}" width="190px" height="115px" alt="car image"></a>
					 			  </div>
					 			  <div class="col-sm-8 decor_sm_7">
					 			  	<div class="row">
					 			  		<div class="col-sm-12 decor_mark_model_year">
					 			  		  <a href="/car/${car.id}">
					 			  			<span class="decor_mark">${car.mark}</span>
					 			  			<span class="decor_model">${car.model}</span>
					 			  			<span class="decor_year">${car.year}</span>
					 			  		  </a>
					 			  		</div>				 			  		
					 			  	</div>
					 			  	<div class="row">
					 			  		<div class="col-sm-12 dec_price_currency">
					 			  			<span class="decor_price">${car.price}</span> 
					 			  			<span class="decor_currency">${car.currency}</span>
					 			  		</div>
					 			  	</div>
					 			  	<div class="row">
					 			  		<div class="col-sm-12 dec_fuel_gearbox_mileage">
					 			  			<img src="/img/fuel-service.png"> 
					 			  			<span class="decor_fuel">${carr.fuel} ${car.volume} л.</span>
					 			  			<img src="/img/speedometer.png">
					 			  			<span class="decor_mileage">${car.mileage} км</span>
					 			  			<img src="/img/gearbox.png">
					 			  			<span>${car.gearbox}</span>
					 			  		</div>
					 			  	</div>
					 			  	<div class="row">
					 			  		<div class="col-sm-12 dec_body_carDriveType">
					 			  			<span class="decor_body">${car.body}</span>
					 			  			<span class="decor_carDriveType">${carr.carDriveType}</span>
					 			  		</div>
					 			  	</div>
					 			  </div>
					 			</div>
					 		  </c:forEach>
					 		</div>
					 		<div class="col-sm-2"></div>
					 		<button class="btn-top" title="Go to top">Вгору</button>
				</div>
				<div class="row">
					<div class="col-md-12 col-xs-12 text-center">
						<custom:pageable page="${cars}" cell="<li></li>" container="<ul class='pagination'></ul>" />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1 footer">
						<hr>
						<h6 class="text-center">© 2017 created by Vovk Oleh</h6>
					</div>
				</div>
			</div>	
			
<script src="/js/scrollTop.js"></script>
</body>
</html>