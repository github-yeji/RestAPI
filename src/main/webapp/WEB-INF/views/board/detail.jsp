<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 내용</title>
<script
    src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
#wrap {
	width: 1000px;
	height: 200px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
	margin-left: 50px;
	font-size: 20px;
	border: 10;
}

td {
	border: 10;
	height: 40px;
}

#title {
	background-color: white
}

body {
	background-color: var(- -color-black);
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

#recipeTb {
	margin: 0 auto;
	border: solid 1px;
	width: 1300px;
	background-color: #FAFAFA;
}

#recipeTb, td {
	padding-left: 20px;
}

a {
	display: default;
	margin-left: 50px
}
</style>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
    crossorigin="anonymous"></script>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
    crossorigin="anonymous">

<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[name='readForm']");

		$(".delete_btn").on("click", function() {
			formObj.attr("action", "/board/delete");
			formObj.attr('method', "post");
			formObj.submit();
		});

		function checkAlert(result) {
			if (result == "delete success") {
				alert("삭제가 완료 되었습니다");
			}
		}

	})//document
</script>
</head>
<body>
    <nav class="navbar navbar-expand-xl navbar-dark bg-white"
        aria-label="Sixth navbar example">
        <div class="container-fluid">
            <a class="navbar-brand" href="intro.jsp"
                style="font-size: 70px; font-weight: bold; color: #FFA500; margin-left: 50px;">BabJo</a>
            <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarsExample06"
                aria-controls="navbarsExample06" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>

            </button>

            <div class="collapse navbar-collapse" id="navbarsExample06">
                <ul class="navbar-nav me-auto mb-2 mb-xl-0">
                    <li class="nav-item"><a class="nav-link"
                        href="intro.jsp"
                        style="font-size: 25px; font-weight: bold; color: #000000; margin-left: 100px;">
                            소개</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="Myref.jsp"
                        style="font-size: 25px; font-weight: bold; color: #000000; margin-left: 200px;">
                            내 냉장고</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="Recipe.jsp"
                        style="font-size: 25px; font-weight: bold; color: #000000; margin-left: 200px;">
                            추천레시피</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="Mypage.jsp"
                        style="font-size: 25px; font-weight: bold; color: #000000; margin-left: 200px;">
                            마이페이지</a></li>

                </ul>

            </div>
        </div>
    </nav>
    레시피번호 :
    <c:out value="${recipe_seq}" />
    <br> 접속한 유저 번호 :
    <c:out value="${user_seq}" />
    <input type="hidden" id="user_seq" name="user_seq" value="${user_seq}">
    <br>
    <br>
    <img src="/resources/images/eggroll.jpg" width="1000" height="400"
        alt="레시피사진" style="margin-left: 50px; margin-bottom: 20px;" />
    <table id="recipeTb">
        <tr>
            <td style="padding-top: 20px;">
                <h4 style="display: inline; font-weight: bold">요리
                    방법 -</h4>
                <h5 style="display: inline; font-weight: bold">
                    <c:forEach var="list" items="${list}" begin="0"
                        end="0">${list.recipe_nm}</c:forEach>
                </h5>
            </td>
        </tr>
        <tr>
            <td>&nbsp</td>
        </tr>
        <tr>
            <td>※주요재료 : <c:forEach var="irdnt" items="${irdnt}">${irdnt.cd_nm} </c:forEach></td>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.cooking_no}.${list.cooking_dc}</td>
            </tr>
        </c:forEach>
        <tr>
            <td>&nbsp</td>
        </tr>
    </table>
    <a href="/board/list/<c:out value="${user_seq}"/>"><button>돌아가기</button></a>
    <a href="/board/modify/<c:out value="${user_seq}"/>/<c:out value="${recipe_seq}"/>"><button>수정</button></a>
    <a href="/board/delete/<c:out value="${recipe_seq}"/>"><button
            type="button" class="delete_btn">삭제</button></a>
</body>
</html>