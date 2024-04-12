<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table border="1">
      <thead>
         <tr>
            <th>empno</th>
            <th>ename</th>
            <th>sal</th>
         </tr>
      </thead>
      <tbody>
         <c:if test="${ not empty list }">
            <c:forEach var="emp" items="${ list }">
            <tr>
               <td>${ emp.empno }</td>
               <td>${ emp.ename }</td>
               <td>${ emp.sal }</td>
            </tr>
            </c:forEach>
         </c:if>
         <c:if test="${ empty list }">
            <tr><td colspan="3">결과없</td></tr>
         </c:if>
      </tbody>
   </table>
</body>
</html>