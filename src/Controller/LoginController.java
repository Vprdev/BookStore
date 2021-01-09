package Controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.KhachHangBean;
import dao.XuLyDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	public  LoginController() {
		super();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");



		HttpSession session = req.getSession();
		// Nếu user đã đăng nhập thì không cho phép đăng ký nữa
		if(session.getAttribute("user") != null) {
			resp.sendRedirect("SachController");
			return;
		}
		
		else {
			// Create a Bundle of errors in the form of Map 

			Map<String, String> errors = new HashMap<String, String>(); 
			Map<String, String> after = new HashMap<String, String>(); 
			String username = req.getParameter("username");
			String pass = req.getParameter("pass");
			if(username != null && pass != null) {
				XuLyDao dao = new XuLyDao();
				int checktemp = dao.kiemTraDangNhapKH(username, pass);
				if(checktemp == 1) {
					KhachHangBean kh = dao.SetInfoKH(username, pass);
					session.setAttribute("user", kh);

					// xoá after, errors
					session.removeAttribute("after");
					session.removeAttribute("errors");
					resp.sendRedirect("SachController");
					return;
				}
				else {
					after.put("UserName", username);
					if(checktemp == -1) errors.put("failUser", "Tên đăng nhập không tồn tại!");
					else errors.put("failpass", "Mật khẩu không chính xác!");
					session.setAttribute("ShowLoginForm", true);
				}
			}
			req.setAttribute("after", after);
			req.setAttribute("errors", errors);
		}

		resp.sendRedirect("SachController");;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
