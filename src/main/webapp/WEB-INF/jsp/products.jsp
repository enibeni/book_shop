<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>Company<span class="orange"> Name</span></h1>
        <p>You could have a news flash here or a mini blog maybe?</p>
    </div>
    <div class="topnav">
        <div id="navcontainer">
            <ul id="navlist">
                <li id="active"><a href="#" id="current">Item one</a></li>
                <li><a href="#">Item two</a></li>
                <li><a href="#">Item three</a></li>
                <li><a href="#">Item four</a></li>
                <li><a href="#">Item five</a></li>
            </ul>
        </div>
        <div class="clear">&nbsp; </div>
    </div>
    <div id="sidebar">
        <h1>Navigation</h1>
        <div id="menu">
            <ul>
                <li><a href="/products">Products</a></li>
                <li><a href="#">TODC</a></li>
                <li><a href="#">Andreas Viklund</a></li>
                <li><a href="#">James Koster</a> </li>
                <li><a href="#">OSWD</a></li>
                <li><a href="#">CSS play</a></li>
                <li><a href="#">Listamatic </a></li>
            </ul>
            <a href="/products/new">create new product</a>
        </div>
        <p> Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nulla congue, velit tristique mattis auctor, velit elit euismod diam, a interdum tortor enim eget ante. </p>
    </div>
    <div id="sidebar-b">
        <h1>More Info</h1>
        <p> Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nulla congue, velit tristique mattis auctor, velit elit euismod diam, a interdum tortor enim eget ante. </p>
        <ul>
            <li><a href="#">Link 1</a></li>
            <li><a href="#">Link 2</a></li>
            <li><a href="#">Link 3</a></li>
        </ul>
        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
    </div>
    <div id="content">
        <%--<jsp:useBean id="shopService" class="shop.trick.ShopService" scope="application"/>--%>
        <table border="1" cellpadding="5px"  width="100%">
            <tr><th>Title</th><th>Price</th><th>Edit</th><th>Delete</th><th>Add to cart</th></tr>
            <c:forEach var="product" items="${products}">
                <tr>
                        <%--<td><c:out value="${product.id}"/></td>--%>
                    <td><a href="/products/${product.id}/view"><c:out value="${product.title}"/></a></td>
                    <td><c:out value="${product.price}"/></td>
                    <td><a href="/products/${product.id}/edit">Edit</a></td>
                    <td><a href="/products/${product.id}/delete"
                           onclick="return confirm('Are you sure?')">Delete</a></td>
                    <td>
                        <f:form modelAttribute = "product" action = "addCart/${product.id}" method="post">
                            <%--<f:input path="product.id"/>--%>
                            <input type="submit"  value="Add to cart"/>
                        </f:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="/products/new">create new product</a>


    </div>
    <div id="footer"> <a href="#">homepage</a> | <a href="mailto:denise@mitchinson.net">contact</a> | <a href="http://validator.w3.org/check?uri=referer">html</a> | <a href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a href="http://www.mitchinson.net"> www.mitchinson.net</a><br/>
        This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 License</a> </div>
</div>
</body>
</html>


