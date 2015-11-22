<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<!-- 显示错误信息 -->
	<c:if test="${allErrors!=null}">
		<c:forEach items="${allErrors}" var="error">
			<h1 style="color: red;">${error.defaultMessage}</h1>
			<br />
		</c:forEach>
	</c:if>
	<!-- enctype="multipart/form-data"-->
	<form id="loginForm" action="${pageContext.request.contextPath }/login.action" method="get">
		用户登录：
		<table width="100%" border=1>
			<tr>
				<td>账号</td>
				<td><input type="text" name="userName" />
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>