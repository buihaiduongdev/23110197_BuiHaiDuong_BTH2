package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		if (userService.checkExistUsername(username)) {
			req.setAttribute("alert", "Tài khoản đã tồn tại!");
			req.getRequestDispatcher("views/register.jsp").forward(req, resp);
			return;
		}

		if (userService.checkExistEmail(email)) {
			req.setAttribute("alert", "Email đã tồn tại!");
			req.getRequestDispatcher("views/register.jsp").forward(req, resp);
			return;
		}

		if (phone != null && !phone.isEmpty() && userService.checkExistPhone(phone)) {
			req.setAttribute("alert", "Số điện thoại đã tồn tại!");
			req.getRequestDispatcher("views/register.jsp").forward(req, resp);
			return;
		}
		User u = new User();
		u.setUserName(username);
		u.setPassWord(password);
		u.setFullName(fullname);
		u.setEmail(email);
		u.setPhone(phone);
		u.setRoleId(3);
		userService.insert(u);
		resp.sendRedirect(req.getContextPath() + "/login");

	}
}
