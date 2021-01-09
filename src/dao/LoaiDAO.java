package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.LoaiSach;
import jdbc.ThietLap;

public class LoaiDAO {

	ArrayList<LoaiSach> list;
	ThietLap database;
	
	public LoaiDAO() {
		database = new ThietLap();
		database.connect();
		list = new ArrayList<LoaiSach>();
	}
	
	// lấy dữ liệu sql Server
	public ArrayList<LoaiSach> docDatabase() {
		list = new ArrayList<LoaiSach>();
		try {
			ResultSet data = database.getTable("loai");
			if(data == null) System.out.println("Data null");
			while(data.next()) {
				String maLoai = data.getString("maloai");
				String tenLoai = data.getNString("tenloai");
				list.add(new LoaiSach(maLoai, tenLoai));
			}
			data.close();
		} catch (SQLException e){
			System.out.println("Lỗi đọc database!");
		}
		return list;
	}
	
}
