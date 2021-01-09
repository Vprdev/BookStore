package jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ThietLap {
	public static Connection cn;
	private   String sqlInstance = "DESKTOP-R3447FQ\\SQLEXPRESS";
	private   String port = "1433";
	private  String database = "QlSach";
	private  String nickname = "sa";
	private  String password = "123";

	public void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection("jdbc:sqlserver://"+sqlInstance+":"+port+";databaseName="+database+";user="+nickname+";password="+password);
			System.out.println("Kết nối csdl thành công!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Kết nối csdl thất bại!");
		}	 																					
	}
	
	public static ResultSet getTable(String tb) {
		try {
			String sql = "select * from " + tb;
			PreparedStatement s = cn.prepareStatement(sql);
			return s.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

