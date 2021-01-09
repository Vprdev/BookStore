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
import bean.KhachHangBean;
import bo.AdminBo;
import dao.XuLyDao;

/**
 * Servlet implementation class AddAdmin
 */
@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAdmin() {
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

		// Nếu đã đăng nhập thì không cho đăng ký người dùng
		HttpSession session = req.getSession();
		if(session.getAttribute("admin") != null) {
			resp.sendRedirect("LoginAdmin");
			return;
		}

		Map<String, String> errors = new HashMap<String, String>(); 
		Map<String, String> after = new HashMap<String, String>(); 

		// Lấy dữ liệu
		String Ho = req.getParameter("FirstName"); 
		String Ten = req.getParameter("LastName");
		String email = req.getParameter("EmailAdmin");
		String password1 = req.getParameter("PasswordAdmin1");
		String password2 = req.getParameter("PasswordAdmin2");
		AdminBean admin = new AdminBean(email, password1, Ho, Ten, false); //lưu dữ lại admin chờ xử  lý
		AdminBo bo = new AdminBo();
		boolean check = true;
		// kiểm tra email đã nhập hay có trong databasse chưa
		if(email == null || email.isEmpty() || bo.kiemTraTenDn(email)) { 
			errors.put("errorEmail", "Nhập Lại tên Đăng Nhập!");//báo lỗi nếu chua nhập
			check =false;
		}else after.put("AdminEmail", email);// ngược lại thì  lưu lại tên

		//kiểm tra  đăng nhập
		if(Ho == null || Ho.isEmpty()) // kiểm tra ho  đăng nhập đã nhập hay chưa  hoạc đã tồn  tại hay chưa
		{ 	//nếu chưa thì
			errors.put("errorFirstName","Nhập lại First Name");//báo lỗi  nhâp  cho khách hàng nhập lại ho
			check =false;
		} else after.put("AdminFistName",Ho);//gắn lại tên đăng nhập 


		if(Ten == null || Ten.isEmpty()) {
			check =false;
			errors.put("errorLastName","Nhập lại Last Name");// báo lỗi nhập lại ten
		}else after.put("AdminLastName",Ten);

		if(password1 == null || password1.isEmpty()  ) {
			check =false;
			errors.put("errorpass","Nhập password");// báo lỗi nhập lại pass
		}else after.put("AdminPass",password1);

		if(!password1.equals(password2)) {
			check =false;
			errors.put("errorpass2","Nhập lại Confirm Password");// báo lỗi nhập lại  pass 2
		}

		// neu tat ca cac dieu kien duoc duyet thi insert thong tin admin

		if(check){try {
			boolean result = new AdminBo().themTaiKhoanAdmin(admin);
			if(result) { // Đăng ký thành công
				session.setAttribute("admin", admin); // lưu lại thông tin đăng nhập

				// xoá after, errors
				session.removeAttribute("after");// xóa  để kiểm tra khi  đăng  ký tk khác
				session.removeAttribute("errors");
				RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
				rd.forward(req, resp); // chuyển hướng đến trang chủ
				return;
			}
		} catch (Exception e) {
			System.out.println("Lỗi khi thêm admin");
			e.printStackTrace();
			errors.put("signup_fail", "Tạo tài khoản thất bại, vui lòng kiểm tra thông tin trước khi thử lại!<br>");//in ra ;à  đăng ký cho khách  hàng đk lại
		}

		} 
		session.setAttribute("after", after);
		session.setAttribute("errors", errors);
		resp.sendRedirect("SignUpAdminController"); // chuyển hướng đến trang đăng ký
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
