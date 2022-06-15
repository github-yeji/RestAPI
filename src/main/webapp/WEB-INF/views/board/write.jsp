<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>글 작성</title>
    </head>
    <body>
<input type="hidden" id="user_seq" name="user_seq" value="${user_seq}">
        <div id="root">
            <header>
                <h1> 게시판</h1>
            </header>
            <hr />
             
            <nav>
              <p>홈 - 글 작성${user_seq}</p>
            </nav>
            <hr />
            
            <section id="container">
                <form role="form" method="post" action="/board/writting">
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <label for="recipe_seq">레시피 번호</label><input type="text" id="recipe_seq" name="recipe_seq" />
                                </td>
                            </tr>  
                            <tr>
                                <td>
                                    <label for="recipe_nm">레시피 이름</label><input type="text" id="recipe_nm" name="recipe_nm" />
                                </td>
                            </tr>   
                            <tr>
                                <td>
                                    <label for="recipe_sumry">레시피 소개</label><textarea id="text" name="recipe_sumry" ></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="recipe_nation_nm">요리 분류</label><input type="text" id="recipe_nation_nm" name="recipe_nation_nm" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="irdnt_grp_code">식재료 코드 ID</label><input type="text" id="irdnt_grp_code" name="irdnt_grp_code" />
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
                                <td>
                                    <label for="recipe_img_url">이미지</label><input type="text" id="recipe_img_url" name="recipe_img_url" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="use_yn">사용여부</label><input type="text" id="use_yn" name="use_yn" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="cretr_id">작성자</label><input type="text" id="cretr_id" name="cretr_id" />
                                </td>
                            </tr>
                            <tr>
                                <td>                        
                                    <button type="submit">작성</button>
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