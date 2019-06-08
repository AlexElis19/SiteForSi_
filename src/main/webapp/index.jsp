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
            width: 30%;
            height: 100px;
            text-align: center;
        }
        .block2 {
            float: left;
            width: 70%;
            height: 80%;
            background-color: lightgoldenrodyellow;
        }
        .block3 {
            float: left;
            width: 30%;
            height: 80% ;
            padding: 0;
            background-color: #e8e8c0;
        }
    </style>

    <body background="resurces/back.jpg"><div class="main" align="center">
    <div class="block" align="left"> <img width="100" height="80" src="resurces/logo.png"></div>
    <div class="block1" align="right">
        <%! private int ig = 0;%>
        <%! private int g = 0;%>
        <%! private List<Long> PrdOrd;%>

        <% String name = (String) request.getSession().getAttribute("name"); %>
        <c:set var="myName" value="<%=name.toString()%>"/>
        <h3>Пользователь:  </h3>
        <h3>${myName}</h3>
    </div><div class="block2" align="center">
        <%! ArrayList<Product> productsView = new ArrayList<Product>();%>
        <%productsView = Data.getInstance().getProducts();%>
        <%g=productsView.size();%>

        <h2>Список продуктов:</h2>
        <% if (request.getAttribute("list") == null) {%>
            <% request.setAttribute("list", new ArrayList());%>
        <%}%>

        <% ((List)request.getAttribute("list")).clear(); %>

        <% for (int i=1; i<=g; i++) {%>
        <% ((List)request.getAttribute("list")).add (Data.getInstance().getProductById(i)); %>
        <%}%>

        <table>
            <col width="150" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <tr>
                <th>Наименование</th>
                <th>Цена</th>
                <th>Купить</th>
            </tr>
            <c:forEach items="${list}" var="item">
                <% ++ig; %>
                <tr>
                    <td align="center">
                        ${item.name}
                    </td>
                    <td align="center">
                        ${item.price}
                    </td>
                    <td align="center"><br>
                        <form id=<%=ig%> name="BuyPrdButton" method="post" action="/hello">
                            <input id="btn" type="submit" value="Купить" name="button";/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div><div class="block3">
        <%((List)request.getAttribute("list")).clear(); %>
        <% ig=0; %>

        <h2>Корзина:</h2>

        <% Long id = (Long) request.getSession().getAttribute("idUser"); %>

        <% PrdOrd = Data.getInstance().getOrderByCustomer(id).getProducts(); %>
        <table>
            <col width="150" valign="top">
            <col width="100" valign="top">
            <tr>
                <th>Наименование</th>
                <th>Цена</th>
        <%for (int j=0; j<PrdOrd.size(); j++){ %>
            <tr>
                <td align="center">
                    <%=Data.getInstance().getProductById(PrdOrd.get(j)).getName()%>
                </td>
                <td align="center">
                    <%=Data.getInstance().getProductById(PrdOrd.get(j)).getPrice()%>
                </td>
            </tr>
        <% } %>
        </table>
        <%-- } --%>
    </div></div>
    </body>
</html>
