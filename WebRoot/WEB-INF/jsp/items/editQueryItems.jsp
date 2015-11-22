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
    <title>批量修改商品</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  	<script type="text/javascript">
  		function editQueryItemsSubmit(){
  			document.itemsForm.action = "${pageContext.request.contextPath}/items/editQueryItemsSubmit.action";
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
      查询条件：
  <table width="100%" border="1">
  <tr>
  	<td>商品名称:<input type="text" name="itemsCustom.name"/> 
  	<td>商品价格:<input type="text" name="itemsCustom.price"/>
  	<td><input type = "button" value="查询"	  onclick="queryItems()">
  	<input type = "button" value="批量提交"  onclick="editQueryItemsSubmit()"></td> 
  </tr>
  </table>
      商品列表：
  <table width="100%" border="1">
  <tr>
  	<td>商品名称</td>
  	<td>商品价格</td>
  	<td>生产日期</td>
  	<td>商品属性</td>
  	<td>操作</td>
  </tr>
  <c:forEach items = "${itemsList}" var="item" varStatus="status">
  	<input type="hidden" name="itemsList[${status.index}].id" value="${item.id}"/>
  <tr>
  	<td><input type="text"   name="itemsList[${status.index}].name" value="${item.name}"/> </td>
  	<td><input type="text" name="itemsList[${status.index}].price" value="${item.price}"/></td>
  	<td><input type="text" name="itemsList[${status.index}].createtime" value="<fmt:formatDate value = "${item.createtime}" pattern = "yyyy-mm-dd HH:mm:ss"/>"/></td>
  	<td><input type="text" name="itemsList[${status.index}].detail" value="${item.detail}"/></td>
  	<td><a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a></td>
  </tr>
  </c:forEach>
  </table>
  </form>
  </body>
</html>
