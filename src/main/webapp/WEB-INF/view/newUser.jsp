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
				<c:if test="${not empty registrationError}">
        <div class="alert alert-danger">${registrationError}</div>
    </c:if>
								
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="portlet light bordered">
		 <div class="portlet-title">
		 	 <div class="caption font-red-sunglo">
      
             	<span class="caption-subject bold uppercase"><spring:message code = "users.form.adduser"/></span>
            </div>
		 </div>
		<div class="portlet-body form">
				<form:form  method="POST" modelAttribute="newUser">
				<div class="form-body">
				
					<div class="form-group">
						<label for="firstName"><spring:message code = "users.table.firstname"/></label>
						<form:input id="firstName" path="firstName" type="text" class="form-control"  />  
					</div>
					
					<div class="form-group">
						<label for="lastName"><spring:message code = "users.table.lastname"/></label>
						<form:input id="lastName" path="lastName" type="text" class="form-control"/> 	 
					</div>
						<div class="form-group">
						    <label class="active" for="dateStandard"><spring:message code = "users.table.birthdate"/></label>
						<form:input id="birthDate" path="birthDate" type="date" class="form-control"  />  
					</div>
					
				<div class="form-group">
						<label for="username"><spring:message code = "users.table.username"/></label>
						<form:input id="username" path="userName" type="text" class="form-control"/> 	 
					</div>
					
					<div class="form-group">
							<label for="password"><spring:message code = "users.table.password"/></label>
							<form:input id="password" path="password" type="password" class="form-control"/>  
					</div>	
				</div>
				
				<hr class="line-form">
				
				<div class="form-actions">
					<input type="submit" id="btnAdd" class="btn btn-primary form-buttons" value = <spring:message code = "insvehicle.form.btnConfirm.label" />>
					<a href="<spring:url value="/user/show"/>" class="btn btn-primary form-buttons">
									<spring:message code = "insvehicle.form.btnAbort.label"/>
	      						</a> 
				</div>				
				</form:form>
			</div>
			</div>
</section>