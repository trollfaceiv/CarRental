<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

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
			<h3 class="page-title"><spring:message code = "users.table.label.allusers"/></h3>
			<a href=" <spring:url value="/user/add" /> " class="btn btn-primary">
		<spring:message code = "users.table.btn.adduser"/>
	      	</a> 
	      	<p></p>
		</div>
			<table id="utenti" class="table table-striped table-bordered">
				<thead>
		            <tr>
		                <th><spring:message code = "users.table.id"/></th>
		         	    <th><spring:message code = "users.table.firstname"/></th>
 						<th><spring:message code = "users.table.lastname"/></th>
		         	    <th><spring:message code = "users.table.birthdate"/></th>
		        		<th></th>		         	    
		         	    		         	    
		            </tr>
	        	</thead>
	        	<tfoot>
	        	</tfoot>
	        	<tbody>
	        		<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.firstName}</td>
      						<td>${user.lastName}</td>
      						<td>${user.birthDate}</td>
      						<td>
								<a href=" <spring:url value="/user/info/${user.id}" /> " class="btn btn-primary">
									<spring:message code = "users.table.btn.rentlist"/>
	      						</a> 
      						</td>
						</tr>
					</c:forEach>
	        	</tbody>
			</table>
		</div>
	</section>