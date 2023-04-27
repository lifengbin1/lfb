<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加结果：${mag }</title>
<link rel="shortcut icon" href="./images/logo/logo.ico" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/search.css" />
<link rel="stylesheet" href="./css/insert.css" />
<script type="text/javascript" src="./js/vue.min.js"></script>
<script type="text/javascript" src="./js/insertShow.js"></script>
</head>
<body>
	<script>
		const path = "${pageContext.request.contextPath }";
	</script>
	<jsp:include page="nav.jsp">
		<jsp:param name="active" value="1" />
	</jsp:include>
	<div id="insertShow">
		<div class="content-wrap">
			<div class="msg-wrap">
				<script>
					const msg = "${msg }";
					console.log(msg);
				</script>
				<h3 class="msg" style="color: ${color }" v-html="msg"></h3>
			</div>
			<c:if test="${!empty users }">
				<script>
					const users = JSON.parse('${users }');
				</script>
				<div id="excel-data" class="file-result-wrap show-excel-table"
					v-show="users.length > 0 ">
					<ul class="users-ul">
						<li class="user-title-li"><span class="user-title-span">ID</span>
							<span class="user-title-span">NAME</span> <span
							class="user-title-span">PHONE</span> <span
							class="user-title-span">SEX</span> <span class="user-title-span">AGE</span>
							<span class="user-title-span">TIME</span></li>
						<li class="user-item-li" v-for="(item, index) of users"
							:key="index"><span class="user-item-span">{{item.uid}}</span>
							<span class="user-item-span">{{item.uname}}</span> <span
							class="user-item-span">{{item.uphone}}</span> <span
							class="user-item-span">{{item.usex}}</span> <span
							class="user-item-span">{{item.uage}}</span> <span
							class="user-item-span">{{item.utime}}</span></li>
					</ul>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>