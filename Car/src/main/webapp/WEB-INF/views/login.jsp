<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script src="/js/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<title>login</title>
<style>
	ul>li.decoration_li{
		font-weight: 700;
    	color: #C7C5C2;
   		line-height: 18px;
   	    cursor: pointer;
	}
	ul>li.decoration_li{
	    font-weight: 700;
    	color: #C7C5C2;
   		line-height: 18px;
   	    cursor: pointer;
    }
	div>h2{
	    font-weight: bold;
		font-size: 40px;
		font-family: monospace;
		margin-top: 15px;
		margin-bottom: 40px;
	}
	div.vidstyp{
		margin-top: -21px;
	}
	div.form_regestration_decoration{
		background-color: #f3f3f3;
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
						<!-- #C7C5C2 -->
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown decoration_li">
							   <a class="dropdown-toggle" data-toggle="dropdown">Вхід / реєстрація<b class="caret"></b></a>
							     <ul class="dropdown-menu">
							   	   <li class="height_li"><a href="/login">Вхід</a></li>
							   	   <li><a href="/registration">Реєстрація</a></li>
							   	  </ul>
							</li>
						</ul>
					</div>
				</div>
			 </nav>
			 
	
	
 	<div class="container-fluid">
		 	 	<div class="row form_regestration_decoration vidstyp">
					<div class="col-sm-12 text-center">
						<h2>Вхід на сайт</h2>
					</div>
		 	 	</div>
			 	 <div class="row form_regestration_decoration">
			 	 	 <div class="col-sm-10 col-sm-offset-1">
 			 	 	 		<form:form action="login" class="form-horizontal">
 			 	 	 			<c:if test="${param.fail}">
									<div class="col-sm-5 col-sm-offset-4" style="color:red;">Невірний логін або пароль</div>
								</c:if>
			 	 	 			<div class="form-group">
			 	 	 				<label for="email" class="control-label col-sm-4">Email</label>
			 	 	 				<div class="col-sm-4">
			 	 	 					<input class="form-control" name="email" id="email" type="text" placeholder="Email">
			 	 	 				</div>
			 	 	 			</div>
			 	 	 			<div class="form-group">
			 	 	 				<label for="password" class="control-label col-sm-4">Пароль</label>
			 	 	 				<div class="col-sm-4">
			 	 	 					<input class="form-control" name="password" id="password" type="password" placeholder="Пароль">
			 	 	 				</div>
			 	 	 			</div>
			 	 	 			<div class="form-group">
			 	 	 				<div class="col-sm-offset-4 col-sm-8">
			 	 	 					<div class="checkbox">
			 	 	 						<label><input type="checkbox" name="rememberMe" >Запам'ятати мене</label>
			 	 	 					</div>
			 	 	 				</div>
			 	 	 			</div>
			 	 	 			<div class="form-group">
			 	 	 				<div class="col-sm-12 text-center">
			 	 	 					<button type="submit" class="btn btn-success">Вхід</button>
			 	 	 				</div>
			 	 	 			</div>
			 	 	 		</form:form>
			 	 	 </div>
			 	 </div>
	   </div>

	<%-- <form:form action="login">
		<input name="email">
		<input name="password">
		<button type="submit">Увійти</button>
	</form:form> --%>
</body>
</html>