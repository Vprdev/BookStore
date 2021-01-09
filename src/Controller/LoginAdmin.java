package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import bo.AdminBo;


/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");



		HttpSession session = req.getSession();
		// Nếu user đã đăng nhập thì không đăng nhập  cho  nữa
		if(session.getAttribute("admin") != null) {
			RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
			rd.forward(req, resp);
			return;
		}
		
		else {
			// Create a Bundle of errors in the form of Map 
			// Check dăng nhâp
			Map<String, String> errors = new HashMap<String, String>(); 
			Map<String, String> after = new HashMap<String, String>(); 
			String TenDn = req.getParameter("inputEmailAddress");
			String pass = req.getParameter("inputPassword");
			if(TenDn != null && pass != null) {
				AdminBo bo = new AdminBo();
				int checktemp = bo.kiemTraAdmin(TenDn, pass);
				if(checktemp == 1) {
					System.out.println("Dang nhập admin thành công");
					AdminBean admin = bo.SetInfoAdmin(TenDn, pass) ;
					session.setAttribute("admin", admin);
					AdminBean admin1 =(AdminBean) session.getAttribute("admin");
					System.out.println(admin1.getHo());
					// xoá after, errors
					session.removeAttribute("after");
					session.removeAttribute("errors");
					RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
					rd.forward(req, resp);
					return;
				}
				else {
					after.put("NameAdmin", TenDn);
					if(checktemp == -1) {
						errors.put("failAdmin", "Tên đăng nhập không tồn tại!");
						System.out.println("Dang nhập tên admin thất bại");
					} else { 
						errors.put("failAminpass", "Mật khẩu không chính xác!");
						System.out.println("Dang nhập mat khau admin thất bại");
					}
					req.setAttribute("after", after);
					req.setAttribute("errors", errors);
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
					return;
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
