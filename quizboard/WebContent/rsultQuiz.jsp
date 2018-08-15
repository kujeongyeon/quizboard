<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quiz.service.*" %>
<%@ page import="etc.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
 	Space del = new Space();
	int quizId = Integer.parseInt(request.getParameter("quizId"));
	String answer = request.getParameter("answer");
	answer = del.delSpace(answer);
	boolean invalidAnswer = false;
	try {
		RsultQuizService rusultService = RsultQuizService.getInstance();
		rusultService.rsult(quizId, answer);
	} catch (InvalidException ex){
		invalidAnswer = true;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(!invalidAnswer) { %>
답변이 맞았습니다!
<% }else{ %>
답변이 틀렸습니다~~~
<% } %>
<br/>
<a href="list.jsp">[목록 보기]</a>

</body>
</html>