package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ChiTietHoaDonBean;
import bean.GioHang;
import bean.HoaDonBean;
import bean.KhachHangBean;
import bean.MonHang;
import bean.Sach;
import bo.DangNhapBO;
import bo.SachBO;
import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import dao.XuLyDao;
import util.RandomUUID;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet("/ThanhToanController")
public class ThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ThanhToanController() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		// Lấy dữ liệu từ session ra(được giỏ hàng, user sau khi đăng nhập)//mục đích: lấy được dữ liệu từ giỏ hàng
		GioHang gioHang = (GioHang)session.getAttribute("Gio");
		
		//nếu  như giỏ  hanfgh trống hoặc null thì trở về trang chủ ko cho thanh toán
		if(gioHang == null || gioHang.getList().isEmpty()) {
			response.sendRedirect("SachController");
		}else {
			// sau  đó get makh  từ user // vì trong table hoá đơn có thuộc tính makh nên cần lấy cái này ra, với cả để check xem khách hàng đã đăng nhập chưa
	
			KhachHangBean kh = (KhachHangBean)session.getAttribute("UserKh");
			System.out.print(kh);
			// nếu  khách hàng  chưa đăng  nhạp thì thông  báo và hiện form đăng nhập,sdau khi đăng  nhập  thành  công  thì  mowischo thanh  toán
			if(kh == null) {
				session.setAttribute("ShowLoginForm", true); // để hiện form login
				response.sendRedirect("giohang.jsp"); // chuyển hướng đến trang giỏ hàng
//				PrintWriter out = response.getWriter();
//				out.print("<script>alert('You must login!')</script>");
				return;	
			}else { 				// nếu dữ liệu đã ok rồi thì:
				// => Tạo mới một hoá đơn để add các món hàng đã mua(mỗi món hàng đã mua là 1 chi tiết đơn hàng), set damua = false để tìm kiếm lại mã hoá đơn này
				HoaDonBean HDBean =new HoaDonBean(kh.getMakh(), false);//khai báo mảng để  lưu  đối tượng
				System.out.print(HDBean);											
				
				
				HoaDonDao HDDao = new HoaDonDao();//gọi hàm xử  lý 
				HDDao.AddHoaDon(HDBean); //thêm  đối tượng vào  table hoadon
				// Tìm kiếm lại để lấy ra được mã đơn hàng có damua = false
				long maHoaDon = HDDao.timKiemDaMua(kh.getMakh());//lay  ma hoadon hang tu bang hodon
				System.out.print(maHoaDon);
				// Tìm được rồi thì đầu add các chi tiết đơn hàng // bây giờ thì có mã hoá đơn để bỏ vào chi tiết hoá đơn rồi đó
				//trả giá  trị damua trong  bảng hóa đơn về true(dùng 1 hàm trong hoadondao(vd: hoadon.updateDamua(status))
				HDDao.SetDaMua(kh.getMakh());
				// Trong giỏ hàng lấy ra được arraylist<MonHang>//láy  được mã sách ,số  lượng  mua ở giỏ  hàng để chuẩn bị thêm vào database
				
				//  từ araylist<MonHang> ta lấy   được mã sách ,số  lượng  mua ở giỏ  hàng để truyền vào bảng chi tiết hóa đơn
				// khai  báo class  ChiTietHoaDonDao  // dùng để gọi  hàm  add  dữ liệu vào bảng  chi tiet  hoa don
				
				ChiTietHoaDonDao  CTHDDao = new ChiTietHoaDonDao();
				// duyệt ds món hàng. add dũ liệu vào bảng chi tiết  hóa đơn thông qua chitiethoadoonDAo.Them...()				
				ArrayList<MonHang> list = gioHang.getList(); // lấy danh sách trong giỏ hàng 	 
				for(MonHang monHang : list){
					String maChiTietHD = RandomUUID.getRandomID();
					CTHDDao.AddChitietHoadon(new ChiTietHoaDonBean(maChiTietHD, monHang.getMaHang(),monHang.getSoLuong(), maHoaDon));
				}
				// xóa attribute "GIO" // set lại giỏ  hàng  về ban đầu để khách  hàng tiếp tục mua  hàng
				session.removeAttribute("Gio");
				//QUAY LẠI TRANG  CHỦ
				response.sendRedirect("SachController");
			}

		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
