package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.AdminBean;
import bean.salary;
import jdbc.ThietLap;

public class AdminDao {
	ThietLap database ;
	public AdminDao() {
		database = new ThietLap();
		database.connect();
	}
	public int  kiemTraDangNhapAdmin(String TenDn,String pass) {
		  int check = -1;
		  String find = "SELECT * FROM DangNhap where TenDangNhap = ?";
		  PreparedStatement c ;
		try {
			c = ThietLap.cn.prepareStatement(find);
			c.setString(1, TenDn);
			ResultSet rs = c.executeQuery();
			if(rs.next()) {
				check = 0;
				if(rs.getString(2).trim().equals(pass)) check = 1;
			}
		} catch (Exception e) {
			System.out.println("Đăng nhập thất bại");
			e.printStackTrace();

		}
		return check;
		
	}
	
	/// lấy thông tin admin
	public  AdminBean SetInfoAdmin(String TenDn,String pass) {
		AdminBean admin = new AdminBean();
		admin =null;
		String find = "SELECT * FROM DangNhap where TenDangNhap = ? and MatKhau = ?";
		try {
			PreparedStatement c = ThietLap.cn.prepareStatement(find);
			c.setString(1, TenDn);
			c.setString(2, pass);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				String name = rs.getNString(1);
				String password = rs.getString(2);
				String Ho = rs.getNString(3);
				String Ten = rs.getNString(4);
				boolean quyen = rs.getBoolean(5);
			
			admin= new AdminBean(name, password,Ho,Ten, quyen);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return admin;
	}
	
	//kiểm tra phân quyền
	public boolean  kiemTraPhanquyen(String tendn, String pass) {
		
		try {
			String find = "SELECT * FROM DangNhap  where tendn = ? and MatKhau =? ";
			PreparedStatement c = ThietLap.cn.prepareStatement(find);
			c.setString(1, tendn);
			c.setString(2, pass);
			ResultSet rs = c.executeQuery();
			if(rs.next()) {
				boolean quyen = rs.getBoolean(5);
				if(quyen = true ) {	
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
		
	}
	public boolean themTaiKhoanAdmin(Object obj) {
		AdminBean admin = (AdminBean) obj;
		boolean result = false;
		 try {
			 String sql ="INSERT INTO DangNhap(TenDangNhap,MatKhau,Ho,Ten,Quyen) VALUES(?,?,?,?,?)";
			 PreparedStatement c = ThietLap.cn.prepareStatement(sql);
			 c.setString(1, admin.getTenDN());
			 c.setString(2, admin.getPass());
			 c.setString(3, admin.getHo());
			 c.setString(4, admin.getTen());
			 c.setBoolean(5, admin.isQuyen());
	
			 if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi khi them");
		}
			return result;
		}
	public boolean  kiemTraTenDn(String tendn ) {
		try {
			String find = "SELECT * FROM DangNhap where TenDangNhap = ?";
			PreparedStatement c = ThietLap.cn.prepareStatement(find);
			c.setString(1, tendn);
			ResultSet rs = c.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(tendn) ) {	
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}
	public ArrayList<salary> GetDsSalary(){
		ArrayList<salary> result = new  ArrayList<salary>() ;
		String sql ="select distinct ct.MaSach,sach.tensach, sum(SoLuongMua) as soluongmua,gia from ChiTietHoaDon ct inner join hoadon hd on ct.MaHoaDon = hd.MaHoaDon \r\n" + 
				"inner join sach on sach.masach = ct.MaSach   \r\n" + 
				"group by ct.MaSach,sach.tensach, soluongmua,gia\r\n" + 
				"order by  sum(SoLuongMua) desc\r\n";
		try {
			PreparedStatement c;
			c = ThietLap.cn.prepareStatement(sql);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				String masach = rs.getNString(1);
				String tensach = rs.getNString(2);
				double soluongmua = rs.getDouble(3);
				long gia = rs.getLong(4);
				result.add(new salary(masach, tensach, soluongmua,gia));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;	}
}
