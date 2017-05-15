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
    <div class="container">
        <div class="inner-header">
            <h1>Our rooms: </h1>
        </div>

        <div class="items">

            <div class="item-card">
                <div class="item-img-wrapper">
                    <div class="item-header">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    <img src="<c:url value="/resources/pics/model-1.jpg" />" height="350" width="350" alt="Sunset">
                    <div class="item-description">
                        <p class="item-title">Sunset</p>
                        <p class="item-text">Интернет-магазин с личным кабинетом</p>
                        <a href="<c:url value="/booking" />" class="btn item-price">10 000 р.</a>
                    </div>
                </div>
            </div>

            <div class="item-card">
                <div class="item-img-wrapper">
                    <div class="item-header">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    <img src="<c:url value="/resources/pics/model-2.jpg" />" height="350" width="350" alt="Sunset">
                    <div class="item-description">
                        <p class="item-title">Lorem</p>
                        <p class="item-text">Lorem ipsum dolor sit amet</p>
                        <a href="#" class="btn item-price">15 000 р.</a>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <%@include file='components/footer.jsp'%>
    </body>
</html>