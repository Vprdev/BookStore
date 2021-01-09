package bo;

import java.util.ArrayList;

import bean.LichSuBean;
import bean.MonHang;

public class LichSuBo {
	private ArrayList<LichSuBean> list;
	
		public LichSuBo() {
		this.list = new ArrayList<LichSuBean>();
	}
	
	public ArrayList<LichSuBean> getList(){
		return list;
	}
}
