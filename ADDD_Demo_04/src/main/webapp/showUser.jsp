<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>啊对对队——实验四(1)——${user.uname }</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/search.css" />
<script type="text/javascript" src="./js/vue.min.js"></script>
<script type="text/javascript" src="./js/searchShow.js"></script>
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<jsp:include page="nav.jsp">
		<jsp:param name="active" value="4" />
	</jsp:include>
	<div id="app">
		<div class="search">
			<div class="search-form-wrap">
				<c:if test="${!empty error}">
					<span class="search-error" style="color:${color }">${error }<br /></span>
				</c:if>
				<c:if test="${!empty user }">
					<div class="user-box">
						<h3 class="search-result-title">
							为您搜索到ID为 <span class="keyword-span">${user.uid }</span> 的用户：
						</h3>
						<div class="uid item">
							<span class="title">ID</span> <span class="value keyword-span">${user.uid }<br /></span>
						</div>
						<div class="uname item">
							<span class="title">姓名</span> <span class="value">${user.uname }<br /></span>
						</div>
						<div class="uage item">
							<span class="title">性别</span> <span class="value">${user.usex }<br /></span>
						</div>
						<div class="uphone item">
							<span class="title">手机号</span> <span class="value">${user.uphone }<br /></span>
						</div>
						<div class="uage item">
							<span class="title">年龄</span> <span class="value">${user.uage }<br /></span>
						</div>
						<div class="utime item">
							<span class="title">加入时间</span> <span class="value">${user.utime }<br /></span>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>