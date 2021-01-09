package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.SachBO;

/**
 * Servlet implementation class XoaSachController
 */
@WebServlet("/XoaSachController")
public class XoaSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SachBO bo =new  SachBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masach = request.getParameter("masach");//lấy mã từ client trả về
		HttpSession session = request.getSession();
		if(masach  != null && !masach.isEmpty()) { //kiểm  tra  mã có hợp lệ ko
			bo.DeleteSach(masach);
			session.setAttribute("ShowdeleteBook", true);
			PrintWriter printWriter = response.getWriter();
			System.out.println("Xóa thành công");
		}
		RequestDispatcher rd = request.getRequestDispatcher("ShowBook.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}