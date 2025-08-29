<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ include file="layout/topbar.jsp"%>

<html>
<head>
<title>Quên mật khẩu</title>
</head>
<body>
	<h2>Quên mật khẩu</h2>

	<c:if test="${alert != null}">
		<p style="color: red">${alert}</p>
	</c:if>

	<form action="forget" method="post">
		<label>Email:</label> <input type="email" name="email" required /><br />
		<button type="submit">Xác nhận</button>
	</form>
</body>
</html>
