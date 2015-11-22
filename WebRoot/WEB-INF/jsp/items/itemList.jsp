<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>查询商品列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  	<script type="text/javascript">
  		function deleteItems(){
  			document.itemsForm.action = "${pageContext.request.contextPath}/items/BatDeleteItems.action";
  			document.itemsForm.submit();
  		}
  		
  		function queryItems(){
  			document.itemsForm.action = "${pageContext.request.contextPath}/items/queryItems.action";
  			document.itemsForm.submit();
  		}
  		
  	</script>
  </head>
  <body>
  
<form name="itemsForm" action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
	当前登录用户：${userName}
	<!-- 显示登录用户信息 -->
	<c:if test="${userName != null && userName !=''}">
		 &nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/logout.action" ><font size="4" color="red">退出</font></a>
	</c:if>
<br>
<br>
      查询条件：
  <table width="100%" border="1">
  <tr>
  	<td>商品名称:<input type="text" name="itemsCustom.name"/> 
  	<td>商品价格:<input type="text" name="itemsCustom.price"/>
  	<td><input type = "button" value="查询"	  onclick="queryItems()">
  	<input type = "button" value="批量删除"  onclick="deleteItems()"></td> 
  </tr>
  </table>
      商品列表：
  <table width="100%" border="1">
  <tr>
  	<td>选择</td>
  	<td>商品名称</td>
  	<td>商品价格</td>
  	<td>生产日期</td>
  	<td>商品属性</td>
  	<td>操作</td>
  </tr>
  <c:forEach items = "${itemsList}" var="item">
  <tr>
  	<td><input type="checkbox" name ="items_id" value ="${item.id}"></td>
  	<td>${item.name}</td>
  	<td>${item.price}</td>
  	<td><fmt:formatDate value = "${item.createtime}" pattern = "yyyy-mm-dd HH:mm:ss"/></td>
  	<td>${item.detail}</td>
  	<td><a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a></td>
  	<td><a href="${pageContext.request.contextPath}/items/editMapItems.action?id=${item.id}">Map修改</a></td>
  </tr>
  </c:forEach>
  </table>
  </form>
  </body>
</html>
