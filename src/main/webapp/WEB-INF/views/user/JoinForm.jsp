<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<html>
<head>
	<title>BabJo Join</title>
	
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
	<script type="text/javascript">
	
		function checkValue()
		{
			if(!document.userInfo.user_email.value){
				alert("아이디를 입력하세요.");
				return flase;
			}
			if(!document.userInfo.user_pwd.value){
				alert("비밀번호를 입력하세요.");
				return flase;
			}
			/* if(!document.userInfo.user_pwd.value != document.userInfo.passwordcheck.value){
				alert("비밀번호를 동일하게 입력하세요.");
				return flase;
			} */
			document.userInfo.action = '<c:url value="/users/join"/>';
			document.userInfo.submit();
		}
	</script>
</head>
<body>    

<nav class="navbar navbar-expand-xl navbar-dark bg-white" aria-label="Sixth navbar example">
    <div class="container-fluid">
      <a class="navbar-brand" href="intro.jsp" style="font-size:70px; font-weight:bold; color:#FFA500; margin-left:50px;">BabJo</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample06" aria-controls="navbarsExample06" aria-expanded="false" aria-label="Toggle navigation">
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
  
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  
	<div id="wrap">
		<br>        
		<b><font size="50px" color="#1C79E8" >회 원 가 입 </font></b>				
		<br>  
		<c><font style="font:itlaic bold; color:black; font-size:20px;">BabJo에 오신 걸 환영합니다. </font></c>
		<br>
		<c><font style="font:itlaic bold; color:black; font-size:20px;">회원가입에 필요한 정보들을 정확히 입력해주세요.</font></c>
		<br>
		
 <form method="post" action="/WEB-INF/views/board/Mypage.jsp" id="userInfo" name="userInfo" submit="return checkValue()">
     <!-- <form action="checkValue()" method="post" id="join"> -->
			<table>
				<tr>
					<td id="title">이메일</td>
					<td>                        
						<input type="text" id="user_email" name="user_email" maxlength="20">
						<input type="button" value="중복확인" >
					</td>
				</tr>
				
				<tr>
					<td id="title">비밀번호</td>
					<td>                        
						<input type="password" id="user_pwd"name="user_pwd" maxlength="64">                    
					</td>
				</tr>
				
				<tr>
				<td id="title">비밀번호 확인</td>
					<td>                        
					<input type="password" name="passwordcheck" maxlength="64">                   
					</td>
				</tr>
				
				<tr>
				
					<td id="title">이름</td>
						<td>                        
							<input type="text" id="user_nm"name="user_nm" maxlength="16">                    
						</td>
				</tr>
				
				<tr>
				
					<td id="title">나이</td>
						<td>                        
							<input type="text" id="user_age"name="user_age" maxlength="3">                    
						</td>
				</tr>
				
				<tr>
				
					<td id="title">성별</td>
						<td>                        
						<input type="radio" id="user_sex" name="user_sex" value="M" checked>남                        
						<input type="radio" id="user_sex"name="user_sex" value="F" checked>여                    
						</td>
						
				</tr>
			</table>           
			<br>            
			<button class="w-70 btn btn-lg btn-primary" type="submit" onclick="checkValue()">회원가입 완료</button>        
		</form>    
	</div>
</body>
</html>