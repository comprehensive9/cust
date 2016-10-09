<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function checkAll(allC) {
		var otherCs = document.getElementsByName("delId");
		for ( var i = 0; i < otherCs.length; i++) {
			otherCs[i].checked = allC.checked;
		}
	}
</script>
</head>

<body>
	<div align="center">
		<h1>客户列表</h1>

		<form
			action="${pageContext.request.contextPath }/servlet/FindCustByCondServlet"
			method="post">
			客户姓名：<input type="text" name="name" value="${param.name }" /> 客户性别：
			<input type="radio" name="gender" value="男"
				<c:if test="${param.gender=='男' }">checked='checked'</c:if> />男
			<input type="radio" name="gender" value="女"
				<c:if test="${param.gender=='女' }">checked='checked'</c:if> />女
			<input type="radio" name="gender" value="" />无 客户类型： <select
				name="type">
				<option value=""
					<c:if test="${param.type=='' }">
							 selected="selected"
						</c:if>></option>
				<option value="钻石客户"
					<c:if test="${param.type=='钻石客户' }">
							 selected="selected"
						</c:if>>钻石客户</option>
				<option value="白金客户"
					<c:if test="${param.type=='白金客户' }">
							 selected="selected"
						</c:if>>白金客户</option>
				<option value="黄金客户"
					<c:if test="${param.type=='黄金客户' }">
							 selected="selected"
						</c:if>>黄金客户</option>
				<option value="白银客户"
					<c:if test="${param.type=='白银客户' }">
							 selected="selected"
						</c:if>>白银客户</option>
				<option value="青铜客户"
					<c:if test="${param.type=='青铜客户' }">
							 selected="selected"
						</c:if>>青铜客户</option>
				<option value="黑铁客户"
					<c:if test="${param.type=='黑铁客户' }">
							 selected="selected"
						</c:if>>黑铁客户</option>
			</select> <input type="submit" value="条件查询客户" />
		</form>

		<form
			action="${pageContext.request.contextPath }/servlet/BatchDelServlet"
			method="POST">
			<table border="1px" width="80%" cellspacing="0">
				<th><input type="checkbox" onclick="checkAll(this)" />全选</th>
				<th>客户姓名</th>
				<th>客户性别</th>
				<th>出生日期</th>
				<th>电话号码</th>
				<th>电子邮箱</th>
				<th>客户爱好</th>
				<th>客户类型</th>
				<th>描述信息</th>
				<th>修改信息</th>
				<th>删除客户</th>

				<c:forEach items="${requestScope.list }" var="cust">
					<tr>
						<td><input type="checkbox" name="delId" value="${cust.id}" />
						</td>
						<td><c:out value="${cust.name}"></c:out></td>
						<td><c:out value="${cust.gender}"></c:out></td>
						<td><c:out value="${cust.birthday}"></c:out></td>
						<td><c:out value="${cust.cellphone}"></c:out></td>
						<td><c:out value="${cust.email}"></c:out></td>
						<td><c:out value="${cust.preference}"></c:out></td>
						<td><c:out value="${cust.type}"></c:out></td>
						<td><c:out value="${cust.description}"></c:out></td>
						<td><a
							href="${pageContext.request.contextPath}/servlet/CustInfoServlet?id=${cust.id}" />修改</td>
						<td><a
							href="${pageContext.request.contextPath}/servlet/DelCustServlet?id=${cust.id}" />删除</td>
					</tr>
				</c:forEach>

			</table>
			<input type="submit" value="批量删除" />
		</form>
	</div>
</body>
</html>
