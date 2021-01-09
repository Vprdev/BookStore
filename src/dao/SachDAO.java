package dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.LoaiSach;
import bean.Sach;
import jdbc.ThietLap;

public class SachDAO {
	ArrayList<Sach> list;
	
	private ThietLap database;
	
	public SachDAO() {
		list = new ArrayList<Sach>();
		database = new ThietLap();
		database.connect();
	}

	//// Lấy dữ liệu Sách từ Sql
	
	private Long toLong(BigDecimal a) {
		double n = Double.valueOf(a.toString());
		return (long)n;
	}
	
	public ArrayList<Sach> docDatabase() {
		list = new ArrayList<Sach>();
		try {
			ResultSet data = ThietLap.getTable("Sach");
			if(data == null) System.out.println("Data null");
			while(data.next()) {
				String masach = data.getNString("masach");
				String tensach = data.getNString("tensach");
				Long gia = data.getLong("gia");
				String tacgia = data.getNString("tacgia");
				String anh = data.getString("anh");
				String maloai = data.getString("maloai");
				String sotap = data.getString("sotap");
				long soluongcon = data.getLong("soluong");
				Date ngaynhap = data.getDate("NgayNhap"); // đọc vào phải đúng dữ liệu
				list.add(new Sach(masach, tensach, tacgia, gia, anh, maloai, sotap, soluongcon, ngaynhap));
			}
			data.close();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Lỗi đọc database!");
		}
		return list;
	}
	
	public Sach find(String maSach) {
		for (Sach sach : list) {
			if(sach.getMasach().equals(maSach)) return sach;
		}
		return null;
	}
	
	public ArrayList<Sach> timTheoTenSach(String text){
		ArrayList<Sach> result = new ArrayList<Sach>();
		if(list != null) {
			for (Sach sach : list) {
				if(sach.getTensach().toLowerCase().contains(text.toLowerCase())) {
					result.add(sach);
				}
			}
		}
		return result;
	}
	
	public ArrayList<Sach> timTheoTenTacGia(String text){
		ArrayList<Sach> result = new ArrayList<Sach>();
		if(list != null) {
			for (Sach sach : list) {
				if(sach.getTacgia().toLowerCase().contains(text.toLowerCase())) {
					result.add(sach);
				}
			}
		}
		return result;
	}
	
	
	/**
	 * 
	 * @param tag: mã loại sách
	 * @return
	 */
	public ArrayList<Sach> locTheoLoaiSach(String tag){
		ArrayList<Sach> result = new ArrayList<Sach>();
		if(list != null) {
			for (Sach sach : list) {
				if(sach.getMaloai().toLowerCase().trim().equals(tag.toLowerCase())) {
					result.add(sach);
				}
				
			}
		}
		return result;
	}
	
	/**
	 * Lấy số phần tử của danh sách
	 * @return
	 */
	public int getSize() {
		if(list == null) return 0;
		return list.size();
	}
	
	/**
	 * Lấy danh sách của trang thứ page
	 * @param page: Trang thứ
	 * @param sizeOfPage: Số phần tử trong trang
	 * @return
	 */
	public ArrayList<Sach> getPage( int page, int sizeOfPage){
		ArrayList<Sach> result = new ArrayList<Sach>();
		int m = Math.min((page-1)*sizeOfPage, getSize()); // phần tử đầu tiên cần trả về
		int n = Math.min(m+sizeOfPage, getSize()); // phần tử cuối cùng cần trả về
		for(int i = m; i < n; i++) {
			result.add(list.get(i));
		}
		return result;
	}
	
	/**
	 * Lấy số trang
	 * @param sizeOfPage: Số phần tử trong một trang
	 * @return
	 */
	public int getNumberOfPage(int sizeOfPage){
		int size = getSize();
		int result = size/sizeOfPage;
		if(size%sizeOfPage > 0) result++;
		return result;
	}
	
	
//  delete sach trong My admin
	
	public boolean  Delete(String  masach) {
		String sql = "delete from sach  where masach =? ";
		PreparedStatement c;
		try {
			c =ThietLap.cn.prepareStatement(sql);
			c.setString(1, masach);
			if(c.executeUpdate() == 1) return  true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// update sach 
	public  boolean UpdateBook(String masach, Object ojb) {
		Sach sach = (Sach) ojb;
		String sql ="UPDATE sach SET masach =? ,tensach= ?,soluong =?,gia = ?,maloai = ?,sotap = ?,anh =?,tacgia = ? where masach =? ";
		PreparedStatement c;
		try {
			c =ThietLap.cn.prepareStatement(sql);
			c.setString(1, sach.getMasach());
			c.setString(2, sach.getTensach());
			c.setLong(3, sach.getSoluongcon());
			c.setLong(4, sach.getGia());
			c.setString(5, sach.getMaloai());
			c.setString(6, sach.getSotap());
			c.setString(7,"image_sach/"+sach.getAnh());
			c.setString(8, sach.getTacgia());
			c.setString(9, masach);
			if(c.executeUpdate() == 1) return  true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public  boolean InsertBook( Object ojb) {
		Sach sach = (Sach) ojb;
		String sql ="insert into  sach(masach,tensach,soluong,gia,maloai,sotap,anh,tacgia) values(?,?,?,?,?,?,?,?) ";
		PreparedStatement c;
		try {
			c =ThietLap.cn.prepareStatement(sql);
			c.setNString(1, sach.getMasach());
			c.setNString(2, sach.getTensach());
			c.setLong(3, sach.getSoluongcon());
			c.setLong(4, sach.getGia());
			c.setNString(5, sach.getMaloai());
			c.setNString(6, sach.getSotap());
			c.setNString(7, "image_sach/"+sach.getAnh());
			/* c.setDate(8, sach.getNgaynhap()); */
			c.setNString(8, sach.getTacgia());
			if(c.executeUpdate() == 1) return  true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public  Sach Find( String  masach) {
		Sach  sach = new Sach();
		String sql ="select *from sach where masach = ? ";
		PreparedStatement c;
		try {
			c =ThietLap.cn.prepareStatement(sql);
			c.setString(1, masach);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				 String masach1= rs.getString(1);
				 String tensach = rs.getNString(2);
				 String tacgia = rs.getNString(9);
				 long gia = rs.getLong(4);
				 String anh =rs.getNString(7);
				 String maloai = rs.getNString(5);
				 String sotap = rs.getString(6);
				 long soluongcon = rs.getLong(3);
				 Date ngaynhap = rs.getDate(8);
				 sach = new Sach(masach1, tensach, tacgia, gia, anh, maloai, sotap, soluongcon, ngaynhap);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sach;
	}
	public  boolean Findmasach( String  masach) {
		String sql ="select *from sach where masach = ? ";
		boolean isOk=false;
		PreparedStatement c;
		try {
			c =ThietLap.cn.prepareStatement(sql);
			c.setString(1, masach);
			ResultSet rs =c.executeQuery();
			while(rs.next()) {
				String masach1 = rs.getString(1);
				if(masach1 != null ) isOk = true;
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return isOk;
	}
	
	public int Count() {
		int count =0;
		String sql = "select COUNT(masach) from sach";
		PreparedStatement c;
		try {
			c = ThietLap.cn.prepareStatement(sql);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
