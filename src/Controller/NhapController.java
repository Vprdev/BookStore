package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Patch;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Sach;
import bo.SachBO;

/**
 * Servlet implementation class NhapController
 */
@WebServlet("/NhapController")
public class NhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SachBO bo = new SachBO();

	/*
	 * @WebServlet(https://cdn.helpex.vn/upload")
	 * 
	 * @MultipartConfig
	 */
		public class UploadServlet extends HttpServlet {
		    // ...
		}
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhapController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "files";
		response.getWriter().println(dirUrl1);

		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			Iterator<FileItem> iter= fileItems.iterator();
			HashMap<String, String> fields = new HashMap<>();
			String image = null;
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
				//lấy tên file 
					String nameimg = fileItem.getName();
					Path path =Paths.get(nameimg);
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						int vt1 = dirUrl.indexOf(".metadata");
						dirUrl = dirUrl.substring(0, vt1 - 1) + "\\BookStore\\WebContent\\image_sach";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							image = path.getFileName().toString();
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else{// Neu la control
					// test tí vui thôi! kheo mat code
					// test
					fields.put(fileItem.getFieldName(),fileItem.getString("UTF-8"));// lấy dữ liệu từ client gửi về định dạng UTF-8
						
				}
			}
			Sach sach = new Sach();
			sach.setMasach(fields.get("txtmasach"));
			String masach = sach.getMasach();
			System.out.println("tim thay ma sach:"+masach);
			sach.setTensach(fields.get("txttensach"));
			sach.setTacgia(fields.get("txttacgia"));
			String tacgia = sach.getTacgia();
			System.out.println("tim thay tac gia:"+tacgia);
			sach.setGia(Long.parseLong(fields.get("txtgia")));
			sach.setSoluongcon(Long.parseLong(fields.get("txtsoluong")));
			sach.setSotap(fields.get("txtsotap"));
			sach.setMaloai(fields.get("txtmaloai"));
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			  Date parsed =null; 
			  try { 
				  parsed = format.parse(fields.get("txtngaynhap")); 
			  } catch (ParseException e1) {
					e1.printStackTrace(); 
				} 
			java.sql.Date sql= new java.sql.Date(parsed.getTime());
			System.out.println("tim thay gay nhap:"+sql);
			sach.setNgaynhap(sql);
			sach.setAnh(image);
			
			 System.out.print(sach);
			 if(bo.Findmasach(masach)== true) { 
				 bo.UpdateBook(masach, sach); 
			 }else{
			  bo.InsertBook(sach); 
			  }
			
			 RequestDispatcher rd = request.getRequestDispatcher("ShowBook.jsp");
				rd.forward(request, response);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}

}
