<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<div align="center">
		<h1>客户列表</h1>
		<table border="1px" width="80%" cellspacing="0" >
			<th>客户姓名</th>
			<th>客户性别</th>
			<th>出生日期</th>
			<th>电话号码</th>
			<th>电子邮箱</th>
			<th>客户爱好</th>
			<th>客户类型</th>
			<th>描述信息</th>

			<c:forEach items="${requestScope.list }" var="cust">
				<tr>
					<td><c:out value="${cust.name}"></c:out></td>
					<td><c:out value="${cust.gender}"></c:out></td>
					<td><c:out value="${cust.birthday}"></c:out></td>
					<td><c:out value="${cust.cellphone}"></c:out></td>
					<td><c:out value="${cust.email}"></c:out></td>
					<td><c:out value="${cust.preference}"></c:out></td>
					<td><c:out value="${cust.type}"></c:out></td>
					<td><c:out value="${cust.description}"></c:out></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>
