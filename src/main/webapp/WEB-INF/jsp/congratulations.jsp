<%--
  Created by IntelliJ IDEA.
  User: Enibeni
  Date: 03.12.2014
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>

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
        Поздравляем, ваш заказ на сумму <%= request.getSession().getAttribute("total") %> рублей оформлен!  <br>
        Номер вашего заказа: <%= request.getSession().getAttribute("orderId") %><br>
        <a href="../../products.html">венруться к покупкам</a> <br>
        <a href="/order/list">посмотрть заказы</a>


        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



    </div>
    <div id="footer"> <a href="#">На главную</a> | <a href="mailto:denise@mitchinson.net">Контакты</a> | Разработка сайта enibeni&copy; 2015<br/>
</div>
</body>
</html>




