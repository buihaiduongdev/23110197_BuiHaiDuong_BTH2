package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    req.setAttribute("rememberedUser", c.getValue());
                    break;
                }
            }
        }

        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe"); // checkbox

        // Check rỗng
        if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("alert", "Tài khoản hoặc mật khẩu không được rỗng!");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        UserService service = new UserServiceImpl();
        User user = service.login(username, password);

        if(user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);

            if("on".equals(rememberMe)) {
                saveRememberMe(resp, username);
            }

            // Redirect sang WaitingController để xử lý role
            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            req.setAttribute("alert", "Sai tài khoản hoặc mật khẩu!");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    private void saveRememberMe(HttpServletResponse resp, String username) {
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(30 * 60);
        resp.addCookie(cookie);
    }
}
