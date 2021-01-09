package bo;

import java.util.ArrayList;

import bean.ChiTietHoaDonBean;
import dao.ChiTietHoaDonDao;

public class ChiTietHoaDonBo {
	ChiTietHoaDonDao CTDao = new ChiTietHoaDonDao();
	
	public ArrayList<ChiTietHoaDonBean> Func_Bo_ChiTietHoaDon(long maKhachHang) {
		return CTDao.Func_ChiTietHoaDon(maKhachHang);
	}

}
