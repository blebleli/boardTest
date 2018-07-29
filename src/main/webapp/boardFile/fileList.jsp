<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="row">
	<form action="/boardFileUpload" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadFile"><br>
	<input type="submit" value="전송">
	</form>
</div>
