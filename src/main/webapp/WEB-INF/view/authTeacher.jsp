<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Школьный дневник - Вход</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
    <div class="welcome-header">
        <h2>Приветствуем Вас, учитель!</h2>
        <p>Для продолжения войдите в систему</p>
    </div>

    <div class="form-container">
        <form:form action="/login" modelAttribute="teacher">
            <div class="form-group">
                <label for="entryCode">Код входа</label>
                <form:input path="entryCode" id="entryCode" class="form-control" />
            </div>
            <button type="submit" class="btn">Вход</button>
            <c:if test="${not empty error}">
                <div class="error-message">${error}</div>
            </c:if>
        </form:form>
    </div>
</div>
</body>
</html>