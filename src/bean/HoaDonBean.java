package bean;

import java.sql.Date;
import java.util.ArrayList;

public class HoaDonBean {
	
	public HoaDonBean() {
		super();
	}
	private ArrayList<HoaDonBean> list;
	private long maHoaDon;
	private long makh;
	private Date ngayMua;
	private boolean damua;
	public HoaDonBean(long maHoaDon,long makh, Date ngayMua, boolean damua) {
		super();
		this.maHoaDon = maHoaDon;
		this.makh = makh;
		this.ngayMua = ngayMua;
		this.damua = damua;
	}
	
	/**
	 * Hàm tạo này chỉ để dùng cho add dữ liệu vào table hóa  đơn 
	 * @param makh
	 * @param damua
	 */
	public HoaDonBean(long makh, boolean damua) {
		this.makh = makh;
		this.damua = damua;
	}
	
	
	public long getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		maHoaDon = maHoaDon;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		ngayMua = ngayMua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	

}
