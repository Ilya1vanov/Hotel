<%@ page import="org.springframework.context.i18n.LocaleContextHolder" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="page" value="rooms"/>
<!DOCTYPE html>
<html class="no-js">
    <%@include file='components/head.jsp'%>
    <body>
    <%@include file='components/header.jsp'%>
    <div class="container">
        <div class="inner-header">
            <h1><s:message code="rooms.outRooms"/></h1>
        </div>

        <div class="items">

            <c:forEach items="${rooms}" var="room">
                <div class="item-card">
                    <div class="item-img-wrapper">
                        <div class="item-header">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                        <img src="<c:url value="/resources/pics/model-${room.id}.jpg" />" height="350" width="350" alt="${room.getDescriptionWithLocale(pageContext.response.locale).title}">
                        <div class="item-description">
                            <p class="item-title">${room.getDescriptionWithLocale(pageContext.response.locale).title}</p>
                            <p class="item-text">${room.getDescriptionWithLocale(pageContext.response.locale).text}</p>
                            <a href="<c:url value="/booking/${rooms.id}" />" class="btn item-price">${room.price} $</a>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

    <%@include file='components/footer.jsp'%>

    </body>
</html>