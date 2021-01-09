package bean;

public class salary {
	private String Masach ;
	public salary() {
		super();
	}
	public salary(String masach, String tensach, double soluongmua, long gia) {
		super();
		Masach = masach;
		this.tensach = tensach;
		this.soluongmua = soluongmua;
		this.gia = gia;
	}
	public String getMasach() {
		return Masach;
	}
	public void setMasach(String masach) {
		Masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public double getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(double soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	private String tensach;
	private double soluongmua;
	private long gia;
}
