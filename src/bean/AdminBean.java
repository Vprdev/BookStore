package bean;

public class AdminBean {
		
	private String tenDN;
	private String pass;
	private String Ho;
	private String Ten;
	private boolean quyen;
	public AdminBean() {
		super();
	}
	public AdminBean(String tenDN, String pass, String ho, String ten, boolean quyen) {
		super();
		this.tenDN = tenDN;
		this.pass = pass;
		Ho = ho;
		Ten = ten;
		this.quyen = quyen;
	}
	public String getTenDN() {
		return tenDN;
	}
	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHo() {
		return Ho;
	}
	public void setHo(String ho) {
		Ho = ho;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public boolean isQuyen() {
		return quyen;
	}
	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}

	
}
