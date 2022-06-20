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
<title>BabJo HomePage</title>
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
    <script type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script language="JavaScript" type="text/javascript">
function logout(){
    
    window.location.href = "/logout.do";
}

function reqAjax2() {
    var user_email = document.getElementById("user_email").value;
    var user_pwd = document.getElementById("user_pwd").value;
    var afterlg="";
    console.log("확인" + user_email);
    if(user_email.trim() =='' || user_pwd.trim()==''){
        alert('아이디와 비밀번호를 입력해주세요')
        return;}
    //서버로 보낼 데이터 준비 : 파라미터로 만들기 . json 으로 만들기
    var sendData = {"user_email":user_email,"user_pwd":user_pwd}
    $.ajax({
        url:($("#contextPath").val() + "/users/login2")
        , method : 'GET'
        , data: sendData
        ,contentType : 'application/json; charset=UTF-8'
        ,dataType : 'json'
        , success :function(resp){
            alert("로그인 성공")
            //$("#afterLogin").css('display', 'none');
            $("#afterLogin").empty();
            var msg = "<span style='margin-left:50px;'>${user_nm}님 환영합니다.</span>";
            var logout_btn = "<button type='button' type='submit' onclick='logout()' style='margin-left:50px'>로그아웃</button>";
            $('#afterLogin').append(msg);
            $('#afterLogin').append(logout_btn);
            
           
        }, error: function(XMLHttpRequest, textStatus, errorThrown){
            alert("아이디와 비밀번호를 확인해주세요.")
        }
    })  
}
</script>
<style>
    body{
        background:#F2F2F2;
    }
    img{
        width:100%;
        height:100%;
        border-radius:10px;
    }
    td{
        padding: 20px 0px 20px 20px;
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
<body id="page-top" style="background:#F2F2F2">
    <!-- 파라미터를 넘기기 위한 input hidden -->
    <input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
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
            <a class="btn btn-primary btn-xl text-uppercase" href="/board/list/${user_seq}" style="color: #fff; background:#ffc800; border-color: #ffc800;">추천 레시피</a> <!-- 클릭 시 해당페이지의 id가 #recipe인 부분으로 이동 -->
        </div>
    </header>
    
    
    <div style="width:2000px; height:800px; margin:0 auto; background:white; padding-top:50px; padding-bottom:50px;">
    <!-- Recipe (내용 띄울 부분) -->
    <div id="afterLogin" style="float:left;  width:30%;">
    <form name="LoginForm" id="LoginForm" method="get" action="">
    <table style="margin-left:50px; width:600px; border:1px solid;">
        <tr>
            <td id="title">이메일</td>
            <td><input type="text" name="user_email" id="user_email"  maxlength="20"></td>
        </tr>
        <tr>
            <td id="title">비밀번호</td>
            <td><input type="password" name="user_pwd" id="user_pwd" maxlength="64"></td>
        </tr>
        <tr>
            <td>
                <button type="button" onclick="reqAjax2()">로그인</button>
            <td>
            <button type="button" onclick="location.href='/join.do'" style="width:120px;">회원가입</button>
        </tr>
    </table>
    </form>
    </div>
    <div style=" float:right; width:70%">
        <img src="/images/main.png" alt="main사진" style="margin: 0px 0px 0px 100px; width:1200px; height:400px; border:1px solid"/>
    </div>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
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
