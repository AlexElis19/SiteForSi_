<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ystu.web_first.Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ystu.web_first.Main" %>
<%@ page import="com.ystu.web_first.servlets.HelloServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
    <meta charset="utf-8" />

    <style type="text/css">
        .main{
            width: 800px;
            position: center;
            margin:0 auto;
            background-color: lightgoldenrodyellow;
        }
        .block {
            background-color: tan;
            float: left;
            width: 70%;
            height: 90px;
            padding-top: 10px;
        }
        .block1 {
            float: left;
            background-color: #dcbe95;
            width: 100%;
            height: 90px;
            text-align: center;
            padding-top: 10px;
        }
        .block2 {
            float: left;
            width: 100%;
            height: 80%;
            background-color: lightgoldenrodyellow;
        }
    </style>
    <body background="resurces/back.jpg"><div class="main" align="center">
    <div class="block1"> <img width="100" height="80" src="resurces/logo.png"></div>
        <%! private int ig = 0;%>
    <div class="block2">
        <h2>Авторизация</h2>
        <form id=<%=ig%> name="LoginShop" method="get">
        <p>Логин:<input   type="text" name="login" /></p>
        <p>Пароль:<input  type="password" name="pass" /></p>
        <p><input type="submit" name="submit" value="Вход" /></p>
        </form>

        <% if (request.getAttribute("msgAut") != null) {%>
        <% String messageAut = (String) request.getAttribute("msgAut"); %>
        <c:set var="msgAutView" value="<%=messageAut.toString()%>"/>
        <h3>${msgAutView}</h3>
        <%}%>

    <br>

        <h2>Регистрация</h2>
        <form id=<%=ig%> name="RegUser" method="post">
            <p>Логин:<input type="text" name="loginReg" /></p>
            <p>Пароль:<input  type="password" name="passReg" /></p>
            <p>Email:<input  type="text" name="emailReg" /></p>
            <p><input type="submit" name="submit" value="Регистрация" /></p>
        </form>

        <% if (request.getAttribute("msgReg") != null) {%>
            <% String messageReg = (String) request.getAttribute("msgReg"); %>
            <c:set var="msgRegView" value="<%=messageReg.toString()%>"/>
            <h3>${msgRegView}</h3>
        <%}%>

    </div></div>
    </body>
</html>
