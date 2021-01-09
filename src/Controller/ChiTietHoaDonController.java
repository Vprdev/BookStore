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
import bean.KhachHangBean;
import bean.LichSuBean;
import dao.ChiTietHoaDonDao;

/**
 * Servlet implementation class ChiTietHoaDonController
 */
@WebServlet("/ChiTietHoaDonController")
public class ChiTietHoaDonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietHoaDonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
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
				ChiTietHoaDonDao CTHDDao = new ChiTietHoaDonDao();
	 			ArrayList<ChiTietHoaDonBean> chitietHDB = CTHDDao.Func_ChiTietHoaDon(user.getMakh());
	 			session.setAttribute("chitiethd",chitietHDB);
	 		}
			
			RequestDispatcher rd = request.getRequestDispatcher("ChiTietHoaDon.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
