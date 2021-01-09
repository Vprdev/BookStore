package bean;

import java.sql.Date;

public class Sach {
	private String masach;
	private String tensach;
	private String tacgia;
	private long gia;
	private String anh;
	private String maloai;
	private String sotap;
	private long soluongcon;
	private Date ngaynhap;
	
	public String getSotap() {
		return sotap;
	}
	public void setSotap(String sotap) {
		this.sotap = sotap;
	}
	
	public long getSoluongcon() {
		return soluongcon;
	}
	public void setSoluongcon(long soluongcon) {
		this.soluongcon = soluongcon;
	}
	public String getMasach() {
		return masach;
	}
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sach(String masach, String tensach, String tacgia, long gia, String anh,
			String maloai,String sotap, long soluongcon, Date ngaynhap) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.anh = anh;
		this.maloai = maloai;
		this.sotap = sotap;
		this.soluongcon = soluongcon;
		this.ngaynhap = ngaynhap;
	}
	
	public Sach(String masach, String tensach, String tacgia, long gia, String anh,
			String maloai,String sotap, long soluongcon) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.anh = anh;
		this.maloai = maloai;
		this.sotap = sotap;
		this.soluongcon = soluongcon;
	}
	
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

}
	
	