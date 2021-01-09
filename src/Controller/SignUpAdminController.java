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

/**
 * Servlet implementation class SignUpAdminController
 */
@WebServlet("/SignUpAdminController")
public class SignUpAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpAdminController() {
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
		
		// Nếu user đã đăng nhập thì không cho phép đăng ký nữa
		HttpSession session = req.getSession();
		if(session.getAttribute("user") != null) {
			RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
			rd.forward(req, resp);
			return;
		}
		
		// Lấy thông tin từ after và errors để show lên nếu có lỗi từ lượt sign up trước đó
		// Nếu không có nghĩa là đây là lượt sign up đầu tiên
		Map<String, String> errors = (HashMap<String, String>)session.getAttribute("errors"); 
		Map<String, String> after = (HashMap<String, String>)session.getAttribute("after");
		if(after != null && errors != null) {
			req.setAttribute("after", after);
			req.setAttribute("errors", errors);
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);
			return;
			
		}
		RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
		rd.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
