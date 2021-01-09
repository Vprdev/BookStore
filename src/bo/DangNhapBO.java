package bo;

import bean.KhachHangBean;
import dao.XuLyDao;

public class DangNhapBO {
	XuLyDao dao = new XuLyDao();
	public boolean themTaiKhoan(Object obj) {
		return dao.themTaiKhoan(obj);
	}
	public int kiemTraDangNhapKH(String username,String pass) {
		return dao.kiemTraDangNhapKH(username, pass);
	}
	public KhachHangBean  SetInfoKH(String username,String pass) {
		return dao.SetInfoKH(username, pass);
	}
}
