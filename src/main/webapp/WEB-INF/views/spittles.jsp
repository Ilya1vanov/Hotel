<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="resources/style.css"/>" >
</head>
<body>
    <h1>Welcome to Spittr</h1>
    <ul>
        <jsp:useBean id="spittleList" scope="request" type="java.util.List"/>
        <c:forEach items="${spittleList}" var="spittle" >
            <li id="spittle_<c:out value="spittle.id"/>">
                <div class="spittleMessage">
                    <c:out value="${spittle.message}" />
                </div>
                <div>
                    <span class="spittleTime"><c:out value="${spittle.time}" /></span>
                    <span class="spittleLocation">
                        (<c:out value="${spittle.latitude}" />,
                        <c:out value="${spittle.longitude}" />)
                    </span>
                </div>
            </li>
        </c:forEach>
    </ul>
</body>
</html>