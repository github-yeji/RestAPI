<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 수정</title>
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
    </style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script text="text/javascript">
    $(document).ready(function(){
        var formObj = $("form[name='readForm']");
        
        //수정
        $(".modify_btn").on("click", function(){
            //formObj.attr("action", "/board/modify");
            formObj.attr("method", "get");
            formObj.submit();
            //history.back(-2);
        })
        
        //삭제
        $(".delete_btn").on("click", function(){
            formObj.attr("action", "/board/delete");
            formObj.attr("method", "post");
            formObj.submit();
        })
        
        //취소
        $(".cancel_btn").on("click", function(){
            //location.href = "/board/detail/<c:out value='${user_seq}'/>/<c:out value='${recipe_seq}'/>";
            //user_seq를 받아올 수 있으면 어떻게 될거 같은데...
            history.back(-1);
        })
        
    })//document
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
  
<img src="/resources/images/2.jpg" width="1200" height="500" alt="home사진" style="margin-left:50px; margin-top:20px;"/><br>
<img src="/resources/images/main.png" width="1200" height="500" alt="main사진" style="margin-left:50px;"/><br>
<table>
<section id="container">
                <form role="form" method="post" action="/board/modify">
                <input type="hidden" id="user_seq" name="user_seq" value="${user_seq}">
                    <table>
                        <tbody>
                            <tr>
                                <td> 유저 번호 : ${user_seq}</td>
                            <tr>
                            <tr>
                                <td>
                                    <label for="recipe_seq">레시피 번호&nbsp&nbsp&nbsp&nbsp</label><input type="text" id="recipe_seq" name="recipe_seq" placeholder="${recipe_seq}"/>
                                </td>
                            </tr>  
                            <tr>
                                <td>
                                    <label for="cooking_no">요리 순서</label><input type="text" id="cooking_no" name="cooking_no"/>
                                </td>
                            </tr>   
                            <tr>
                                <td>
                                    <label for="recipe_nm">레시피 이름</label><input type="text" id="recipe_nm" name="recipe_nm" placeholder="${recipe.recipe_nm}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_sumry">레시피 소개</label><input type="text" id="recipe_sumry" name="recipe_sumry" placeholder="${recipe.recipe_sumry}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_nation_nm">요리 분류&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label><input type="text" id="recipe_nation_nm" name="recipe_nation_nm" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="irdnt_code">식재료 공통 분류 ID &nbsp</label><input type="text" id="irdnt_code" name="irdnt_code" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_cooking_time">조리시간</label><input type="text" id="recipe_cooking_time" name="recipe_cooking_time" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_qnt">요리 분량</label><input type="text" id="recipe_qnt" name="recipe_qnt" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_calorie">칼로리</label><input type="text" id="recipe_calorie" name="recipe_calorie" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_level">요리 난이도</label><input type="text" id="recipe_level" name="recipe_level" />
                                </td>
                            </tr>
                            <tr>
                            <tr>
                                <td>
                                    <label for="cooking_dc">요리법 설명</label><input type="text" id="cooking_dc" name="cooking_dc" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_img_url">대표 이미지</label><input type="text" id="recipe_img_url" name="recipe_img_url" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="step_img_url">요리법 이미지</label><input type="text" id="step_img_url" name="step_img_url" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="admr_id">수정자 ID</label><input type="text" id="admr_id" name="admr_id" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="step_tip">요리 팁</label><input type="text" id="step_tip" name="step_tip" />
                                </td>
                            </tr>
                            <tr>
                                <td>                        
                                    <button type="submit" class="modify_btn">수정하기</button>
                                    <button type="button" class="cancel_btn">취소</button>
                                </td>
                            </tr>           
                        </tbody>            
                    </table>
                </form>
            </section>
</table>
  
</body>
</html>