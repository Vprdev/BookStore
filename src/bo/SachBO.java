package bo;

import java.util.ArrayList;

import bean.Sach;
import dao.SachDAO;

public class SachBO {
	SachDAO dao = new SachDAO();
	ArrayList<Sach> list = new ArrayList<Sach>();
	
	public void SachBO() {
		this.list = new ArrayList<Sach>();
	}
	
	public ArrayList<Sach> getSach(){
		return dao.docDatabase();
	}
	
	public ArrayList<Sach> getPage( int page, int sizeOfPage){
		return dao.getPage(page, sizeOfPage);
	}
	
	public int getNumberOfPage(int sizeOfPage) {
		return  dao.getNumberOfPage(sizeOfPage);
	}
	
	public ArrayList<Sach> timTheoTenSach(String text){
		return dao.timTheoTenSach(text);
	}
	
	public ArrayList<Sach> timTheoTenTacGia(String text){
		return dao.timTheoTenTacGia(text);
	}
	
	public ArrayList<Sach> locTheoLoaiSach(String tag){
		return dao.locTheoLoaiSach(tag);
	}
	
	public Sach find(String maSach) {
		return dao.find(maSach);
	}
	public boolean DeleteSach(String masach) {
		return dao.Delete(masach);
	}
	
	public boolean UpdateBook(String masach,Object ojb) {
		return dao.UpdateBook(masach, ojb);
	}
	
	public boolean InsertBook(Object ojb) {
		return dao.InsertBook(ojb);
	}
	
	public boolean Findmasach(String masach) {
		return dao.Findmasach(masach);
	}
	public Sach Find(String  masach) {
		Sach sach = new Sach();
		sach = dao.Find(masach);
		return sach;
	}
	public int Count() {
		return dao.Count();
	}
}
