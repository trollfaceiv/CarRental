<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<!doctype html>
<html lang="it">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- open-iconic -->
<link href="<c:url value="/static/css/open-iconic-bootstrap.css" />"
	rel="stylesheet">

<!-- Altri CSS -->
<link href="<c:url value="/static/css/main.css" />" rel="stylesheet">

<title><tiles:insertAttribute name="titolo" /></title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			<a class="navbar-brand" href="<spring:url value="/"/>">
			  <img src="<c:url value="/static/images/logo.png"/>">
			</a>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item">
						<sec:authorize access="hasRole('ADMIN')">
						<a class="nav-link"
					href="<spring:url value="/user/show"/>">Gestisci utenti </a>
        					</sec:authorize>
						<sec:authorize access="!hasRole('ADMIN')">
           				 <a class="nav-link"
					href="<spring:url value="/user/info/${userLog.id}"/>">Profilo </a>
       				 </sec:authorize>
					</li>
				<li class="nav-item">
						<sec:authorize access="hasRole('ADMIN')">
	           				 <a class="nav-link"
					href="<spring:url value="/vehicle/show"/>">Gestisci veicoli </a>
        					</sec:authorize>
						<sec:authorize access="!hasRole('ADMIN')">
           				  <a class="nav-link"
					href="<spring:url value="/vehicle/show"/>">Lista veicoli </a>
       				 </sec:authorize></li>
				<li class="nav-item">
						<sec:authorize access="hasRole('ADMIN')">
	           				 <a class="nav-link"
					href="<spring:url value="/rent/show"/>">Gestisci noleggi </a>
        					</sec:authorize>
						
					</li>
			</ul>
		</div>
					<div class="dropdown">
				<button class="btn btn-default dropdown-toggle thumbnail"
					type="button" id="dropdownMenu1" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="true">
					<img class="img-circle"
						src="<c:url value="/static/images/user-solid.svg" />"> <span
						class="caret"></span>
				</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenu1">
					<sec:authorize access="!isAuthenticated()">
					<a class="dropdown-item" href="<spring:url value="/login/form"/>">Accedi</a>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
					<a class="dropdown-item enabled" href="<spring:url value=""/>">Ciao <c:out value="${userLog.firstName}" />
					</a>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
					<div class="dropdown-divider"></div>
					<a class="dropdown-item disabled" href="<spring:url value="/login/form/logout"/>">Log out</a>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
					<div class="dropdown-divider"></div>
					<a class="dropdown-item enabled" href="<spring:url value="/login/form/logout"/>">Log out</a>
					</sec:authorize>
				</div>
			</div>
	</nav>

	<tiles:insertAttribute name="content" />

	<tiles:insertAttribute name="footer" />

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script type="text/javascript"
		src="<c:url value="/static/js/jquery-3.2.1.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</body>
</html>