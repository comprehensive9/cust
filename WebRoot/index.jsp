<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的网站</title>
</head>

<body>
	<h2>客户管理系统</h2>
	<a href="${pageContext.request.contextPath}/addCust.jsp ">添加客户</a>
	<a href="${pageContext.request.contextPath}/servlet/ListCustServlet">客户列表</a>
	<a href="${pageContext.request.contextPath}/servlet/PageCustServlet?thispage=1">分页显示客户列表</a>
</body>
</html>
