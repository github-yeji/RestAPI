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
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<style>
table {
	border: solid 1px;
	width: 1500px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
        var formObj = $("form[name='readForm']");
        
        $(".delete_btn").on("click",function(){
            formObj.attr("action", "/board/delete");
            formObj.attr('method', "post");
            formObj.submit();
        });
        
        function checkAlert(result){
        	if(result == "delete success"){
        		alert("삭제가 완료 되었습니다");
        	}
        }
        
})//document
</script>
<body>
    레시피번호 :
    <c:out value="${recipe_seq}" /><br>
    접속한 유저 번호 :
    <c:out value="${user_seq}" />
    <table>
        <tr>
            <th>레시피 번호</th>
            <th>레시피 이름</th>
            <th>간단 소개</th>
            <th>음식 분류</th>
        </tr>
        <c:forEach var="list" items="${list}" begin="0" end="0">
            <!-- 반복문 0번째부터 0번째 까지 -->
            <tr>
                <td>${list.recipe_seq}</td>
                <td>${list.recipe_nm}</td>
                <td>${list.recipe_sumry}</td>
                <td>${list.recipe_nation_nm}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <table>
        <tr>
            <th>요리 순서</th>
            <th>요리 설명</th>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.cooking_no}</td>
                <td>${list.cooking_dc}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/board/list/<c:out value="${user_seq}"/>"><button>돌아가기</button></a>
    <a href="/board/modify/<c:out value="${recipe_seq}"/>"><button>수정</button></a>
    <a href="/board/delete/<c:out value="${recipe_seq}"/>"><button type="button" class="delete_btn">삭제</button></a>
</body>
</html>