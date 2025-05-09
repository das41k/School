<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Приветствуем Вас, учитель! </h2>
<p> Для продолжения войдите в систему </p>
<form:form action="/login" modelAttribute="teacher">
    Код входа  <form:input path="entryCode" />
    <input type="submit" value="Вход" />
    ${error}
</form:form>
</body>
</html>
