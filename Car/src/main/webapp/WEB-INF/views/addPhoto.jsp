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
<title>Add Photo</title>
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
	.footer{
		margin-top: 10px;
		margin-bottom: 5px;
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
							   	 </ul>
							</li>
						</ul> 
					  </sec:authorize>
					</div>
				</div>
			</nav>
	<div class="container">
	   <div class="row">
	   		<div class="col-sm-12">
	   			<form:form class="form-horizontal" modelAttribute="photo" action="/addPhoto" method="post" enctype="multipart/form-data">
	  
	   			   <div class="form-group">
						<label for="region" class="control-label col-sm-2">Car: </label>
						<div class="col-sm-9">
					   		 <form:select path="car" items="${cars}" itemLabel="model" itemValue="id" class="form-control" />
						</div>
					</div>
	   			   <div class="form-group">
						<label for="file" class="control-label col-sm-2 ">File: </label>
						<div class="col-sm-9">
							<form:input type="file" path="file" id="file" class="form-control" />
						</div>
					</div>
	   				<div class="form-group">
	   					<div class="col-sm-10 col-sm-offset-2">
	   						<button type="submit" class="btn btn-success">Add</button>
	   					</div>
	   				</div>
	   			</form:form>
	   		</div>
	   </div>
		<div class="row">
			<div class="col-sm-12">
				<c:forEach items="${cars}" var="car">
				<div class="col-sm-4" style="float:left;">
				<table class="table table-bordered"> 
				  <tr>
				  	<th colspan="2" class="text-center">${car.model}</th>
				  </tr>
				  <tr>
					<th>Photo</th>
					<th class="text-center">Delete</th>
				 </tr>	
				<c:forEach items="${photos}" var="photo">
						<c:if test="${car.id == photo.car.id}">	
				 			 <tr>
								<th class="text-center"><img src="/images/${photo.photourl}?version=${photo.version}" width="190px" height="115px" alt="car image"></th>
								<td class="text-center"><a href="/addPhoto/delete/${photo.id}" class="btn btn-danger" style="margin-top: 40px;">Delete</a></td>
				  			 </tr>
				  		</c:if>
				 	</c:forEach>
				 	</table>
				 	</div>
				</c:forEach>		
		  </div>
		 </div> 
		 <div class="row">
			<div class="col-sm-12 footer">
				<hr>
				<h6 class="text-center">© 2017 created by Vovk Oleh</h6>
			</div>
		</div> 
		<button class="btn-top" title="Go to top">Вгору</button>
	</div>
<script src="/js/scrollTop.js"></script>
</body>
</html>