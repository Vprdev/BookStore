package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ChiTietHoaDonBean;
import bean.LichSuBean;
import jdbc.ThietLap;

public class ChiTietHoaDonDao {
ThietLap database;
	
	public   ChiTietHoaDonDao(){
		database = new ThietLap();
		database.connect();
	}
	public boolean AddChitietHoadon(Object ojb) {
		ChiTietHoaDonBean CT = (ChiTietHoaDonBean) ojb;
		 boolean isOk = false;
		 try {
			 String query1 = "INSERT INTO ChiTietHoaDon(MaChiTietHD, MaSach, SoLuongMua, MaHoaDon) VALUES (? , ?, ?, ?)";
			 PreparedStatement c =ThietLap.cn.prepareStatement(query1);
			 c.setString(1, CT.getMaChiTietHD());
			 c.setString(2, CT.getMaSach());
			 c.setInt(3, CT.getSoLuongMua());
			 c.setLong(4,CT.getMaHoaDon());
			 if(c.executeUpdate() ==  1) isOk = true;
		 } catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		
		return isOk;
	}
	public ArrayList<LichSuBean> GetDSTheoMaHoaDon(long makh){
		ArrayList<LichSuBean> result = new  ArrayList<LichSuBean>() ;
		String sql ="select * from ChiTietHoaDon inner join hoadon on ChiTietHoaDon.MaHoaDon = hoadon.MaHoaDon "
				+ "inner join sach on sach.masach = ChiTietHoaDon.MaSach where makh = ?  order by  ChiTietHoaDon.MaHoaDon ASC";
		try {
			PreparedStatement c;
			c = ThietLap.cn.prepareStatement(sql);
			c.setLong(1, makh);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				long maHoadon = rs.getLong(4);
				Date ngaymua = rs.getDate(7);
				String tensach = rs.getString(10);
				int soluong = rs.getInt(3);
				long gia = rs.getLong(12);
				result.add(new LichSuBean(maHoadon, ngaymua, tensach, soluong, gia));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;	
	}
	public ArrayList<ChiTietHoaDonBean> Func_ChiTietHoaDon(long maKhachHang) {
		ArrayList<ChiTietHoaDonBean> kq = new ArrayList<ChiTietHoaDonBean>();
		String sql = "select * from ChiTietHoaDon cthd join hoadon hd on cthd.MaHoaDon = hd.MaHoaDon where hd.makh = ?";
		PreparedStatement c;
		try {
			
			c = ThietLap.cn.prepareStatement(sql);
			c.setLong(1, maKhachHang);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				String maChiTietHD = rs.getNString(1);
				String maSach = rs.getNString(2);
				int soLuongMua = rs.getInt(3);
				long maHoaDon = rs.getLong(4);
				kq.add(new ChiTietHoaDonBean(maChiTietHD, maSach, soLuongMua, maHoaDon));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	public ArrayList<ChiTietHoaDonBean> GetDsOdertail(){
		ArrayList<ChiTietHoaDonBean> result = new  ArrayList<ChiTietHoaDonBean>() ;
		String sql= "select * from ChiTietHoaDon";
		try {
			PreparedStatement c ;
			c = ThietLap.cn.prepareStatement(sql);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				 String MaChiTietHD = rs.getString(1);
				 String	MaSach = rs.getString(2);
				 int SoLuongMua = rs.getInt(3);
				 long MaHoaDon = rs.getLong(4);
				 result.add(new ChiTietHoaDonBean(MaChiTietHD, MaSach,SoLuongMua,MaHoaDon));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
