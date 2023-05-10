<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
	
    			<h5 class="text-bold">
    				<spring:message code = "users.table.firstname"/> 
    			</h5>
    			<h6>${user.firstName} ${user.lastName}</h6>
    			<h5><spring:message code = "users.table.birthdate"/></h5>
    			<h6> ${user.birthDate}</h6>
    			<p><spring:message code ="users.table.label.myrents"/></div>
    			<div class="card-body">
    			<table id="rents" class="table table-striped table-bordered">
				<thead>
		            <tr>
		         	    <th><spring:message code = "insvehicle.form.plateNumber.label"/></th>
		         	    <th><spring:message code = "insvehicle.form.model.label"/></th>		         	    
		                <th><spring:message code = "insvehicle.form.registrationDate.label"/></th>	
		         		<th><spring:message code = "rentinfo.table.startdate"/></th>	
		                <th><spring:message code = "rentinfo.table.enddate"/></th>	
		                <th><spring:message code = "rentinfo.table.status"/></th>
		                	
		            </tr>
	        	</thead>
	        	<tfoot>
	        	</tfoot>
	        	<tbody>
				<c:forEach items="${rents}" var="rent">
						<tr>
						
							<td>${rent.vehicle.plateNumber}</td>
							<td>${rent.vehicle.model}</td>
      						<td>${rent.startDate}</td>
      						<td>${rent.endDate}</td>
      						<td>${rent.startDate}</td>
      						<td>${rent.approved}</td>
      						<sec:authorize access="hasRole('ADMIN')"><td>
      						<c:choose>
      						<c:when test= "${rent.approved=='In sospeso'}">
								<a href=" <spring:url value="/rent/approve/${rent.id}" /> " class="btn btn-primary">
									<spring:message code ="rentinfo.btn.approve"></spring:message>
	      						</a> 
	      						<a href=" <spring:url value="/rent/refuse/${rent.id}" /> " class="btn btn-primary">
									<spring:message code ="rentinfo.btn.refuse"></spring:message>
	      						</a> 
	      						</c:when>
	      						<c:otherwise>
								<a href=" <spring:url value="/rent/delete/${rent.id}" /> " class="btn btn-primary">
									<spring:message code ="rentinfo.btn.remove"></spring:message>
	      						</a> 
	      						</c:otherwise>
	      						</c:choose>
	      						</td>
	      						</sec:authorize>
      						
						</tr>
					</c:forEach>
	        	</tbody>
			</table>
</div>
 		 	       		


</section>