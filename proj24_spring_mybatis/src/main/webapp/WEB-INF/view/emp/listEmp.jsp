<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>listEmp.jsp</h1>
	${ msg }
	<hr>
	<table border=1>
      <thead>
         <tr>
            <th>empno</th>
            <th>ename</th>
            <th>sal</th>
            <th>job</th>
            <th>deptno</th>
         </tr>
      </thead>
      <tbody>
         <c:if test="${not empty list }">
            <c:forEach items="${ list }" var="dto">
               <tr>
                  <td>${ dto.empno }</td>
                  <td>${ dto.ename }</td>
                  <td>${ dto.sal }</td>
                  <td>${ dto.job }</td>
                  <td>${ dto.deptno }</td>
               </tr>
            </c:forEach>
         </c:if>
      </tbody>
   </table>

</body>
</html>