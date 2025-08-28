<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/topbar.jsp"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
	
</head>
<body>
	<div class="auth-container">
		<h2>Đăng nhập</h2>

		<c:if test="${alert != null}">
			<div class="alert alert-danger">${alert}</div>
		</c:if>

		<form action="login" method="post">

			<div class="mb-3 input-group">
				<span class="input-group-text"><i class="fa fa-user"></i></span> <input
					type="text" class="form-control" placeholder="Tài khoản"
					name="username"
					value="${rememberedUser != null ? rememberedUser : ''}">
			</div>

			<div class="mb-3 input-group">
				<span class="input-group-text"><i class="fa fa-lock"></i></span> <input
					type="password" class="form-control" placeholder="Mật khẩu"
					name="password">
			</div>

			<div class="form-check mb-3">
				<input class="form-check-input" type="checkbox" name="rememberMe"
					id="rememberMe"> <label class="form-check-label"
					for="rememberMe">Ghi nhớ đăng nhập</label>
			</div>

			<button type="submit" class="btn btn-primary w-100">Đăng
				nhập</button>
		</form>

		<p class="demo-account">
			usn: <b>admin</b> <br> pass: <b>123456</b>
		</p>
	</div>
</body>
</html>
