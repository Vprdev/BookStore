package bean;

public class KhachHangBean {
	private long makh;
	private String hoten;
	private String tenDN;
	private String pass;
	private String phone;
	private String email;
	private String address;
	public KhachHangBean(long makh, String hoten, String tenDN, String phone, String email, String address) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.tenDN = tenDN;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	public long getMakh() {
		return makh;
	}

	public void setMakh(long makh) {
		this.makh = makh;
	}
	
	public KhachHangBean(long makh, String hoten, String tenDN, String pass, String phone, String email,
			String address) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.tenDN = tenDN;
		this.pass = pass;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public KhachHangBean( String hoten, String tenDN, String pass, String phone, String email,
			String address) {
		super();
		this.hoten = hoten;
		this.tenDN = tenDN;
		this.pass = pass;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public KhachHangBean() {
		super();
	}

	@Override
	public String toString() {
		return "KhachHangBean [ Makhachhang="+makh +  " hoten=" + hoten + ", tenDN=" + tenDN + ", pass=" + pass + ", phone="
				+ phone + ", email=" + email + ", address=" + address + "]";
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}

