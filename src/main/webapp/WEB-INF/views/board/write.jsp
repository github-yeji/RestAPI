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
        #writeTb{
            margin:0 auto;
            width: 1750px;
            text-align:left;
            text-indent:1em;
            border-top: 3px solid #BDBDBD;
            border-bottom: 3px solid #BDBDBD;
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
        .label1{
            margin-left:250px;
        }
        #buttons{
            margin: 0 auto;
            margin-top: 20px;
            width:1750px;
        }
        button{
            background:#585858; 
            color:white; font-weight:bold;
            border-radius:3px;
            width: 100px;
            height: 40px;
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
        input[type=text]{
            width:600px;
            font-size:20px;
        }
        input[type=radio]{
            zoom: 2;
        }
        textarea{
            resize:none;
            width:600px;
            height: 300px;
        }
    </style>
    <script>
    function checkForm() {
        var genreArray = new Array();

        $('input:radio[name=recipe_level]:checked').each(function() {
            genreArray.push(this.value);
        });
        $('input:radio[name=use_yn]:checked').each(function() {
            genreArray.push(this.value);
        });
        $('input:radio[name=recipe_nation_nm]:checked').each(function() {
            genreArray.push(this.value);
        });
        //other code
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
            <form role="form" method="post" action="/board/writting">
            <input type="hidden" id="user_seq" name="user_seq" value="${user_seq}">
                <table id="writeTb" style="margin-bottom:30px;">
                    <tbody>
                        <tr>
                            <td><label for="recipe_seq" class="label1" >레시피 번호</label></td>
                            <td><input type="text" id="recipe_seq" name="recipe_seq" /></td>
                        </tr>
                        <tr>
                            <td><label for="recipe_nm" class="label1">레시피 이름</label></td>
                            <td><input type="text" id="recipe_nm" name="recipe_nm" /></td>
                        </tr>   
                        <tr>
                            <td><label for="recipe_sumry" class="label1">레시피 소개</label></td>
                            <td><textarea id="text" name="recipe_sumry" ></textarea></td>
                        </tr>
                        <tr>
                            <td><label for="recipe_nation_nm" class="label1">요리 분류</label></td>
                            <td>
                                <label><input type="radio" name="recipe_nation_nm" id="recipe_nation_nm" value="한식" name="recipe_nation_nm">한식</label>
                                <label><input type="radio" name="recipe_nation_nm" id="recipe_nation_nm" value="중식" name="recipe_nation_nm" style="margin-left:10px">중식</label>
                                <label><input type="radio" name="recipe_nation_nm" id="recipe_nation_nm" value="일식" name="recipe_nation_nm" style="margin-left:10px">양식</label>
                                <label><input type="radio" name="recipe_nation_nm" id="recipe_nation_nm" value="양식" name="recipe_nation_nm" style="margin-left:10px">일식</label>
                                <label><input type="radio" name="recipe_nation_nm" id="recipe_nation_nm" value="기타" name="recipe_nation_nm" style="margin-left:10px">기타</label>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="irdnt_grp_code" class="label1">식재료 코드 ID</label></td>
                            <td><input type="text" id="irdnt_grp_code" name="irdnt_grp_code" /></td>
                        </tr>
                        <tr>
                            <td><label for="irdnt_code" class="label1">식재료 공통 분류 ID</label></td>
                            <td><input type="text" id="irdnt_code" name="irdnt_code" /></td>
                        </tr>
                        <tr>
                            <td><label for="recipe_cooking_time" class="label1">조리시간</label></td>
                            <td><input type="text" id="recipe_cooking_time" name="recipe_cooking_time" /></td>
                        </tr>
                        <tr>
                            <td><label for="recipe_qnt" class="label1">요리 분량</label></td>
                            <td><input type="text" id="recipe_qnt" name="recipe_qnt" /></td>
                        </tr>
                        <tr>
                            <td><label for="recipe_calorie" class="label1">칼로리</label></td>
                            <td><input type="text" id="recipe_calorie" name="recipe_calorie" /></td>
                        </tr>
                        <tr>
                            <td><label for="recipe_level" class="label1">요리 난이도</label></td>
                            <td>
                                <label><input type="radio" name="recipe_level" value="초급"  style="margin-left:10px">초급 </label>
                                <label><input type="radio" name="recipe_level" value="중급" style="margin-left:60px">중급 </label>
                                <label><input type="radio" name="recipe_level" value="고급" style="margin-left:60px">고급</label>
                            </td>
                        <tr>
                            <td><label for="recipe_img_url" class="label1">이미지</label></td>
                            <td><input type="text" id="recipe_img_url" name="recipe_img_url" /></td>
                        </tr>
                        <tr>
                            <td><label for="use_yn" class="label1">사용여부</label></td>
                            <td>
                                <label><input type="radio" name="use_yn" id="use_yn" value="Y" name="use_yn" style="margin-left:10px">예</label>
                                <label><input type="radio" name="use_yn" id="use_yn" value="N" name="use_yn" style="margin-left:70px">아니오</label>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="cretr_id" class="label1">작성자</label></td>
                            <td><input type="text" id="cretr_id" name="cretr_id" /></td>
                        </tr>
                    </tbody>
                </table>
                <button type="submit" style="float:right; margin-right:150px;">작성</button>
            </form>
            <!-- 디자인 끝 -->
            <a href="/board/list/<c:out value="${user_seq}"/>"><button style="float:left; margin-left:150px;">돌아가기</button></a>
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
