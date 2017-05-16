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
                        <div class="h1  slide-title">Огромный<br>цветущий сад</div>
                        <p>В нашем огромном саду всегда можно<br>
                            уединиться с природой!</p>
                    </div>
                </div>
                <div class="slide-2">
                    <div class="width-50">
                        <div class="h1  slide-title">БАССЕЙН</div>
                        <p>В любой момент вы всегда можете поплавать<br>
                            в нашем бассейне!</p>
                    </div>
                </div>
                <div class="slide-3">
                    <div class="width-50">
                        <div class="h1  slide-title">Стулья!</div>
                        <p>Вау!</p>
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
                        <div class="h2">Владислав</div>
                        <p>В огромном саду всегда можно уединиться с природой!</p>
                    </div>
                </div>
            </div>
            <div class="column-1-of-3  left">
                <div class="wrap">
                    <div class="feature-item">
                        <img src="<c:url value="/resources/pics/feature-2.png" />" alt="" width="240" height="124">
                        <div class="h2">Ирина</div>
                        <p>В любой момент вы всегда можете поплавать!</p>
                    </div>
                </div>
            </div>
            <div class="column-1-of-3  left">
                <div class="wrap">
                    <div class="feature-item">
                        <img src="<c:url value="/resources/pics/feature-3.png" />" alt="" width="240" height="124">
                        <div class="h2">Артур</div>
                        <p>Не получил пизды и очень этому рад!</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="description-row  clearfix">
            <div class="column-2-of-3  left">
                <div class="h1">Мы - небольшой отель в небольшом городе Минск.</div>
                <p>Исповедуем принципы минимализма и чистоты. Работаем не покладая рук ради вашего комфорта.</p>
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
                <div class="h3">только у нас:</div>
                <ul class="list">
                    <li>Красота</li>
                    <li>Спокойствие</li>
                    <li>Уют</li>
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