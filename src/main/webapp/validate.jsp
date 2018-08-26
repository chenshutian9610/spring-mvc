<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="/user/validating">
    <p>姓名：<input type="text" name="name"/>
    <p>密码：<input type="text" name="pwd"/>
    <p>邮箱：<input type="text" name="email"/>
    <p>生日：<input type="text" name="birthday"/><br>
    <input type="submit" value="submit"/>
</form>
<c:forEach items="${errors}" var="error">
    ${error.defaultMessage}<br>
</c:forEach>
</body>
</html>
