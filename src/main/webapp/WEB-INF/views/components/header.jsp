<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<security:authorize access="isAuthenticated()" var="authenticated"/>
<div class="main-header">
    <div class="container clearfix">
        <div class="logo  left">
            <a href="<c:url value="/index" />"><img src="<c:url value="/resources/pics/main-logo.png" />" alt="Hotel" width="139" height="56"></a>
        </div>
        <div class="main-navigation  right">
            <ul>
                <li>
                    <a href="<c:url value="/index"/>"><s:message code="header.main" /></a>
                </li>
                <li>
                    <a href="<c:url value="/rooms"/>"><s:message code="header.apartments" /></a>
                </li>
                <li>
                    <c:choose>
                        <c:when test="${not empty authenticated && authenticated == true}">
                            <a href="<c:url value="/logout"/>" data-toggle="tooltip" title="Logout" >
                                <security:authentication property="principal.username"/>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value="/login"/>">
                                <s:message code="header.login" />
                            </a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });

    $(document).ready(function(){
        var clauses = document.querySelector(".main-navigation").querySelectorAll("li");
        for (i = 0; i < clauses.length; i++) {
            if (clauses[i].getElementsByTagName("a")[0].getAttribute('href') === "${requestScope['javax.servlet.forward.request_uri']}") {
                clauses[i].classList.add("active")
            }
        }
    });
</script>
