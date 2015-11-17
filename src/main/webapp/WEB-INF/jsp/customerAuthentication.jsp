<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Enibeni
  Date: 02.12.2014
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>You can register as a new customer:</h2>
<form:form commandName="customer" method="post" action="/customer/new">
  <table>
    <tr>
      <td>Name:</td>
      <td><form:input path="Name" /></td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><form:input path="Email" /></td>
    </tr>
    <tr>
      <td>Address:</td>
      <td><form:input path="Address" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Registration" />
      </td>
    </tr>
    <%--<form:hidden path="productId" />--%>
  </table>
</form:form>
</body>
</html>
