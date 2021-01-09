package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import dao.XuLyDao;


/**
 * Servlet implementation class AddAcountUser
 */
@WebServlet("/AddAcountUser")
public class AddAcountUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddAcountUser() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// Nếu đã đăng nhập thì không cho đăng ký người dùng
		HttpSession session = req.getSession();
		if(session.getAttribute("user") != null) {
			resp.sendRedirect("SachController");
			return;
		}
		
		Map<String, String> errors = new HashMap<String, String>(); 
		Map<String, String> after = new HashMap<String, String>(); 
		
		// Lấy dữ liệu
		String yourname = req.getParameter("inputName"); 
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        KhachHangBean kh = new KhachHangBean( yourname, username, password, phone, email, address);//lưu dữ lại khách hàng chờ xử  lý
		XuLyDao dao =new XuLyDao();
		boolean check = true;
		if(yourname == null || yourname.isEmpty()) { //kiểm tra  ho tên  khách  hàng
			errors.put("YrName", "Tên không được bỏ trống!");//báo lỗi nếu chua nhập
		}else after.put("inputName", yourname);// ngược lại thì  lưu lại tên
		
		//kiểm tra  đăng nhập
		if(username == null || dao.kiemTraTenDn(username)) // kiểm tra tên  đăng nhập đã nhập hay chưa  hoạc đã tồn  tại hay chưa
		{ 	//nếu chưa thì
			errors.put("UsName","Nhập lại tên  đăng  nhập");//báo lỗi  nhâp  cho khách hàng nhập lại tên đn
			check =false;
		} else after.put("UsName",username);//gắn lại tên đăng nhập 

			// kiểm tra email đã nhập hay có trong databasse chưa
		if(email == null || dao.kiemTraEmail(email)) {
			check =false;
			errors.put("Email","Nhập lại email");// báo lỗi nhập lại email
		}else after.put("email",email);
			
		        //kiểm  tra số  điện  thoại đã đúng định dạng và có trong database chưa
		if(phone ==  null || validatePhone(phone)  && dao.kiemTraSoDT(phone)) {					
			check =false;
			errors.put("Phone","Nhập lại số điện thoại");//báo lỗi nhập lại số điện thoại
		}else after.put("phone", phone); 
						       
		if(check){
			try {
				boolean result = new XuLyDao().themTaiKhoan(kh);
				if(result) { // Đăng ký thành công
					session.setAttribute("user", kh); // lưu lại thông tin đăng nhập
					
					// xoá after, errors
					session.removeAttribute("after");// xóa  để kiểm tra khi  đăng  ký tk khác
					session.removeAttribute("errors");
					session.removeAttribute("ShowSignUpForm");
					resp.sendRedirect("SachController"); // chuyển hướng đến trang chủ
					return;
				}
			} catch (Exception e) {
				System.out.println("Lỗi khi thêm user");
				e.printStackTrace();
				errors.put("signup_fail", "Tạo tài khoản thất bại, vui lòng kiểm tra thông tin trước khi thử lại!<br>");//in ra ;à  đăng ký cho khách  hàng đk lại
			}
		
		} 
				
		session.setAttribute("after", after);
		session.setAttribute("errors", errors);
		resp.sendRedirect("SignUpController"); // chuyển hướng đến trang đăng ký
	}
	    public static boolean validatePhone(String txt) { 
	    	Pattern p = Pattern.compile("^[0-9\\-\\+]{9,15}$");
	        Matcher matcher = p.matcher(txt); 
	        return matcher.find(); 
	    } 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
