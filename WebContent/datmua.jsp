<%@page import="bean.MonHang"%>
<%@page import="bo.SachBO"%>
<%@page import="bean.Sach"%>
<%@page import="bean.GioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhà sách Minh Khai</title>
</head>
<body>
<%	
	GioHang gioHang = (GioHang)session.getAttribute("Gio"); 
	String maHang = request.getParameter("mahang");
	int soLuong = 1;
	if(gioHang == null){
		gioHang = new GioHang();
	}
	
	SachBO sbo = new SachBO();
	sbo.getSach();
	Sach sach = sbo.find(maHang);
	if(sach!=null){
		MonHang mh = new MonHang(sach.getMasach(), soLuong, sach.getGia());
		
		//thêm vào giỏ
		gioHang.add(mh);
		session.setAttribute("Gio", gioHang);
		out.print(mh.getSoLuong());
	}
	else out.print("Khong tim thay thong tin sach da dat!");
	response.sendRedirect("sach.jsp");
	%>
</body>
</html>