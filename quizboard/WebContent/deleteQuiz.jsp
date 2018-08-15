<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quiz.service.DeleteQuizService" %>
<%@ page import="quiz.service.InvalidException" %>

<%
	int quizId = Integer.parseInt(request.getParameter("quizId"));
	String password = request.getParameter("password");
	boolean invalidPassword = false;
	
	try{
		DeleteQuizService deleteService = DeleteQuizService.getInstance();
		deleteService.delete(quizId, password);
	}catch(InvalidException ex){
		invalidPassword = true;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>퀴즈 삭제</title>
</head>
<body>
<% if(!invalidPassword) { %>
퀴즈를 삭제하였습니다
<%}else{ %>
입력한 암호가 올바르지 않습니다
<% } %>
<br/>
<a href="list.jsp">[목록 보기]</a>
</body>
</html>