<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>啊对对队——实验四(1)——修改</title>
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
		<jsp:param name="active" value="3" />
	</jsp:include>
	<div id="update">
		<div class="update-form-wrap">
			<form id="insert-form"
				action="${pageContext.request.contextPath }/updateServlet"
				method="post">
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uid" type="text"
						name="uid" required /> <label class="input-placeholder"
						for="uid">请输入需要修改的用户ID</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uname" type="text"
						name="uname" required /> <label class="input-placeholder"
						for="uname">请输入新的姓名</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uphone" type="text"
						name="uphone" required /> <label class="input-placeholder"
						for="uphone">请输入新的手机号</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uage" type="text"
						name="uage" required /> <label class="input-placeholder"
						for="uage">请输入新的年龄</label>
				</div>
				<div class="input-wrap">
					<input id="sex-man" type="radio" value="男" name="usex" checked />
					<label for="sex-man" style="margin-right: 20px;">男</label> <input
						id="sex-woman" type="radio" value="女" name="usex" /> <label
						for="sex-woman">女</label>
				</div>
				<button type="submit" id="insert-input-btn">提交</button>
			</form>
		</div>
	</div>
</body>
</html>