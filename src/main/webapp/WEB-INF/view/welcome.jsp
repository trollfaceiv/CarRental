<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="userLog" value="${userLog}" scope="session" />

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h2>${intestazione}</h2>
              <sec:authorize access="!hasRole('ADMIN')">
                <p>
                    ${saluti}
                </p>
                </sec:authorize>
            </div>
        </div>
    </div>
</div>
