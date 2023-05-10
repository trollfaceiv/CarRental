<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="jumbotron jumbotron-billboard">
	<div class="img"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>${Titolo}</h2>
				<p>${Titolo2}</p>
						<c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="portlet light bordered">
		 <div class="portlet-title">
		 	 <div class="caption font-red-sunglo">
             	<span class="caption-subject bold uppercase"><spring:message code = "insvehicle.form.title.label"/></span>
            </div>
		 </div>
		<div class="portlet-body form">
				<form:form  method="POST" modelAttribute="newVehicle">
				<div class="form-body">
				
					<div class="form-group">
						<label for="plateNumber"><spring:message code = "insvehicle.form.plateNumber.label"/></label>
						<form:input id="plateNumber" path="plateNumber" type="text" class="form-control" required="true" />  
					</div>
					
					<div class="form-group">
						<label for="category"><spring:message code = "insvehicle.form.category.label"/></label>
						<form:input id="category" path="category" type="text" class="form-control" required="true" placeholder="Berlina, suv, minivan..."/> 	 
					</div>
						<div class="form-group">
						<label for="manufacturer"><spring:message code = "insvehicle.form.manufacturer.label"/></label>
						<form:input id="manufacturer" path="manufacturer" type="text" class="form-control" required="true" placeholder="Fiat, audi.."/> 	 
					</div>
					
				<div class="form-group">
						<label for="model"><spring:message code = "insvehicle.form.model.label"/></label>
						<form:input id="model" path="model" type="text" class="form-control" required="true" placeholder="BMW Serie 3"/> 	 
					</div>
					
					<div class="form-group">
							<label for="registrationDate"><spring:message code = "insvehicle.form.registrationDate.label"/></label>
							<form:input id="registrationDate" path="registrationDate" type="text" placeholder ="1994.." required="true" value="2023" class="form-control"/>  
					</div>	
							<form:input id="avaible" path="avaible" type="hidden"/>  
				</div>
				
				<hr class="line-form">
				
				<div class="form-actions">
					<input type="submit" id="btnAdd" class="btn btn-primary form-buttons" value = <spring:message code = "insvehicle.form.btnConfirm.label" />>
					<a href="<spring:url value="/vehicle/show/"/>" class="btn btn-primary form-buttons">
									<spring:message code = "insvehicle.form.btnAbort.label"/>
	      						</a> 
				</div>				
				</form:form>
			</div>
			</div>
</section>