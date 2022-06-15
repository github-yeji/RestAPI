<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 수정</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<style>
table {
	border: solid 1px;
	width: 1500px;
}
</style>
<script text="text/javascript">
    $(document).ready(function(){
    	var formObj = $("form[name='readForm']");
    	
    	//수정
    	$(".modify_btn").on("click", function(){
    		//formObj.attr("action", "/board/modify");
    		formObj.attr("method", "get");
    		formObj.submit();
    		history.back(-2);
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
    <body>
    
        <div id="root">
            <header>
                <h1> 게시판</h1>
            </header>
            <hr />
             
            <nav>
              <p>홈 - 글 수정</p>
            </nav>
            <hr />
            
            <section id="container">
                <form role="form" method="post" action="/board/modify">
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <label for="recipe_seq">레시피 번호</label><input type="text" id="recipe_seq" name="recipe_seq" placeholder="${recipe_seq}"/>
                                </td>
                            </tr>  
                            <tr>
                                <td>
                                    <label for="cooking_no">요리 순서</label><input type="text" id="cooking_no" name="cooking_no"/>
                                </td>
                            </tr>   
                            <tr>
                                <td>
                                    <label for="recipe_nm">레시피 이름</label><textarea id="text" name="recipe_nm"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_sumry">레시피 소개</label><input type="text" id="recipe_sumry" name="recipe_sumry" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_nation_nm">요리 분류</label><input type="text" id="recipe_nation_nm" name="recipe_nation_nm" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="irdnt_code">식재료 공통 분류 ID</label><input type="text" id="irdnt_code" name="irdnt_code" />
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
            <hr />
        </div>
    </body>
</html>