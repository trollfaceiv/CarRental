<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
            </div>
        </div>
    </div>
</div>
    <section class="container">
		<div class="row">
		<div class = "col-md-6 col-sm-6">
			<h3 class="page-title">Risultati Ricerca</h3>
			<sec:authorize access="hasRole('ADMIN')">
	      						<a href=" <spring:url value="/vehicle/add/" /> " class="btn btn-primary">
		<spring:message code = "insvehicle.btn.addvehicle"/></a>
	      						</sec:authorize>
	      	<p></p>
		</div>
			<table id="articoli" class="table table-striped table-bordered">
				<thead>
		            <tr>
		                <th><spring:message code="insvehicle.form.id.label"/></th>
		         	    <th><spring:message code="insvehicle.form.plateNumber.label"/></th>
 						<th><spring:message code="insvehicle.form.category.label"/></th>
 						<th><spring:message code="insvehicle.form.manufacturer.label"/></th>
		         	    <th><spring:message code="insvehicle.form.model.label"/></th>		         	    
		                <th><spring:message code="insvehicle.form.registrationDate.label"/></th>	
		                <th><spring:message code="insvehicle.form.avaibility.label"/></th>
		            </tr>
	        	</thead>
	        	<tfoot>
	        	</tfoot>
	        	<tbody>
	        		<c:forEach items="${Vehicles}" var="vehicle">
						<tr>
							<td>${vehicle.id}</td>
							<td>${vehicle.plateNumber}</td>
      						<td>${vehicle.category}</td>   
 							<td>${vehicle.manufacturer}</td>
      						<td>${vehicle.model}</td>
      						<td>${vehicle.registrationDate}</td>
      						<td><c:choose><c:when test="${vehicle.avaible == true}">
      						<p class="text-success"><spring:message code = "vehicles.table.label.avaible"/></p>
      						</c:when>
      						<c:otherwise>
      						<p class="text-danger"><spring:message code = "vehicles.table.label.unavaible"/></p>
      						</c:otherwise>
      						</c:choose>
      						</td>
      						<td>
								<a href=" <spring:url value="/vehicle/info/${vehicle.id}" /> " class="btn btn-primary">
									Info 
	      						</a>
	      						<sec:authorize access="hasRole('ADMIN')">
	      						<a href=" <spring:url value="/vehicle/add/${vehicle.id}" /> " class="btn btn-primary">
									Modifica 
	      						</a> 
	      						<a href=" <spring:url value="/vehicle/delete/${vehicle.id}" /> " class="btn btn-primary">
									Elimina 
	      						</a> 
	      						</sec:authorize>
      						</td>
						</tr>
					</c:forEach>
	        	</tbody>
			</table>
		</div>
	</section>