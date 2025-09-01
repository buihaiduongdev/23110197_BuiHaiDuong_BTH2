package controller.admin;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 20 * 1024 * 1024, // 20MB
		maxRequestSize = 50 * 1024 * 1024 // 50MB
)
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "D:/uploads/category/";
	private CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/admin/add-category.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = new Category();
		category.setCatename(req.getParameter("name"));

		Part filePart = req.getPart("icon");
		if (filePart != null && filePart.getSize() > 0) {
			String fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName();
			File uploadDir = new File(UPLOAD_DIR);
			if (!uploadDir.exists())
				uploadDir.mkdirs();
			File file = new File(uploadDir, fileName);
			filePart.write(file.getAbsolutePath());
			category.setIcon("category/" + fileName);
		} else {
			category.setIcon(null);
		}

		cateService.insert(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
}
