<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Школьный дневник - Кабинет учителя</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
    <div class="welcome-header">
        <h2>Приветствуем Вас, ${teacher.name}</h2>
    </div>

    <div class="form-container">
        <h3 class="section-title">Выбор параметров</h3>
        <form:form action="/check-grades">
            <div class="form-group">
                <label for="subject">Выберите свой предмет</label>
                <select name="subject" id="subject" class="form-control">
                    <c:forEach var="sub" items="${teacher.subjects}">
                        <option name="subject" value="${sub.id}">${sub.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="squad">Выберите группу обучающихся</label>
                <input type="hidden" name="squads" />
                <select name="squad" id="squad" class="form-control">
                    <c:forEach var="group" items="${squads}">
                        <option name="group" value="${group.id}">${group.name}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn">Перейти к настройки успеваемости</button>
        </form:form>
    </div>

    <div class="form-container">
        <h3 class="section-title">Журнал успеваемости</h3>

        <table class="grade-table">
            <thead>
            <tr>
                <th>ФИО ученика</th>
                <th>Группа</th>
                <th>Дисциплина</th>
                <th>Оценка</th>
                <th>Дата выставления</th>
                <th>Причина оценки</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="grade" items="${grades}">
                <tr>
                    <td class="hidden-id">${grade.id}</td>
                    <td>${grade.student.name}</td>
                    <td>${grade.student.squad.name}</td>
                    <td>${grade.subject.name}</td>
                    <td>${grade.grade}</td>
                    <td>${grade.dataIssue}</td>
                    <td>${grade.reason}</td>
                    <td>
                        <button class="btn" onclick="openModal(${grade.id}, ${grade.grade}, '${grade.dataIssue}', '${grade.reason}')">
                            Обновить
                        </button>
                        <form:form action="/delete-grades" style="display: inline-block; margin-left: 5px;">
                            <input type="hidden" name="idGrade" value="${grade.id}" />
                            <button type="submit" class="btn btn-danger">Удалить</button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Модальное окно -->
    <div id="updateModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h3>Редактирование оценки</h3>
            <form:form action="/update-grades" method="POST" modelAttribute="gradeForm">
                <input type="hidden" id="modalGradeId" name="id" />

                <div class="form-group">
                    <label for="grade">Оценка:</label>
                    <input type="number" id="grade" name="grade" min="1" max="5" class="form-control" required />
                </div>

                <div class="form-group">
                    <label for="dataIssue">Дата выставления:</label>
                    <input type="date" id="dataIssue" name="dataIssue" class="form-control" required />
                </div>

                <div class="form-group">
                    <label for="reason">Причина оценки:</label>
                    <textarea id="reason" name="reason" rows="3" class="form-control" required></textarea>
                </div>

                <button type="submit" class="btn">Сохранить изменения</button>
            </form:form>
        </div>
    </div>
</div>

<script>
    function openModal(id, grade, dataIssue, reason) {
        document.getElementById('modalGradeId').value = id;
        document.getElementById('grade').value = grade;
        document.getElementById('dataIssue').value = dataIssue;
        document.getElementById('reason').value = reason;
        document.getElementById('updateModal').style.display = 'block';
    }

    function closeModal() {
        document.getElementById('updateModal').style.display = 'none';
    }

    window.onclick = function(event) {
        const modal = document.getElementById('updateModal');
        if (event.target == modal) {
            closeModal();
        }
    }
</script>
</body>
</html>