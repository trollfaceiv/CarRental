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
        <div style="display:none;" id = "error-div" class="alert alert-danger " ></div>
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
				<form:form  method="POST" modelAttribute="rent">
				<div class="form-body">
				
					<div class="form-group">
						    <label class="active" for="startDate"><spring:message code="rentinfo.table.startdate"/></label>
						<form:input id="startDate" path="startDate" type="date" class="form-control"  required="true" />  
					</div>
					
						<div class="form-group">
						    <label class="active" for="endDate"><spring:message code="rentinfo.table.enddate"/></label>
						<form:input id="endDate" path="endDate" type="date" class="form-control"  required="true" />  
					</div>
				       							
				</div>
				
				<hr class="line-form">
				
				<div class="form-actions">
					<input type="submit" id="btnAdd" class="btn btn-primary form-buttons" value = <spring:message code = "insvehicle.form.btnConfirm.label" />>
					<a id="btnAdd" href="<spring:url value="/vehicle/show/"/>" class="btn btn-primary form-buttons">
									<spring:message code = "insvehicle.form.btnAbort.label"/>
	      						</a> 
				</div>			
				</form:form>
			</div>
			</div>
</section>
<script>
const dateInput = document.getElementById('startDate');
const submitBtn = document.getElementById('btnAdd');
const dateSInput = document.getElementById('endDate');
const errorDiv = document.getElementById('error-div');
submitBtn.addEventListener('click', function(e) {
  const selectedDate = new Date(dateInput.value);
  const selectedSDate = new Date(dateSInput.value);
  const currentDate = new Date();
  if (selectedDate < currentDate || selectedSDate < currentDate) {
	errorDiv.textContent = 'La data inserita non può essere antecedente a quella odierna.';
	errorDiv.style.display = 'block';
    e.preventDefault(); 
  }
  if(selectedSDate < selectedDate){
	  errorDiv.textContent = 'Seleziona un periodo valido.';
		errorDiv.style.display = 'block';
	    e.preventDefault(); 
  }
});
</script>