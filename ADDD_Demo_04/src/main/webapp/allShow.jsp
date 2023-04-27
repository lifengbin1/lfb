<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%@page import="model.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/insert.css" />
<script type="text/javascript" src="./js/vue.min.js"></script>
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<jsp:include page="nav.jsp">
		<jsp:param name="active" value="5" />
	</jsp:include>
	<div id="allShow">
		<%
		List<User> users = Model.getAllUsers();
		request.setAttribute("size", users.size());
		%>
		<div id="excel-data" class="file-result-wrap show-excel-table">
			<ul class="users-ul">
				<li class="user-title-li"><span class="user-title-span">ID</span>
					<span class="user-title-span">NAME</span> <span
					class="user-title-span">PHONE</span> <span class="user-title-span">SEX</span>
					<span class="user-title-span">AGE</span> <span
					class="user-title-span">TIME</span></li>
				<%
				if (users.size() > 0) {

					for (int i = 0; i < users.size(); i++) {
				%>

				<li class="user-item-li"><span class="user-item-span"><%=users.get(i).getUid()%></span>
					<span class="user-item-span"><%=users.get(i).getUname()%></span> <span
					class="user-item-span"><%=users.get(i).getUphone()%></span> <span
					class="user-item-span"><%=users.get(i).getUsex()%></span> <span
					class="user-item-span"><%=users.get(i).getUage()%></span> <span
					class="user-item-span"><%=users.get(i).getUtime()%></span></li>
				<%
				}

				}else{
					
				%>
					<li class="user-item-li">
					   <span class="user-item-span null">空</span>
					</li>
				<%} %>
			</ul>
		</div>
	</div>
</body>
</html>