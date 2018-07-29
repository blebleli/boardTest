<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="/studentList?page=1&pageSize=10">학생</a></li>
		<li class="active"><a href="/boardView">게시판 편집</a></li>			  
    	<c:forEach items="${boardList }" var="item" varStatus="i">	    	
	   		<c:if test="${item.b_useny eq 'Y'}">
	   		 <li>
	   		 	<a href="/writeView?b_id=${item.b_id}&page=1&pageSize=10">
				<c:out value="${item.b_name}" />
				</a>
			</li>
			</c:if>	        
		</c:forEach>	
  
	</ul>
</div>