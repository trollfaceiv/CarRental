<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h2>${Titolo}</h2>
                <p>${Titolo2}</p>
            </div>
        </div>
    </div>
</div>
<section class="container">
	<div class="row">
		
		<div class="card">
			<div class="card-body">
    			<h3 class="card-title price-art">
    				 "${vehicle.model}"
    			</h3>
    			<p class="card-text desc-art"> ${vehicle.manufacturer} ${vehicle.model}</p>
 		 	</div>
 		 	<ul class="list-group list-group-flush">
 		 		<li class="list-group-item"><spring:message code = "insvehicle.form.plateNumber.label"/><span class="info-art"> ${vehicle.plateNumber}</span></li>
	   			<li class="list-group-item"><spring:message code = "insvehicle.form.category.label"/><span class="info-art"> ${vehicle.category}</span></li>
	   			<li class="list-group-item"><spring:message code = "insvehicle.form.manufacturer.label"/><span class="info-art"> ${vehicle.manufacturer}</span></li>
	   			<li class="list-group-item"><spring:message code = "insvehicle.form.model.label"/><span class="info-art"> ${vehicle.model}</span></li>
	   	 		<li class="list-group-item"><spring:message code = "insvehicle.form.registrationDate.label"/><span class="info-art"> ${vehicle.registrationDate}</span></li>
  			</ul>
  			<div class="card-body">
  			<c:choose>
  			<c:when test = "${vehicle.avaible}">
    		<a  href=" <spring:url value="/rent/${userLog.id}/new/${vehicle.id}"/> " class="btn btn-primary">
    		<spring:message code = "vehicle.btn.rent"/>
	      	</a> 
	      	</c:when>
	      	<c:otherwise>
	      	<a  href="" class="btn btn-primary disabled">
    		<spring:message code = "vehicle.btn.rent"/>
    		</a>
	      	</c:otherwise>
	      	</c:choose>
    		<a href="<spring:url value="/vehicle/show/"/>" class="btn btn-primary">
									<spring:message code = "insvehicle.form.btnAbort.label"/>
	      						</a> 
  			</div>
		</div>
	</div>
</section>