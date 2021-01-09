package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.KhachHangBean;
import jdbc.ThietLap;

public class XuLyDao{
	ThietLap database;
	
	public  XuLyDao() {
		database = new ThietLap();
		database.connect();
		
	}
	

	public boolean themTaiKhoan(Object obj) {
	KhachHangBean kh = (KhachHangBean) obj;
	boolean result = false;
	 try {
		 String sql ="INSERT INTO KhachHang(hoten,diachi,sodt,email,tendn,pass) VALUES( ?, ?, ?, ? ,? ,?)";
		 PreparedStatement c = ThietLap.cn.prepareStatement(sql);
//		 c.setString(1, kh.getMakh());
		 c.setString(1, kh.getHoten());
		 c.setString(2, kh.getAddress());
		 c.setString(3, kh.getPhone());
		 c.setString(4, kh.getEmail());
		 c.setString(5, kh.getTenDN());
		 c.setString(6, kh.getPass());
		 if(c.executeUpdate() == 1) result = true;
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Loi khi them");
	}
		return result;
	}
   
	public  KhachHangBean SetInfoKH(String username, String pass) {
		KhachHangBean kh = new KhachHangBean(); 
		kh =null;
		String find = "SELECT * FROM KhachHang where tendn = ? and pass = ? ";
		PreparedStatement c;
		try {
			c = ThietLap.cn.prepareStatement(find);
			c.setString(1, username);
			c.setString(2, pass);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				long mkh =rs.getLong("makh");
				String name = rs.getNString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				String email = rs.getString(5);
				String user = rs.getString(6);
				String password = rs.getString(7);
			kh= new KhachHangBean(mkh,name,user,password,phone,email,address);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return kh;
	}
	

public int  kiemTraDangNhapKH(String username,String pass) {
		int temp =-1;  // ko có account này trong database
		String find = "SELECT * FROM KhachHang where tendn = ?";
		PreparedStatement c;
	try {
		 c = ThietLap.cn.prepareStatement(find);
		 c.setString(1, username);
		ResultSet rs = c.executeQuery();
		if(rs.next()) {
			temp = 0;  //có account này
			if(rs.getString(7).trim().equals(pass)) temp = 1; // đúng pass
		}
	} catch (Exception e) {
		System.out.println("Loi tim ma!");
		e.printStackTrace();
	}
	return temp;
	
}


	/* public boe */

public boolean  kiemTraEmail(String email ) {
	try {
		String find = "SELECT * FROM KhachHang where email = ?";
		PreparedStatement c = ThietLap.cn.prepareStatement(find);
		c.setString(1, email);
		ResultSet rs = c.executeQuery();
		if(rs.next()) {
			if(rs.getString(5).equals(email) ) {	
				return true;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	return false;
	
}
public boolean  kiemTraTenDn(String tendn) {
	try {
		String find = "SELECT * FROM  KhachHang where tendn = ?";
		PreparedStatement c = ThietLap.cn.prepareStatement(find);
		c.setString(1, tendn);
		ResultSet rs = c.executeQuery();
		if(rs.next()) {
			if(rs.getString(6).equals(tendn) ) {	
				return true;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	return false;
	
}
public boolean  kiemTraSoDT(String  phone ) {
	try {
		String find = "SELECT * FROM  KhachHang where sodt = ?";
		PreparedStatement c = ThietLap.cn.prepareStatement(find);
		c.setString(1, phone);
		ResultSet rs = c.executeQuery();
		if(rs.next()) {
			if(rs.getString(4).equals(phone) ) {	
				return true;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	return false;
	
}

public ArrayList<KhachHangBean>  GetAllKH() {
	ArrayList<KhachHangBean> kh = new ArrayList<KhachHangBean>(); 
	String find = "SELECT * FROM KhachHang ";
	PreparedStatement c;
	try {
		c = ThietLap.cn.prepareStatement(find);
		ResultSet rs = c.executeQuery();
		while(rs.next()) {
			long mkh =rs.getLong(1);
			String name = rs.getNString(2);
			String address = rs.getString(3);
			String phone = rs.getString(4);
			String email = rs.getString(5);
			String user = rs.getString(6);
		kh.add(new KhachHangBean(mkh,name,user,phone,email,address));				
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	return kh;
}


}
