package dao;

import java.util.ArrayList;

//import bean.ChitiethoadonBean;
import jdbc.ThietLap;

public class LichSuMuaHangDao {
	ThietLap database;
	public LichSuMuaHangDao() {
		database = new ThietLap();
		database.connect();
	}

}
