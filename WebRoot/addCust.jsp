<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的网站</title>
</head>

<body>
	<div align="center">
		<h2>客户管理系统--添加客户</h2>

		<form
			action="${pageContext.request.contextPath}/servlet/AddCustServlet "
			method="POST">
			<table border="1px">
				<tr>
					<td>客户姓名:</td>
					<td><input type="text" name="name" /></td>
				</tr>

				<tr>
					<td>客户性别:</td>
					<td><input type="radio" name="gender" value="男" /> 男<input
						type="radio" name="gender" value="女" />女</td>
				</tr>

				<tr>
					<td>出生日期:</td>
					<td><input type="text" name="birthday" /></td>
				</tr>

				<tr>
					<td>手机号码:</td>
					<td><input type="text" name="cellphone" /></td>
				</tr>

				<tr>
					<td>电子邮箱:</td>
					<td><input type="text" name="email" /></td>
				</tr>

				<tr>
					<td>客户爱好:</td>
					<td><input type="checkbox" name="preference" value="篮球" />篮球
						<input type="checkbox" name="preference" value="足球" /> 足球<input
						type="checkbox" name="preference" value="排球" />排球 <input
						type="checkbox" name="preference" value="铅球" />铅球 <input
						type="checkbox" name="preference" value="乒乓球" />乒乓球</td>
				</tr>

				<tr>
					<td>客户类型:</td>
					<td><select nmae="type">

							<option value="钻石客户">钻石客户</option>
							<option value="白金客户">白金客户</option>
							<option value="黄金客户">黄金客户</option>
							<option value="白银客户">白银客户</option>
							<option value="青铜客户">青铜客户</option>
							<option value="黑铁客户">黑铁客户</option>
					</select></td>
				</tr>

				<tr>
					<td>描述信息:</td>
					<td><textarea name="description" rows="6" cols="40"></textarea>
					</td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="添加客户"
						align="center" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
