<%@page import="bean.MonHang"%>
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
	if(request.getParameter("chinhsua") != null){
		String maHang = request.getParameter("mahang");
		int soLuong = Integer.parseInt(request.getParameter("soluong"));
		GioHang gioHang = (GioHang)session.getAttribute("Gio"); 
		MonHang mh = gioHang.find(maHang);
		if(mh != null){
			mh.setSoLuong(soLuong);
		}
		session.setAttribute("Gio", gioHang);
		response.sendRedirect("giohang.jsp");
	}
%>
</body>
</html>