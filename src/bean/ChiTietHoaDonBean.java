package bean;

public class ChiTietHoaDonBean {
	private String MaChiTietHD;
	private String	MaSach;
	private int	SoLuongMua;
	private long MaHoaDon;
	public ChiTietHoaDonBean() {
		super();
	}

	//chỉ  dùng  để  add dữ liệu  vào bảng  chi  tietsr  háo  đơn
	public ChiTietHoaDonBean(String maChiTietHD, String maSach, int soLuongMua, long maHoaDon) {
		super();
		this.MaChiTietHD = maChiTietHD;
		this.MaSach = maSach;
		this.SoLuongMua = soLuongMua;
		this.MaHoaDon = maHoaDon;
	}
	

	public String getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(String maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	
	

}
