<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>啊对对队——实验四(1)——插入</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet"
	href="./iconfont/font_2972909_3oef5s7kzs9/iconfont.css" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/insert.css" />
<script type="text/javascript" src="./js/vue.min.js"></script>
<script type="text/javascript" src="./js/xlsx.core.min.js"></script>
<script type="text/javascript" src="./js/insert.js"></script>
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<div id="app">
		<jsp:include page="nav.jsp">
			<jsp:param name="active" value="1" />
		</jsp:include>
		<div class="form-wrap">
			<form id="insert-form" action="${pageContext.request.contextPath }/insertByInputServlet" method="post">
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uname" type="text" name="uname" required />
					<label class="input-placeholder" for="uname" >请输入您的姓名</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uphone" type="text" name="uphone" required />
					<label class="input-placeholder" for="uphone" >请输入您的手机号</label>
				</div>
				<div class="input-wrap">
					<input autocomplete="off" class="input" id="uage" type="text" name="uage" required />
					<label class="input-placeholder" for="uage" >请输入您的年龄</label>
				</div>
				<div class="input-wrap">
					<input id="sex-man" type="radio" value="男" name="usex" checked />
					<label for="sex-man" style="margin-right: 20px;">男</label>
					<input id="sex-woman" type="radio" value="女" name="usex" />
					<label for="sex-woman">女</label>
				</div>
				<button type="submit" id="insert-input-btn">提交</button>
			</form>
			<div class="insert-by-file-wrap">
				<form id="by-file-form" action="${pageContext.request.contextPath }/insertByExcelServlet" method="post">
					<input id="file-input" type="file" accept=".xls,.xlsx" />
					<input id="users-value" name="users" type="text"/>
					<label for="file-input" class="file-label iconfont">&#xe66c;使用Excel添加 (推荐)</label>
				</form>
				<div id="excel-data" class="file-result-wrap" v-show="users.length > 0 ">
					<ul class="users-ul">
						<li class="user-title-li">
							<span class="user-title-span">NAME</span>
							<span class="user-title-span">PHONE</span>
							<span class="user-title-span">SEX</span>
							<span class="user-title-span">AGE</span>
						</li>
						<li class="user-item-li" v-for="(item, index) of users" :key="index">
							<span class="user-item-span">{{item.uname}}</span>
							<span class="user-item-span">{{item.uphone}}</span>
							<span class="user-item-span">{{item.usex}}</span>
							<span class="user-item-span">{{item.uage}}</span>
						</li>
					</ul>
					<button type="button" id="file-insert-btn">确定</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>