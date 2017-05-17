<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="page" value="index"/>
<!DOCTYPE html>
<html class="no-js">
    <%@include file='components/head.jsp'%>
    <body>
    <%@include file='components/header.jsp'%>
    <div class="slider">
        <div class="container">
            <input type="radio" id="btn-1" name="toggle" checked>
            <input type="radio" id="btn-2" name="toggle">
            <input type="radio" id="btn-3" name="toggle">
            <div class="slider-controls">
                <label for="btn-1"></label>
                <label for="btn-2"></label>
                <label for="btn-3"></label>
            </div>
            <div class="slides">
                <div class="slide-1">
                    <div class="width-50">
                        <div class="h1  slide-title">
                            <s:message code="index.garden1"/><br>
                            <s:message code="index.garden2"/>
                        </div>
                        <p>
                            <s:message code="index.garden.detail1"/><br>
                            <s:message code="index.garden.detail2"/>
                    </div>
                </div>
                <div class="slide-2">
                    <div class="width-50">
                        <div class="h1  slide-title">
                            <s:message code="index.swimmingpool"/>
                        </div>
                        <p><s:message code="index.swimmingpool.detail1"/><br>
                            <s:message code="index.swimmingpool.detail2"/>
                        </p>
                    </div>
                </div>
                <div class="slide-3">
                    <div class="width-50">
                        <div class="h1  slide-title">
                            <s:message code="index.chair"/>
                        </div>
                        <p><s:message code="index.chair.detail1"/></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="feature-row  index-content-row  clearfix">
            <div class="column-1-of-3  left">
                <div class="wrap">
                    <div class="feature-item">
                        <img src="<c:url value="/resources/pics/feature-1.png" />" alt="" width="240" height="124">
                        <div class="h2"><s:message code="index.review1.name"/></div>
                        <p><s:message code="index.review1.text"/></p>
                    </div>
                </div>
            </div>
            <div class="column-1-of-3  left">
                <div class="wrap">
                    <div class="feature-item">
                        <img src="<c:url value="/resources/pics/feature-2.png" />" alt="" width="240" height="124">
                        <div class="h2"><s:message code="index.review2.name"/></div>
                        <p><s:message code="index.review2.text"/></p>
                    </div>
                </div>
            </div>
            <div class="column-1-of-3  left">
                <div class="wrap">
                    <div class="feature-item">
                        <img src="<c:url value="/resources/pics/feature-3.png" />" alt="" width="240" height="124">
                        <div class="h2"><s:message code="index.review3.name"/></div>
                        <p><s:message code="index.review3.text"/></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="description-row  clearfix">
            <div class="column-2-of-3  left">
                <div class="h1"><s:message code="index.description.title"/></div>
                <p><s:message code="index.description.text"/></p>
            </div>
            <div class="column-1-of-3  right">
                <div class="wrap">
                    <div class="large-logo">
                        <img src="<c:url value="/resources/pics/content-logo.png" />" alt="Nerd's" width="240" height="119">
                    </div>
                </div>
            </div>
        </div>
        <div class="mode-row  index-content-row  clearfix">
            <div class="column-2-of-3  left">
                <div class="h3"><s:message code="index.weHave"/></div>
                <ul class="list">
                    <li><s:message code="index.weHave.feature1"/></li>
                    <li><s:message code="index.weHave.feature2"/></li>
                    <li><s:message code="index.weHave.feature3"/></li>
                </ul>
            </div>
        </div>
    </div>

    <%@include file='components/map.html'%>

    <%@include file='components/modal-window.jsp'%>

    <%@include file='components/footer.jsp'%>

    <script>
        var html = document.documentElement;
        html.classList.remove("no-js");
    </script>
    <script async src="<c:url value="/resources/js/script.js" />"></script>
    </body>
</html>