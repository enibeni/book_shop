<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>*BLUE'n'ORANGE*</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link href="../../style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="../../css/bootstrap.css" type="text/css" />
</head>
<body>
<div id="container">
    <div id="banner"> <img src="../../img/banner.jpg" alt="banner" title="banner" /> </div>
    <div id="bannerb">
        <h1>Книжный магазин<span class="orange"> Букстор</span></h1>
        <p>Книга - лучший подарок!</p>
    </div>
    <div class="topnav">
        <div id="navcontainer">

        </div>
        <div class="clear">&nbsp; </div>
    </div>
    <div id="sidebar">

    </div>
    <div id="sidebar-b">

        <p></p>
        <img src="../../img/ad2.jpg" alt="banner" title="banner" />

    </div>
    <div id="content">
        <P><h2>Ваша корзина:</h2></P>
        <table border = "1" cellpadding="10px" width="100%" style="border-collapse: collapse">
            <tr><th>Название</th><th>Автор</th><th>Цена</th><th>Колличество</th><th>Удалить</th></tr>
            <c:forEach items='<%= request.getSession().getAttribute("cart") %>' var = "p">
                <tr>
                    <td>${p.title}</td>
                    <td>${p.author}</td>
                    <td>${p.price}</td>
                        <%--<td><input id = "quantity" type="number" value="${p.quantity}"></td>--%>
                    <td>${p.quantity}
                        <form method="post" action="/addCart/modifyCount?id=${p.id}">
                            <input type="submit" name="action" value="Меньше"/>
                            <input type="submit" name="action" value="Больше"/>
                            <input type="hidden" name="counter" value="${p.quantity}"/>
                            <input type="hidden" name="counter" value="${p.id}"/>
                        </form>
                    </td>
                    <td>
                        <a href = "../../remove.html?id=${p.id}"
                           onclick="return confirm('Вы уверены?')">Удалить</a>
                    </td>
                </tr>

            </c:forEach>
            <tr>
                <td colspan="5">
                    Общая стоимость: <%= request.getSession().getAttribute("total") %>р.
                </td>
            </tr>
        </table>
        <a href="../../products.html">&lt&lt&lt Продолжить покупки</a>
        <a href="../../customerAuthentication.html">Оформить заказ >>></a>

        <br><br><br><br><br><br><br><br><br><br>



    </div>
    <div id="footer"> <a href="#">На главную</a> | <a href="mailto:denise@mitchinson.net">Контакты</a> | Разработка сайта enibeni&copy; 2015<br/>

</div>
</body>
</html>


