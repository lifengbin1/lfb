<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${msg }</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/insert.css" />
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<jsp:include page="nav.jsp">
		<jsp:param name="active" value="3" />
	</jsp:include>
	<div id="updateShow">
		<div class="msg-wrap show">
			<h3 class="msg" style="color: ${color };">${msg }</h3>
		</div>
		<c:if test="${!empty originalUser }">
			<div id="excel-data" class="file-result-wrap show-excel-table">
				<ul class="users-ul">
					<li class="user-title-li"><span class="user-title-span">ID</span>
						<span class="user-title-span">NAME</span> <span
						class="user-title-span">PHONE</span> <span class="user-title-span">SEX</span>
						<span class="user-title-span">AGE</span> <span
						class="user-title-span">TIME</span></li>
					<li class="user-item-li"><span class="user-item-span">${originalUser.uid }</span>
						<span class="user-item-span">${originalUser.uname }</span> <span
						class="user-item-span">${originalUser.uphone }</span> <span
						class="user-item-span">${originalUser.usex }</span> <span
						class="user-item-span">${originalUser.uage }</span> <span
						class="user-item-span">${originalUser.utime }</span></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${!empty updatedUser }">
			<div class="updated-user">
				更改后⬇
			</div>
			<div id="excel-data" class="file-result-wrap show-excel-table">
				<ul class="users-ul">
					<li class="user-title-li"><span class="user-title-span">ID</span>
						<span class="user-title-span">NAME</span> <span
						class="user-title-span">PHONE</span> <span class="user-title-span">SEX</span>
						<span class="user-title-span">AGE</span> <span
						class="user-title-span">TIME</span></li>
					<li class="user-item-li"><span class="user-item-span">${updatedUser.uid }</span>
						<span class="user-item-span">${updatedUser.uname }</span> <span
						class="user-item-span">${updatedUser.uphone }</span> <span
						class="user-item-span">${updatedUser.usex }</span> <span
						class="user-item-span">${updatedUser.uage }</span> <span
						class="user-item-span">${updatedUser.utime }</span></li>
				</ul>
			</div>
		</c:if>
	</div>
</body>
</html>