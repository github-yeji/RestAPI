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
        #joinTb{
            margin:0 auto;
            width: 1750px;
            text-align:left;
            text-indent:1em;
            border-top: 3px solid #BDBDBD;
            border-bottom: 3px solid #BDBDBD;
        }
        td{
            padding: 20px 0px 20px 300px;
            font-size : 1.5em;
        }
        button{
            background:#585858; 
            color:white; 
            font-weight:bold;
            border-radius:3px;
            width: 100px;
            height:50px;
        }
        input[type=text]{
            width:400px;
            font-size:20px;
        }
        input[type=password]{
            width:400px;
            font-size:20px;
        }
        input[type=radio]{
            zoom: 2;
        }
    </style>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
    crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script language="JavaScript" type="text/javascript">
    function memberJoin() {
        if (!document.userInfo.user_email.value) {
            alert("아이디를 입력하세요.");
            return false;
        }
        if (!document.userInfo.user_pwd.value) {
            alert("비밀번호를 입력하세요.");
            return false;
        }

        var user_email = document.getElementById("user_email").value;
        var user_pwd = document.getElementById("user_pwd").value;
        var user_nm = document.getElementById("user_nm").value;
        var user_age = document.getElementById("user_age").value;
        var user_sex = document.querySelector('input[name="user_sex"]:checked').value;

        var param = new Object();
        param.user_email = user_email;
        param.user_pwd = user_pwd;
        param.user_nm = user_nm;
        param.user_age = user_age;
        param.user_sex = user_sex;
        
        var jsonObj = JSON.stringify(param);
        console.log("jsonObj :" + jsonObj);

        $.ajax({
            url : ($("#contextPath").val() + "/users/join"),
            type : 'POST',
            data : JSON.stringify(param),
            contentType : 'application/json; charset=UTF-8',
            dataType : 'text',
            success : function(resp) {
                if (resp) {
                    alert("가입이 완료되었습니다.");
                    location.href = "/login2.do";
                } else {
                    alert("전송된 값 없음");
                }
            },
            error : function(request, status, error) {
                alert("code:" + request.status + "\nmessage:"
                        + request.responseText + "\nerror:" + error);
            }
        });
    }
</script>
    <body id="page-top">
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
        
        
        <div style="width:2000px; margin:0 auto; padding-bottom:100px; background:white; padding-top:50px;">
            <!-- Recipe (내용 띄울 부분) -->
            <form method="post" id="userInfo" name="userInfo" style="display:inline">
            <input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
            <div style="text-align:center; margin-bottom: 10px;">
                <b><font size="50px">회원가입 </font></b><br><br>
                <c><font style="font: itlaic bold; color: #C8C6C6; font-size: 20px;">BabJo에 오신 걸 환영합니다.</font></c><br>
                <c><font style="font: itlaic bold; color: #C8C6C6; font-size: 20px;">회원가입에 필요한 정보들을 정확히 입력해주세요.</font></c><br>
            </div>
             <!-- <form action="checkValue()" method="post" id="join"> -->
            <table id="joinTb" style="margin-bottom:30px;">
                <tr>
                    <td id="title">이메일</td>
                    <td>
                        <input type="text" id="user_email" name="user_email" maxlength="20">
                        <input type="button" value="중복확인">
                    </td>
                </tr>
                <tr>
                    <td id="title">비밀번호</td>
                    <td>
                        <input type="password" id="user_pwd" name="user_pwd" maxlength="64">
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
                        <input type="text" id="user_nm" name="user_nm" maxlength="16">                    
                    </td>
                </tr>
                <tr>
                    <td id="title">나이</td>
                    <td>
                        <input type="text" id="user_age" name="user_age" maxlength="3">                    
                    </td>
                </tr>
                <tr>
                    <td id="title">성별</td>
                    <td>
                        <input type="radio" id="user_sex1" name="user_sex" value="M" checked>남
                        <input type="radio" id="user_sex2" name="user_sex" value="F">여
                    </td>
                </tr>
            </table>
            <br>
                <button type="button" class="w-70 btn btn-lg btn-primary" onclick="memberJoin()" style="width:160px; margin-left:800px;">회원가입 완료</button>
            </form>
            <!-- 디자인 끝 -->
            <a href="/board/intro"><button style="margin-left:20px;">돌아가기</button></a>
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
