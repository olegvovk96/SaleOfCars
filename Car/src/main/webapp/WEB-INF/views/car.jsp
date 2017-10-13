<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/chosen.min.css">
<script src="/js/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/chosen.jquery.min.js"></script>
<script>
	$(function(){
		$('select').chosen({width:'100%'});
	})
</script>
<style>
	div>button{
		margin-top: 7px;
	}
	.footer{
		margin-top: 10px;
		margin-bottom: 5px;
	}
</style>
<title>Cars</title>
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
						<a href="/" class="navbar-brand"><span style="color:white;">AutoLife</span></a>
					</div>
					<div class="collapse navbar-collapse" id="bs-navbar-collapse-1">
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
							   	   	<li class="height_li"><a href="/addPhoto">Додати фото</a></li>		   	
							   	 </ul>
							</li>
						</ul> 
					  </sec:authorize>
					</div>
				</div>
			</nav>
	
	<div class="container">
	  <sec:authorize access="hasRole('ROLE_OWNER')">
		<div class="row">
			<div class="col-sm-12">
				<form:form class="form-horizontal" modelAttribute="car" action="/car" method="post" enctype="multipart/form-data">
					<sec:authentication var="principal" property="principal"/>
					<form:hidden path ="owner" value="${principal.username}"/>
					<div class="form-group">
						<label for="price" class="control-label col-sm-2">Price: </label>
						<div class="col-sm-10">
							<form:input type="text" path ="price" id="price" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="mileage" class="control-label col-sm-2">Mileage: </label>
						<div class="col-sm-10">
							<form:input type="text" path ="mileage" id="mileage" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="volume" class="control-label col-sm-2">Volume: </label>
						<div class="col-sm-10">
							<form:input type="text" path ="volume" id="volume" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="power" class="control-label col-sm-2">Power: </label>
						<div class="col-sm-10">
							<form:input type="text" path ="power" id="power" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="year" class="control-label col-sm-2">Year: </label>
						<div class="col-sm-10">
							<form:input type="text" path ="year" id="year" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="numberOfDoors" class="control-label col-sm-2">numberOfDoors: </label>
						<div class="col-sm-10">
							<form:input type="text" path ="numberOfDoors" id="numberOfDoors" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="numberOfSeats" class="control-label col-sm-2">numberOfSeats: </label>
						<div class="col-sm-10">
							<form:input type="text" path ="numberOfSeats" id="numberOfSeats" class="form-control" />
						</div>
					</div>
					 <div class="form-group">
						<label for="mark" class="control-label col-sm-2">Mark: </label>
						<div class="col-sm-10">
					   		 <form:select path="mark" items="${marks}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div> 
					<div class="form-group">
						<label for="model" class="control-label col-sm-2">Model: </label>
						<div class="col-sm-10">
							<form:select path="model" items="${models}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="currency" class="control-label col-sm-2">Currency: </label>
						<div class="col-sm-10">
							<form:select path="currency" items="${currencies}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="color" class="control-label col-sm-2">Color: </label>
						<div class="col-sm-10">
							<form:select path="color" items="${colors}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="region" class="control-label col-sm-2">Region: </label>
						<div class="col-sm-10">
							<form:select path="region" items="${regions}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="city" class="control-label col-sm-2">City: </label>
						<div class="col-sm-10">
							<form:select path="city" items="${cities}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="control-label col-sm-2">State: </label>
						<div class="col-sm-10">
							<form:select path="state" items="${states}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="gearbox" class="control-label col-sm-2">Gearbox: </label>
						<div class="col-sm-10">
							<form:select path="gearbox" items="${gearboxes}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div>
				    <div class="form-group">
						<label for="comfort" class="control-label col-sm-2">Comfort: </label>
						<div class="col-sm-10">
							<form:select path="comfort" items="${comforts}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="body" class="control-label col-sm-2">Body: </label>
						<div class="col-sm-10">
							<form:select path="body" items="${bodies}" itemLabel="name" itemValue="id" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">carDriveType: </label>
						<div class="col-sm-10">
							<form:select path="carDriveType" items="${carDriveTypes}" itemLabel="value" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Fuel: </label>
						<div class="col-sm-10">
							<form:select path="fuel" items="${fuels}" itemLabel="value" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="control-label col-sm-2">Description: </label>
						<div class="col-sm-10">
							<form:textarea type="text" path="description" id="description" rows="3" class="form-control" />
						</div>
					</div>
					<%-- <div class="form-group">
						<label for="comfort" class="control-label col-sm-2">Comfort: </label>
						<div class="col-sm-10">
							<form:select path="comfort" items="${comforts}" itemLabel="name" itemValue="id" class="form-control" />
							<form:select path="comfort" multiple="multiple">
								<form:option value="0" label="Select" />
            					<form:options items="${comforts}" itemValue="id" itemLabel="name" />
							</form:select>
						</div>
					</div> --%>
					<!-- <select class="selectpicker" multiple>
  						<option>Mustard</option>
 					    <option>Ketchup</option>
  						<option>Relish</option>
					</select> -->
					
					<div class="form-group">
						<label for="file" class="control-label col-sm-2">File: </label>
						<div class="col-sm-10">
							<form:input type="file" path="file" id="file" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10 col-sm-offset-2">
							<button class="btn btn-success" type="submit">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		 <%-- <div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				<table class="table table-bordered">
				<tr>
					<th>Модель</th>
					<th>Update</th>
				</tr>
				<c:forEach items="${cars}" var="car">
					<tr>
						<td>${car.model.name}</td>
						<td class="text-center"><a href="/car/update/${car.id}" class="btn btn-warning">Update</a></td>
					</tr>
				</c:forEach>
				</table>
			</div>
		</div>  --%>
		<div class="row">
			<div class="col-sm-12 footer">
				<hr>
				<h6 class="text-center">© 2017 created by Vovk Oleh</h6>
			</div>
		</div>
	  </sec:authorize>
	</div>
</body>
</html>