package bo;

import java.util.ArrayList;

import bean.AdminBean;
import bean.salary;
import dao.AdminDao;

public class AdminBo {
	AdminDao dao = new AdminDao();
	public int  kiemTraAdmin(String TenDn,String pass) {
		return dao.kiemTraDangNhapAdmin(TenDn, pass);
	}
	
	public  AdminBean SetInfoAdmin(String TenDn,String pass) {
		return dao.SetInfoAdmin(TenDn, pass);
	}
	public boolean  kiemTraPhanquyen(String tendn, String pass) {
		return dao.kiemTraPhanquyen(tendn, pass);
	}
	public boolean themTaiKhoanAdmin(Object obj) {
		AdminBean admin = (AdminBean) obj;
		return dao.themTaiKhoanAdmin(admin);
	}
	public boolean  kiemTraTenDn(String tendn ) {
		return dao.kiemTraTenDn(tendn);
	}
	public ArrayList<salary> GetDsSalary(){
		return dao.GetDsSalary();
	}
}
