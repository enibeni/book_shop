<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<h2>Product</h2>
<form:form commandName="product" method="post" action="/products/new">
  <table>
    <%--<tr>--%>
      <%--<td>Name:</td>--%>
      <%--<td><form:input path="Id" /></td>--%>
    <%--</tr>--%>
    <tr>
      <td>Title:</td>
      <td><form:input path="Title" /></td>
    </tr>
    <tr>
      <td>Price:</td>
      <td><form:input path="Price" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Save Changes" />
      </td>
    </tr>
    <form:hidden path="productId" />
  </table>
</form:form>
</body>
</html>
