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
<script src="/js/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<!-- Add mousewheel plugin (this is optional) -->
	<script type="text/javascript" src="/lib/jquery.mousewheel-3.0.6.pack.js"></script>

	<!-- Add fancyBox main JS and CSS files -->
	<script type="text/javascript" src="/source/jquery.fancybox.js"></script>
	<link rel="stylesheet" type="text/css" href="/source/jquery.fancybox.css" media="screen" />

	<!-- Add Button helper (this is optional) -->
	<link rel="stylesheet" type="text/css" href="/source/helpers/jquery.fancybox-buttons.css?v=2.0.3" />
	<script type="text/javascript" src="/source/helpers/jquery.fancybox-buttons.js?v=2.0.3"></script>

	<!-- Add Thumbnail helper (this is optional) -->
	<link rel="stylesheet" type="text/css" href="/source/helpers/jquery.fancybox-thumbs.css?v=2.0.3" />
	<script type="text/javascript" src="/source/helpers/jquery.fancybox-thumbs.js?v=2.0.3"></script>

<title>Car description</title>
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
	.decor_col_sm_10{
		padding: 10px;
	}
	/* .block_cars{
		border: 1px solid green;
		box-sizing: border-box;
		padding: 15px;
	} */
	.decor_mark,
	.decor_model{
		color: Black;
		font-weight: bold;
		font-family: sans-serif;
		font-size: 20px;
	}
	.decor_year{
		color:#7a7a7a;
		font-weight: bold;
		font-size: 20px;
	}
	.decor_region_city{
		color: #8d9ba6;
		font-size: 16px;
		margin-top: 3px;
	}
	.vidstyp_region_city{
		margin-left: 7px;
		margin-right: 7px;
	}
	.decor_price{
		color: #5d9000;
		font-weight: bold;
		font-size: 18px;
		padding-left: 10px;
	}
	.decor_currency{
		font-weight: 500;
		font-size: 16px;
	}
	.character{
		font-weight: bold;
		font-family: serif;
		font-size: 17px;
	}
	.decor_character{
		margin-top: 10px;
	}
	hr{
		margin: 0px;
	}
	.decor_body,
	.decor_volume,
	.decor_power,
	.decor_fuel,
	.decor_doors,
	.decor_seats,
	.decor_gearbox,
	.decor_color,
	.decor_mileage,
	.decor_carDriveType,
	.decor_state{
		font-weight: bold;
	}
	.decor_body_doors_seats_engine,
	.decor_gearbox_color_mileage,
	.decor_carDriveType_state{
		margin-top: 5px;
		padding: 0px;
	}
	.decor_comfort{
		font-weight: bold;
		margin-top: 5px;
	}
	.decor_description{
		margin-top: 5px;
	}
	.decor_character>a{
		text-decoration: none;
		color: black;
		font-weight: 700;
	}
	img.decor_img:hover{
		border: 1px solid #256799;
	}
	.footer{
		margin-top: 10px;
		margin-bottom: 5px;
	}
</style>
<script>
            function showHide(element_id) {
                if (document.getElementById(element_id)) { 
                    var obj = document.getElementById(element_id); 
                    if (obj.style.display != "inline") { 
                        obj.style.display = "inline";
                    }
                    else obj.style.display = "none"; 
                }
                else alert("Елемент з id: " + element_id + " не знайдено!"); 
            }   
</script>
<script type="text/javascript">
$(document).ready(function() {
	$(".fancybox-thumb").fancybox({
		prevEffect	: 'none',
		nextEffect	: 'none',
		helpers	: {
			title	: {
				type: 'outside'
			},
			thumbs	: {
				width	: 50,
				height	: 50
			}
		}
	});
});
</script>
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
		 	 	<div class="col-sm-10 col-sm-offset-1 decor_col_sm_10">
		 	 	    <c:forEach items="${cars}" var="car">
		 	 	    	<div class="row">	
		 	 	    		<div class="col-sm-12">
		 	 	    			<span class="decor_mark">${car.mark}</span>
								<span class="decor_model">${car.model}</span>
								<span class="decor_year">${car.year}</span>
		 	 	    		</div>
						</div>
						<div class="row">
							<div class="col-sm-12 dec_price_currency">
								<span class="decor_price">${car.price}</span>
								<span class="decor_currency">${car.currency}</span>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 decor_region_city">
								<span>${car.region} область <span class="vidstyp_region_city">/</span> </span>
								<span>${car.city}</span>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">						
								<div class="text-center"><a class="fancybox-thumb" rel="fancybox-thumb" href="/images/${car.photourl}"  title="${car.mark} ${car.model} ${car.year}">
								<img src="/images/${car.photourl}" alt="" width="350px" height="170px" /> </a></div>
							<div class="text-center">
							<c:forEach items="${car.photos}" var="photo">
								<a class="fancybox-thumb" rel="fancybox-thumb" href="/images/${photo}">
								<img src="/images/${photo}" class="decor_img" alt="" width="110px" height="75px" /> </a>
								<%-- <span><img alt="auto" src="/images/${photo}" width="190px" height="115px"></span> --%>
							</c:forEach></div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 decor_character">
								<span class="character">Характеристика</span>
								<hr>						
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4">
								<div class="row">
									<div class="col-sm-12 decor_body_doors_seats_engine">
										Тип кузова: <span class="decor_body">${car.body}</span>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 decor_body_doors_seats_engine">
										Кількість дверей/місць: <span class="decor_doors">${car.numberOfDoors}</span> 
										 | <span class="decor_seats">${car.numberOfSeats}</span>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 decor_body_doors_seats_engine">
										Двигун: <span class="decor_volume">${car.volume} л.</span> 
										 <span class="decor_power">${car.power} к.с.</span> 
										<span class="decor_fuel">${car.fuel}</span>
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="row">
									<div class="col-sm-12 decor_gearbox_color_mileage">
										Коробка передач: <span class="decor_gearbox">${car.gearbox}</span>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 decor_gearbox_color_mileage">
										Колір: <span class="decor_color">${car.color}</span>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 decor_gearbox_color_mileage">
										Пробіг: <span class="decor_mileage">${car.mileage} км</span>
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="row">
									<div class="col-sm-12 decor_carDriveType_state">
										Привід: <span class="decor_carDriveType">${car.carDriveType}</span>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 decor_carDriveType_state">
										Стан автомобіля: <span class="decor_state">${car.state}</span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 decor_character">
								<span class="character">Комплектація</span>
								<hr>						
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 decor_comfort">
								<span>${car.comfort}</span><br>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 decor_character">
								<span class="character">Опис</span>
								<hr>						
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 decor_description">
								<span>${car.description}</span>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 decor_character">
								<a href="javascript:void(0)" onclick="showHide('phone')">Показати/сховати контактний телефон:</a> 
								<span class="character" id="phone" style="display: none;">${car.owner}</span>					
							</div>
						</div>
					</c:forEach>
		 	 	</div>
		 	 </div>
		 	 <div class="row">
					<div class="col-sm-10 col-sm-offset-1 footer ">
						<hr>
						<h6 class="text-center">© 2017 created by Vovk Oleh</h6>
					</div>
			</div>
		</div>
</body>
</html>