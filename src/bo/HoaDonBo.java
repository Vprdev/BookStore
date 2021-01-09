package bo;

import java.util.ArrayList;

import bean.HoaDonBean;
import dao.HoaDonDao;

public class HoaDonBo {
	HoaDonDao dao = new  HoaDonDao();
	public  ArrayList<HoaDonBean> getHoaDon(Long username){
		return dao.timKiemTheoUser(username);//tryền từ khách mà ko 
	}
	public ArrayList<HoaDonBean> getAll(){ 
		return dao.getAll();
	}
	
}
