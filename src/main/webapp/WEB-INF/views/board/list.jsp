<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>레시피 정보</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/resources/css/styles.css" rel="stylesheet" /> <!-- style.css 위치, 메인 이미지 경로는 header.masthead를 검색하여 설정 -->
    </head>
    <style>
        body{
            background:#F2F2F2;
        }
        img{
            width:100%;
            height:100%;
            border-radius:10px;
        }
        #listTb{
            margin:0 auto;
            width: 1750px;
            text-align:left;
            text-indent:1em;
        }
        th{
            padding: 30px 0px 30px 0px;
            font-size : 2em;
            border-bottom: 3px solid #BDBDBD;
        }
        td{
            padding: 20px 0px 20px 0px;
            font-size : 1.5em;
        }
        #buttons{
            margin: 0 auto;
            margin-top: 20px;
            width:2000px;
        }
        #buttons{
            margin-top: 50px;
            width:1800px;
            padding-bottom: 150px;
        }
        button{
            background:#585858; 
            color:white; font-weight:bold;
            border-radius:3px;
            width: 100px;
            height: 40px;
            margin-left: 1650px;
        }
        a{ 
            text-decoration: none;
            display:block;
            color: black;
        }
        a:visited{
            text-decoration: none;
        }
        a:hover{
            text-decoration: none;
        }
        a:focus{
            text-decoration: none;
        }
        a:hover, a:active {
            text-decoration: none;
        }
    </style>
    <body id="page-top">
        <!-- 파라미터를 넘기기 위한 input hidden -->
        <input type="hidden" id="user_seq" name="user_seq" value="${user_seq}">
        <input type="hidden" id="recipe_seq" name="recipe_seq" value="${recipe_seq}">
        <input type="hidden" id="use_yn" name="use_yn" value="${use_yn}">
        
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="/board/intro"><p>Bab jo</p></a> <!-- 로고 이미지 부분 -->
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link" href="/board/intro">소개</a></li>
                        <li class="nav-item"><a class="nav-link" href="#refri">내 냉장고</a></li>
                        <li class="nav-item"><a class="nav-link" href="/board/list/${user_seq}">추천 레시피</a></li>
                        <li class="nav-item"><a class="nav-link" href="/mypage.do">마이페이지</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead" style="margin-bottom:30px;">
            <div class="container">
                <div class="masthead-subheading" style="text-shadow: 2px 1px 0 #6E6E6E;">Welcome To Our babjo!</div>
                <div class="masthead-heading text-uppercase" style="text-shadow: 3px 2px 0 #6E6E6E;">오늘 뭐 먹지?</div>
                <a class="btn btn-primary btn-xl text-uppercase" href="/board/list/${user_seq}">추천 레시피</a> <!-- 클릭 시 해당페이지의 id가 #recipe인 부분으로 이동 -->
            </div>
        </header>
        
        
        <div style="width:2000px; margin:0 auto; background:white; padding-top:50px;">
        <!-- Recipe (내용 띄울 부분) -->
        <table id="listTb">
            <tr>
                <th style="text-align:center">&nbsp; 번호 &nbsp;</th>
                <th>레시피 이름</th>
                <th>간단 소개</th>
                <th style="text-align:center;">음식 분류</th>
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
        <div id="buttons">
            <a href="/board/write/<c:out value="${user_seq}"/>"><button>글 작성</button></a>
        </div>
        <!-- 내용 띄울 부분 끝 -->
        </div>
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
