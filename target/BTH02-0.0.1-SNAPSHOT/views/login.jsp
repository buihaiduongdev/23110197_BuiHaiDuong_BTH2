<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/topbar.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<form action="login" method="post">
		<h2>Đăng nhập</h2>

		<c:if test="${alert != null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>

		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i class="fa fa-user"></i>
					</span> <input type="text" placeholder="Tài khoản" name="username"
						class="form-control"
						value="${rememberedUser != null ? rememberedUser : ''}">

				</div>
			</label>
		</section>

		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i class="fa fa-lock"></i>
					</span> <input type="password" placeholder="Mật khẩu" name="password"
						class="form-control">
				</div>
			</label>
		</section>

		<section>
			<label> <input type="checkbox" name="rememberMe"> Ghi
				nhớ đăng nhập
			</label>
		</section>

		<button type="submit" class="btn btn-primary">Đăng nhập</button>
	</form>

	<p>
		usn: admin <br> pass: 123456
	</p>
</body>
</html>
