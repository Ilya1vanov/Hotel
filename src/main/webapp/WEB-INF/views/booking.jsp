<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="page" value="booking"/>
<!DOCTYPE html>
    <%@include file='components/head.jsp'%>
    <body>
        <%@include file='components/header.jsp'%>

        <div class="container">
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
                        <a href="#" class="btn item-price">${room.price} $</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="inner-content">
            <div class="modal-window">
                <div class="modal-content">
                    <sf:form method="POST" commandName="booking" action="/booking">
                        <div class="clearfix">
                            <div class="input-text-less  column-1-of-2  left">
                                <div class="wrap">
                                    <sf:label path="from">
                                        <s:message code="booking.from" />:</sf:label>
                                        <%--<sf:errors path="firstName" cssClass="error"/>--%>
                                </div>
                            </div>
                            <div class="input-text-less  column-1-of-2  right">
                                <div class="wrap">
                                    <sf:input path="from" cssErrorClass="error" placeholder="John" />
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="column-1-of-2  left">
                                <div class="wrap">
                                    <input type="submit" value="<s:message code="booking.submit" />" />
                                </div>
                            </div>
                            <div class="input-text-less  column-1-of-2  right">
                                <div class="wrap">
                                    <label style="color: green;"><c:if test="${not empty success}"><s:message code="registration.success"/></c:if></label>
                                </div>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>

        <%@include file='components/footer.jsp'%>
    </body>
</html>
