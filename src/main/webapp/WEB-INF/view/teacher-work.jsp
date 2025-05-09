<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Приветствуем Вас, ${teacher.name} </h2>
<div>
    <form:form action="/check-grades">
        <div>
            <div>
                <p> Выберите свой предмет </p>
                <select name="subject">
                    <c:forEach var="sub" items="${teacher.subjects}">
                        <option name="subject" value="${sub.id}"> ${sub.name} </option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <p> Выберите группу обучающихся </p>
                <input type="hidden" name="squads" />
                <select name="squad">
                    <c:forEach var="group" items="${squads}">
                        <option name="group" value="${group.id}"> ${group.name} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <input type="submit" value="Перейти к настройки успеваемости">
    </form:form>

    <div>
        <h2>Журнал успеваемости</h2>

        <table>
            <thead>
            <tr>
                <th>ФИО ученика</th>
                <th>Группа</th>
                <th>Дисциплина</th>
                <th>Оценка</th>
                <th>Дата выставления</th>
                <th>Причина оценки</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="grade" items="${grades}">
                    <tr>
                        <td style="visibility: hidden"> ${grade.id} </td>
                        <td> ${grade.student.name} </td>
                        <td> ${grade.student.squad.name} </td>
                        <td> ${grade.subject.name} </td>
                        <td> ${grade.grade} </td>
                        <td> ${grade.dataIssue} </td>
                        <td> ${grade.reason} </td>
                        <td>
                            <form:form action="/update-grades">
                                <input type="hidden" name="idGrade" value="${grade.id}" />
                                <input type="submit" value="Обновить сведения">
                            </form:form>
                        </td>
                        <td>
                            <form:form action="/delete-grades">
                                <input type="hidden" name="idGrade" value="${grade.id}" />
                                <input type="submit" value="Удалить запись">
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
