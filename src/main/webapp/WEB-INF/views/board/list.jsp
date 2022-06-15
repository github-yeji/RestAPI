<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 목록</title>
<style>
        #wrap{
            width:1000px;
            height:200px;
            margin-left:auto;
            margin-right:auto;
            text-align:center;
        }
    
        table{
            margin-left:50px;
            font-size:20px;
            border:10;
            
        }
    
        td{
            border:10;
            height:40px;
        }
    
        #title{
            background-color:white
        }
        body{
            margin: 0 auto;
            width: 1500px;
        }
        #listTb{
            width: 1500px;
        }
    </style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
    <input type="hidden" id="user_seq" name="user_seq" value="${user_seq}">
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
  
<img src="/resources/images/2.jpg" width="1200" height="500" alt="home사진" style="margin-left:50px; margin-top:20px;"/><br>
<img src="/resources/images/main.png" width="1200" height="500" alt="main사진" style="margin-left:50px;"/><br>
<table id="listTb">
    <tr>
        <th>번호</th>
        <th>레시피 이름</th>
        <th>간단 소개</th>
        <th>음식 분류</th>
    </tr>
    <c:forEach var="list" items="${list}">

    <tr>
        <td style="text-align:center;"><a href="/board/detail/<c:out value="${list.user_seq}"/>/<c:out value="${list.recipe_seq}"/>">${list.recipe_seq}</a></td>
        <td><a href="/board/detail/<c:out value="${list.user_seq}"/>/<c:out value="${list.recipe_seq}"/>">${list.recipe_nm}</a></td>
        <td><a href="/board/detail/<c:out value="${list.user_seq}"/>/<c:out value="${list.recipe_seq}"/>">${list.recipe_sumry}</a></td>
        <td style="text-align:center">${list.recipe_nation_nm}</td>
    </tr>
    </c:forEach>
</table>
    <a href="/board/write"><button>글 작성</button></a>
</body>
</html>