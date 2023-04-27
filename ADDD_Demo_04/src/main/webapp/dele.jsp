<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>啊对对队——实验四(1)——删除</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/dele.css" />
<script type="text/javascript" src="./js/vue.min.js"></script>
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<jsp:include page="nav.jsp">
		<jsp:param name="active" value="2" />
	</jsp:include>
	<div id="dele">
		<form id="dele-form"
			action="${pageContext.request.contextPath }/deleByIDServlet"
			method="GET">
			<div class="input-wrap">
				<c:if test="${!empty user }">
					<input id="input" class="input" value="${user.uid }" type="text"
						name="uid" required autocomplete="off" />
				</c:if>
				<c:if test="${empty user }">
					<input id="input" class="input" type="text" name="uid" required
						autocomplete="off" />
				</c:if>
				<label for="input" class="input-placeholder">请输入要删除的用户ID</label>
			</div>
			<button class="dele-btn" type="submit">确定删除</button>
		</form>
	</div>
</body>
</html>