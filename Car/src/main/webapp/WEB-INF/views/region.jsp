<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<title>region</title>
<style>
	div>button{
		margin-top: 7px;
	}
	
	.form-horizontal .control-label{
		padding-right: 35px;
	}
	.decorationCancel{
		margin-top: 7px;
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
						<a href="/" class="navbar-brand"><span style="color:white;">AutoLife</span></a>
					</div>
					<div class="collapse navbar-collapse" id="bs-navbar-collapse-1">					
						 <ul class="nav navbar-nav">
							<li><a href="/admin/mark">Марка</a></li>
							<li><a href="/admin/model">Модель</a></li>
							<li><a href="/admin/color">Колір</a></li>	
							<li><a href="/admin/comfort">Комфорт</a></li>			
							<li><a href="/admin/gearbox">Коробка передач</a></li>
							<li><a href="/admin/body">Кузов</a></li>	
							<li><a href="/admin/state">Стан</a></li>	
							<li><a href="/admin/currency">Валюта</a></li>
							<li class="active"><a href="/admin/region">Область<span class="sr-only"></span></a></li>							
							<li><a href="/admin/city">Місто</a></li>
						</ul> 					
						<form:form action="/logout" class="form-inline navbar-form navbar-right">
							<div class="from-group">
							  <button type="submit" class="btn btn-default btn-xs">
							  <span class="glyphicon glyphicon-log-out"></span> Logout</button>	
							</div>					   	   		
					    </form:form>
					</div>
				</div>
			</nav>
			
	<div class="container">
	   <div class="row">
	   		<div class="col-sm-12">
	   			<form:form class="form-horizontal" modelAttribute="region" action="/admin/region" method="post">
	   			   <div class="form-group">
	   			   		<div class="col-sm-10 col-sm-offset-2" style="color:red;"><form:errors  path="name"/></div>
	   					<label for="name" class="control-label col-sm-2">Name:</label>
	   					<div class="col-sm-9">
	   						<form:input type="text" path="name" id="name" class="form-control" />
	   					</div>
	   				</div>
	   				<div class="form-group">
	   					<div class="col-sm-10 col-sm-offset-2">
	   						<button type="submit" class="btn btn-success">Add</button>
	   						<c:if test="${region.id != null}">
	   							<a href="/admin/region/cancel/${region.id}" class="btn btn-danger decorationCancel">Cancel</a>
	   						</c:if>
	   					</div>
	   				</div>
	   			</form:form>
	   		</div>
	   </div>
		<div class="row">
		  <div class="col-sm-10 col-sm-offset-1">
			<table class="table table-bordered">
				<tr>
					<th>Name</th>
					<th class="text-center">Update</th>
					<th class="text-center">Delete</th>
				</tr>
				<c:forEach items="${regions}" var="region">
				  <tr>
					<td>${region.name}</td>
					<td class="text-center"><a href="/admin/region/update/${region.id}" class="btn btn-warning">Update</a></td>
					<td class="text-center"><a href="/admin/region/delete/${region.id}" class="btn btn-danger">Delete</a></td>
				  </tr>
				</c:forEach>
			</table>
		   </div>
		 </div>  
	</div>
</body>
</html>