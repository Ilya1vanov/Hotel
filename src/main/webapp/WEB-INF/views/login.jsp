<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 14.05.2017
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<c:set var="page" value="login"/>
<!DOCTYPE html>
<html>
    <%@include file='components/head.jsp'%>
    <body>
        <%@include file='components/header.jsp'%>

        <div class="inner-content">
            <div class="modal-window">
                <div class="modal-content">
                    <form action="<c:url value="/login"/>" method="POST" onload='document.forms[0].username.focus();'>
                        <div class="clearfix">
                            <div class="input-text">
                                <label for="username" >
                                    <s:message code="login.username" /></label>
                                <input type="text" id="username" name="username" placeholder="Username" />
                            </div>
                            <div class="input-text">
                                <label for="password" >
                                    <s:message code="login.password" /></label>
                                <input type="password" id="password" name="password" placeholder="*****" />
                            </div>
                        </div>
                        <input id="remember_me" name="remember-me" type="checkbox"/>
                        <label for="remember_me" class="inline"><s:message code="login.rememberMe"/></label>
                        <label><a href="<c:url value="/registration"/>" class=right><s:message code="login.registration"/></a></label>
                        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                            <div style="color: red" style="margin-top: 3px;">
                                <s:message code="login.error"/>
                            </div>
                        </c:if>
                        <input name="submit" type="submit" class="btn" value="<s:message code="login.login"/>"/>
                        <button type="reset" class="btn btn-gray"><s:message code="login.erase"/></button>
                    </form>
                </div>
            </div>
        </div>

        <%@include file='components/footer.jsp'%>
    </body>
</html>
