<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <p>삭제파일 : ${deleteFile}</p>
  <p>삭제상태 :
  		     <c:if test="${delResult==1}">파일삭제 성공</c:if> 
	         <c:if test="${delResult==0}">파일삭제 실패</c:if> 
	         <c:if test="${delResult==-1}">파일이 존재하지 않습니다</c:if>
   <p> 
  
</body>
</html>