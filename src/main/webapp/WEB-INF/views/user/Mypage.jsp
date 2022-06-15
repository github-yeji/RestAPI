<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%--
<%@ page import="jsp.member.model.MemberBean" %> 
<%@ page import="jsp.member.model.MemberDAO" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="EUC-KR">
<title>BabJo MyPage</title>

<style>
		#wrap{
			width:1000px;
			height:200px;
			margin-left:200px;			
			text-align:center;
		}
	
		table{
			margin-left:auto;
			margin-right:auto;
			font-size:25px;
			border:10;
			
		}
	
		td{
			border:10;
			height:70px;
		}
	
		#title{
			background-color:white
		}
	</style>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-expand-xl navbar-dark bg-white" aria-label="Sixth navbar example">
    <div class="container-fluid">
      <a class="navbar-brand" href="intro.jsp" style="font-size:70px; font-weight:bold; color:#FFA500; margin-left:50px;">BabJo</a>
      <button class="navbar-toggler" type="button"  data-bs-toggle="collapse" data-bs-target="#navbarsExample06" aria-controls="navbarsExample06" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample06">
        <ul class="navbar-nav me-auto mb-2 mb-xl-0">
          <li class="nav-item">
            <a class="nav-link" href="intro.jsp" style="font-size:25px; font-weight:bold; color:#000000; margin-left: 100px;" >     소개</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Myref.jsp" style="font-size:25px; font-weight:bold; color:#000000; margin-left: 200px;">     내 냉장고</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Recipe.jsp" style="font-size:25px; font-weight:bold; color:#000000; margin-left: 200px;">     추천레시피</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Mypage.jsp" style="font-size:25px; font-weight:bold; color:#000000; margin-left: 200px;">     마이페이지</a>
          </li>
          
        </ul>
       
      </div>
    </div>
  </nav>
  
	<%
 	request.setCharacterEncoding("euc-kr");
 	%>
 	
 	<%-- 자바빈 관련 액션태그 사용 --%>    
<%--  	<jsp:useBean id="memberBean" class="jsp.member.model.MemberBean"/>
 	<jsp:setProperty property="*" name="memberBean"/> --%>
 	
 	<%/* 
 		MemberDAO dao = MemberDAO.getInstance();
 		dao.insertMember(memberBean); */
 	%>
 	
	<div id="wrap">
		<br>        
			<font style="font-size:50px; color:#1C79E8; font-weight:bold;margin-left:150px;" >나의 정보 </font>			
		<br>
	<%-- 	 	<font style="font-size:20px; color:black; margin-left:200px;" ><%=memberBean.getName()%>님 가입을 축하드립니다.</font>  --%>
			<br>
			<font style="font-size:20px; color:black; margin-left:200px;" >고객님께서 가입하신 BabJo 회원 정보입니다.</font>
			<br>
			<font style="font-size:20px; color:black; margin-left:200px;" >정확하고 알맞은 레시피 추천을 위해 확인부탁드립니다. </font>
		<br>
		 
		 <table>
		 <form action="" method="get">
 				<tr>
					<td id="title">이메일</td>
					<td><%=memberBean.getId() %></td>
				</tr>
				
				<tr>
					<td id="title">이름</td>
					<td><%=memberBean.getName() %></td>
				</tr>
				
				<tr>
				
					<td id="title">나이</td>
					<td><%=memberBean.getAge() %></td>
				</tr>
				
				<tr>
				
					<td id="title">성별</td>
					<td><%=memberBean.getGender() %></td>
				</tr>
				</form>
			</table>       
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</div>
</body>
</html>