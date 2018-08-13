<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quiz.dao.GameDao" %>
<%@ page import="quiz.service.*" %>
<%@ page import="quiz.model.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="quiz" class="quiz.model.Game">
	<jsp:setProperty name="quiz" property="*"/>
</jsp:useBean>
<%
	WriteQuizSerivce writeService = WriteQuizSerivce.getInstance();
	writeService.write(quiz);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>퀴즈 등록</title>
</head>
<body>
퀴즈를 등록 했습니다
<br/>
<a href="list.jsp">[목록보기]</a>
</body>
</html>