<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 목록</title>
</head>
<style>
    table {
        border:solid 1px;
        width:1500px;
    }

</style>
<body>
<table>
    <tr>
        <th>레시피 번호</th>
        <th>레시피 이름</th>
        <th>간단 소개</th>
        <th>음식 분류</th>
    </tr>
    <c:forEach var="list" items="${list}">

    <tr>
        <td><a href="/board/detail/<c:out value="${list.user_seq}"/>/<c:out value="${list.recipe_seq}"/>">${list.recipe_seq}</a></td>
        <td><a href="/board/detail/<c:out value="${list.user_seq}"/>/<c:out value="${list.recipe_seq}"/>">${list.recipe_nm}</a></td>
        <td><a href="/board/detail/<c:out value="${list.user_seq}"/>/<c:out value="${list.recipe_seq}"/>">${list.recipe_sumry}</a></td>
        <td>${list.recipe_nation_nm}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>