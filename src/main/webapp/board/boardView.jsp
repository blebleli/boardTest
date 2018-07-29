<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">
<style type="text/css">
table, th, td {
	margin: auto;
	text-align: center;
}
</style>
<script>



	$(document).ready(function() {

		/*		
		//게시판 수정 이벤트
		$("table tbody tr").on("click", function() {
			//tr태그의 data-id 속성값을 읽어서 input 태그의 id값으로 설정
			//form 태그를 submit
			$("#std_id").val($(this).data("id"));
			$("#testtesttesttest").submit();
		});
		*/
		/*
		$(".dropdown-menu li a").click(function(){
			  var selText = $(this).text();
			  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
			});
		*/
		
		//게시판 추가 이벤트
		$("#createBtn").on("click", function() {
			//학생 이름, 상세주소
			if ($("#cboardName").val().length < 2) {
				alert("게시판이름을 입력해주세요");
				$("#cboardName").focus();
				return false;
			}
			
			//console.log($("#createFrm").serialize());
			$("#createFrm").submit();
		});
		
		
		
		//게시판 추가 이벤트
		$("#updateBtn").on("click", function() {
			//학생 이름, 상세주소
			if ($("#uboardName").val().length < 2) {
				alert("게시판이름을 입력해주세요");
				$("#uboardName").focus();
				return false;
			}
			//console.log($("#createFrm").serialize());
			$("#updateFrm").submit();
		});
	});
	
</script>
</head>
<body>

	<!-- top -->
	<%@ include file="/common/top.jsp"%>

	<!-- <form id="frm" action="/boardCreate" method="post">
		<input type="hidden" name="b_id" id="b_id">
	</form> -->

	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form id="createFrm" action="/boardCreate" method="post"
					class="form-horizontal" role="form">

					<h2 class="sub-header">게시판 추가</h2>
					<div class="row-right">
						<div class="col-lg-6">
							<div class="input-group">
								<input id="cboardName" name="boardName" type="text"
									class="form-control" placeholder="게시판 이름을 입력하세요"><span
									class="input-group-btn"> <br>
									<button id="createBtn" class="btn btn-default" type="button">추가</button>
									<br>
								</span>
							</div>
							<!-- /input-group -->
						</div>
						<!-- /.col-lg-6 -->
					</div>
					<!-- /.row -->

				</form>

				<br>
				<hr>
				<br>

				<h2 class="sub-header">게시판 리스트</h2>

				<table class="table table-striped">
					<thead>
						<tr>
							<th>게시판ID</th>
							<th>게시판이름</th>
							<th>생성일자</th>
							<th>사용여부</th>
							<th>수정</th>
						</tr>
					</thead>
				</table>

				<ul class="list-group">

					<c:forEach items="${boardList}" var="vo">
						<li class="list-group-item">
							<form id="updateFrm" action="/boardUpdate" method="post"
								class="form-horizontal" role="form">
	
								<!--  items 루프할 대상-->
								<input type="hidden" name="b_id" value="${vo.b_id}">
								${vo.b_id} <input type="text" class="form-control col-lg-3"
									name="boardName" id="uboardName" value="${vo.b_name}">
								<fmt:formatDate value="${vo.b_regdt }" pattern="yyyy-MM-dd" />
	
								<select name="b_useny" class="form-control" id="sel1">
									<option <c:if test="${vo.b_useny eq 'Y'}">selected</c:if>>Y</option>
									<option <c:if test="${vo.b_useny eq 'N'}">selected</c:if>>N</option>
								</select>
	
								<button id="updateBtn" class="btn btn-default" type="submit">수정</button>
								<br>
							
							</form>
						</li>
					</c:forEach>
				</ul>
			</div>

		</div>
	</div>
	<!-- rows -->
</body>
</html>