<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html class="no-js">
    <%@include file='components/head.jsp'%>
    <body>
        <%@include file='components/header.jsp'%>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
        <div class="inner-header">
            <h1>Oops...</h1>
            <h2>It looks like we don't have this page</h2>
            <button class="btn btn-large btn-green" onclick="goBack()">Back to safety</button>
        </div>

        <%@include file='components/footer.jsp'%>

        <script>
            var html = document.documentElement;
            html.classList.remove("no-js");
        </script>
        <script async src="<c:url value="/resources/js/script.js" />"></script>
    </body>
</html>