<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "quiz.dao.GameDao" %>
<%@ page import = "quiz.model.Game" %>
<%@ page import = "quiz.service.*" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String pageNumberStr = request.getParameter("page");
	int pageNumber = 1;
	if(pageNumberStr != null){
		pageNumber = Integer.parseInt(pageNumberStr);
	}
	
	GetQuizListService gameListService = GetQuizListService.getInstance();
    QuizListView viewData = gameListService.getQuizList(pageNumber);
%>
<c:set var="viewData" value="<%=viewData %>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>퀴즈 목록</title>
</head>
<body>
<form action="writeQuiz.jsp" method="post">
퀴즈 : <textarea name="quiz" cols="30" rows="3"></textarea><br>
답 : <input type="text" name="answer"><br>
비밀번호 : <input type="text" name="password">
<input type="submit" value="퀴즈만들기"/>
</form>
<hr>
<c:if test="${viewData.isEmpty()}">
등록된 퀴즈가 없습니다.
</c:if>

<c:if test="${!viewData.isEmpty()}">
<table border="1">
<tr>
	<th>퀴즈 번호</th>
	<th>내용</th>
	<th>퀴즈 풀기</th>
	<th>삭제</th>
</tr>
<c:forEach var="quiz" items="${viewData.gameList}">
<tr>
	<td>${quiz.id}</td>
	<td>${quiz.quiz}</td>
	<td><a href="confirmAnswer.jsp?quizId=${quiz.id}">[답변등록]</a></td>
	<td><a href="confirmDeletion.jsp?quizId=${quiz.id}">[삭제하기]</a></td>
</tr>
</c:forEach>
</table>

<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount}">
<a href="list.jsp?page=${pageNum}">[${pageNum}]</a>
</c:forEach>
</c:if>
</body>
</html>