<%@page import="bean.Sach"%>
<%@page import="bo.SachBO"%>
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
	gioHang.remove(maHang);
	response.sendRedirect("giohang.jsp");
%>
</body>
</html>