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

import org.apache.jasper.tagplugins.jstl.core.Catch;

import bean.HoaDonBean;
import bean.KhachHangBean;
import bean.Sach;
import dao.HoaDonDao;

@WebServlet(urlPatterns = {"/GioHangController"})
public class GioHangController extends HttpServlet{
	
	
	 public GioHangController() {
	        super(); 	
	        // TODO Auto-generated constructor stub
	    }
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession();
			 KhachHangBean user = (KhachHangBean)session.getAttribute("user");
	 		if(user == null) {
	 			session.setAttribute("ShowLoginForm", true); // để hiện form login
				response.sendRedirect("SachController"); //
	 			return;
	 		}//ngược  lại  nếu  đã  đăng nhập
	 		else {
	 			
	 			try {
					
					request.setCharacterEncoding("UTF-8");
					response.setCharacterEncoding("UTF-8");
//					session.getAttribute("user");
//					session.getAttribute("after");
//					session.getAttribute("errors");
					RequestDispatcher rd = request.getRequestDispatcher("giohang.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
	 			
	 		}
	 		//request.getRequestDispatcher("lichsumuahang.jsp").forward(request, response);	
			
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}
