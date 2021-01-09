package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ChiTietHoaDonBean;
import bean.HoaDonBean;
import bean.KhachHangBean;
import bean.LichSuBean;
import bo.HoaDonBo;
import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
/**
 * Servlet implementation class LichSuMuaHangController
 */
@WebServlet("/LichSuMuaHangController")
public class LichSuMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public LichSuMuaHangController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		 KhachHangBean user = (KhachHangBean)session.getAttribute("user");///laasy  session user ra kiểm tra  là khác  hàng đã  đăng nhập hay chưa
		// nếu  chưa  đăng nhâp thì quay  lại  trang  chủ  hiện form  đăng  nhập
 		if(user == null) {
 			session.setAttribute("ShowLoginForm", true); // để hiện form login
			response.sendRedirect("SachController"); //
 			return;
 		}//ngược  lại  nếu  đã  đăng nhập
 		else {
 			//dùng mảng HoaDonBean  Để láy ra list  danh  sách hóa  đơn của  một khác hàng
 			//dùng class HoaDonDAo để lấy ra  mã hóa đơn dùng  để  lấy dữ liệu trong  chi  tiết hóa  đơn,lấy ngày mua để  hiển  thị lịch sửa mua hàng
 		
// 			HoaDonBo HDBo  = new HoaDonBo();
// 			ArrayList<HoaDon> HDBean =HDBo.getHoaDon(user.getMakh());//lấy  được mã hóa  đơn của user
 			// dùng mã hóa doewn  lấy được truy xuất vào chi tiết hóa đơn  ,dùng vòng for
// 			for(HoaDon hoaDon : HDBean) {
// 				session.setAttribute("MaHoaDon", hoaDon.getMaHoaDon());
 				HoaDonDao HDDao = new HoaDonDao();//khai báo chi tiet hoa don dao để láy  hàm gettheomaHoaDon
 	 			ArrayList<HoaDonBean> HoaDon = HDDao.Func_HoaDon(user.getMakh());//lấy  ra  mảng  chi tiết  hóa dơn trong database tu ma hoa đơn
 	 			session.setAttribute("hoadon",HoaDon);//gắn atrrinbute để gọi lại trong lichsumuahang.jsp
 			
 		}
 		request.getRequestDispatcher("lichsumuahang.jsp").forward(request, response);	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
