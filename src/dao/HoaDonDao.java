package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ChiTietHoaDonBean;
import bean.HoaDonBean;
import jdbc.ThietLap;
public class HoaDonDao {
	ThietLap  database;
	public HoaDonDao() {
		database = new ThietLap();
		database.connect();
	}
	public ArrayList<HoaDonBean> timKiemTheoUser(long makh){ //chưa dùng  đến
		ArrayList<HoaDonBean> result = new ArrayList<HoaDonBean>();
		String sql = "select *from hoadon where  makh = ?";
		PreparedStatement  c ;
		try {
			c = ThietLap.cn.prepareStatement(sql);
			c.setLong(1,makh);
			ResultSet rs = c.executeQuery();
			while(rs.next())
			{
				long  maHoadon = rs.getLong(1);
				int   maKh = rs.getInt(2);
				Date ngayMua =rs.getDate(3); // viết tên biến, tên class, tên hằng thì nên sử dụng một chuẩn luôn
				boolean damua =rs.getBoolean(4);
				result.add(new HoaDonBean(maHoadon, maKh, ngayMua, damua));
			}
		} catch (Exception e) {
			e.printStackTrace(); // in lỗi ra
		}
		return result;
	}
	public ArrayList<HoaDonBean> getAll(){ //chưa dùng  đến
		ArrayList<HoaDonBean> result = new ArrayList<HoaDonBean>();
		String sql = "select *from hoadon ";
		PreparedStatement  c ;
		try {
			c = ThietLap.cn.prepareStatement(sql);
			ResultSet rs = c.executeQuery();
			while(rs.next())
			{
				long  maHoadon = rs.getLong(1);
				int   maKh = rs.getInt(2);
				Date ngayMua =rs.getDate(3); // viết tên biến, tên class, tên hằng thì nên sử dụng một chuẩn luôn
				boolean damua =rs.getBoolean(4);
				result.add(new HoaDonBean(maHoadon, maKh, ngayMua, damua));
			}
		} catch (Exception e) {
			e.printStackTrace(); // in lỗi ra
		}
		return result;
	}
	public long  timKiemDaMua(long  makh) {
		long maHoaDon =0;
		String sql  ="select MaHoaDon from hoadon  where damua = 0 and makh = ?";
		PreparedStatement c;
		try {
			c  = ThietLap.cn.prepareStatement(sql);
			c.setLong(1, makh);
			ResultSet  rs = c.executeQuery();
			while(rs.next()) {
				maHoaDon=rs.getLong(1);
				return maHoaDon;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// ko print biết lỗi méo mok s
		}
	
	  return maHoaDon;
	 
	}
	public boolean SetDaMua(long makh) {
		try {
			String sql = "UPDATE hoadon set damua = 1 where damua =0 and makh = ?";
			PreparedStatement c =ThietLap.cn.prepareStatement(sql);
			c.setLong(1, makh);
			if(c.executeUpdate() == 1) return  true;
		} catch (Exception e) {
			// TODO: handle exception
			// đã kêu có lỗi print ra
			e.printStackTrace();
		}
		return false;
	}
	
	// ví dụ 1 kiểu: class thì để kiểu : TenClass
	// tên biến, tên hàm thì để kiểu: hoTen, getHoTen()
	// tên hằng thì để kiểu: MAX_VALUE
	// kiểu như ruk...nên sử dụng một chuẩn mok đó mà người ta hay dùng sau này khỏi phải chỉnh lại..oik
	// thế cái date truyền  j nữa
	// cái ni là lấy ra chơ có phải thêm vô mok...lấy ra thì vẫn lấy chơ...truyền vô thì có thể bỏ qua như mã hoá đơn ruk
	// lúc nãy mới nói cái mã hoá đơn xong 
	//set cái mã chi tiet  ba
	// ak ơi
	// đây này
	public boolean  AddHoaDon(Object ojb) { 
		HoaDonBean HD = (HoaDonBean) ojb;
		try {
			String sql = "insert into hoadon (makh,damua) values(?,?)";
			PreparedStatement c =ThietLap.cn.prepareStatement(sql);
			c.setLong(1, HD.getMakh());
			c.setBoolean(2, HD.isDamua());
			if(c.executeUpdate() == 1) return  true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<HoaDonBean> Func_HoaDon(long maKhachHang) {
		ArrayList<HoaDonBean> kq = new ArrayList<HoaDonBean>();
		String sql = "select * from hoadon  where hoadon.makh = ?";
		PreparedStatement c;
		try {
			
			c = ThietLap.cn.prepareStatement(sql);
			c.setLong(1, maKhachHang);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				long maHoadon = rs.getLong(1);
				long maKh = rs.getInt(2);
				Date ngayMua =rs.getDate(3);
				boolean damua =rs.getBoolean(4);
				kq.add(new HoaDonBean(maHoadon, maKh, ngayMua, damua));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	
}
