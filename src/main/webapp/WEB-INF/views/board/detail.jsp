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
            background:#F2F2F2
        }
        #recipeTb {
            margin: 0 auto;
            margin-top: 20px;
            border: solid 1px;
            width: 1500px;
            background-color: #FAFAFA;
        }
        img{
            width:100%;
            height:100%;
            border-radius:10px;
        }
        #recipeTb{
            text-align:left;
            text-indent:1.5em;
        }
        #buttons{
            margin-top: 20px;
            width:1500px;
        }
        button{
            background:#585858; 
            color:white; font-weight:bold;
            border-radius:3px;
            width: 100px;
            height: 40px;
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
                    Menu
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
                <a class="btn btn-primary btn-xl text-uppercase" href="/board/list/${user_seq}">추천 레시피</a>
            </div>
        </header>
        
        
        <div style="width:2000px; margin:0 auto; background:white; padding-top:50px; margin-bottom:50px;">
        <!-- Recipe (내용 띄울 부분) -->
        <section class="page-section" id="recipe" style="padding-bottom:800px">  <!-- 만약 버튼의 href를 #recipe로 해놨으면 여기로 이동 -->
            <div class="container">
                <!-- 레시피  설명문을 여기에 적자-->
                <div class="row text-center" style="width:1500px; height:400px; margin:0 auto;">
                    <div style="width:100%; height:100%; margin-bottom:50px;">
                        <div class="imgview" style="width:45%; height:100%; float:left;">
                            <c:forEach var="list" items="${list}" begin="0" end="0">
                                <img src="/showImage?name=${list.recipe_img_url}" alt="레시피사진"/>
                            </c:forEach>
                        </div>
                        <div style="width:45%; height:100%; float:right; text-align:left; padding-top:10px;">
                            <h2 class="section-heading text-uppercase"><c:forEach var="list" items="${list}" begin="0" end="0">${list.recipe_nm}</c:forEach></h2>
                            <h5 class="section-heading text-uppercase" style="color:#A4A4A4"><c:forEach var="list" items="${list}" begin="0" end="0">${list.recipe_sumry}</c:forEach></h5><br><br>
                            <h4> 주요재료  </h4>
                            <h5 style="color:#A4A4A4"><c:forEach var="irdnt" items="${irdnt}">${irdnt.cd_nm} &nbsp;</c:forEach></h5>
                        </tr>
                        </div>
                    </div>
                    <table id="recipeTb">
                        <tr>
                            <td style="padding-top:40px;">
                                <h2 style="display: inline; font-weight: bold">요리 방법-</h3>
                                <h4 style="display: inline; font-weight: bold"><c:forEach var="list" items="${list}" begin="0" end="0">${list.recipe_nm}</c:forEach></h4>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <c:forEach var="list" items="${list}">
                            <tr>
                                <td style="font-size:1.6em; padding-bottom:30px;">${list.cooking_no}. ${list.cooking_dc}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                    <div id="buttons">
                        <a href="/board/list/<c:out value="${user_seq}"/>"><button>돌아가기</button></a>
                        <a href="/board/cook/<c:out value="${user_seq}"/>/<c:out value="${recipe_seq}"/>" style="margin-left:1000px"><button>요리법 작성</button></a>
                        <a href="/board/modify/<c:out value="${user_seq}"/>/<c:out value="${recipe_seq}"/>" style="margin-left:30px"><button>수정</button></a>
                        <button type="button" class="delete_btn" style="margin-left:20px;">삭제</button>
                    </div>
                </div>
            </div>
        </section>
        
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
