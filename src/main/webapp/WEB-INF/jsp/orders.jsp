<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Enibeni
  Date: 03.12.2014
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1" cellpadding="5px"  cellpadding="10px" width="100%">
  <tr><th>Title</th></tr>
  <c:forEach var="order" items="${order}">
    <tr>
      <td><c:out value="${order.products}"/></td>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
