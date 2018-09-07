<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>データ一覧</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/>
</head>
<body>
    <center>
        <h2>
            <a href="./">トップメニューへ戻る</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5" id="table" class="display" style="width:80%">
            <thead>
            <tr>
	            <c:choose>

	            <c:when test="${!empidSort}">
	            <th><a href="EmpidUp">社員ID</a></th>
	            </c:when>

	            <c:when test="${empidSort}">
	            <th><a href="EmpidDown">社員ID</a></th>
	            </c:when>

	            <c:otherwise>
	            <th><a href="EmpidUp">社員ID</a></th>
	            </c:otherwise>

	            </c:choose>


                <c:choose>

	            <c:when test="${!nameSort}">
	            <th><a href="nameUp">氏名</a></th>
	            </c:when>

	            <c:when test="${nameSort}">
	            <th><a href="nameDown">氏名</a></th>
	            </c:when>

	            <c:otherwise>
	            <th><a href="nameUp">氏名</a></th>
	            </c:otherwise>

	            </c:choose>


                <c:choose>

	            <c:when test="${!emailSort}">
	            <th><a href="emailUp">メールアドレス</a></th>
	            </c:when>

	            <c:when test="${emailSort}">
	            <th><a href="emailDown">メールアドレス</a></th>
	            </c:when>

	            <c:otherwise>
	            <th><a href="emailUp">メールアドレス</a></th>
	            </c:otherwise>

	            </c:choose>



                <c:choose>

	            <c:when test="${!genderSort}">
	            <th><a href="genderUp">性別</a></th>
	            </c:when>

	            <c:when test="${genderSort}">
	            <th><a href="genderDown">性別</a></th>
	            </c:when>

	            <c:otherwise>
	            <th><a href="genderUp">性別</a></th>
	            </c:otherwise>

	            </c:choose>


                <c:choose>

	            <c:when test="${!deptSort}">
	            <th><a href="deptUp">部署</a></th>
	            </c:when>

	            <c:when test="${deptSort}">
	            <th><a href="deptDown">部署</a></th>
	            </c:when>

	            <c:otherwise>
	            <th><a href="deptUp">部署</a></th>
	            </c:otherwise>

	            </c:choose>
            </tr>
            </thead>
            <c:forEach var="data" items="${listData}">
                <tr>
                    <td><c:out value="${data.empid}" /></td>
                    <td><c:out value="${data.name}" /></td>
                    <td><c:out value="${data.email}" /></td>
                    <td>
                    <c:choose>
                    <c:when test="${data.gender == 0}"><c:out value="未選択" /></c:when>
                    <c:when test="${data.gender == 1}"><c:out value="男" /></c:when>
                    <c:when test="${data.gender == 2}"><c:out value="女" /></c:when>
                    </c:choose>
                    </td>
                    <td><c:out value="${data.dept}" /></td>
                </tr>
            </c:forEach>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script>
    $(document).ready(function() {
        $('#table').DataTable({
        	"ordering": false,
        	"searching": false,
        	"info": false,
        	"lengthChange": false,
        });
    } );
    </script>
</body>
</html>