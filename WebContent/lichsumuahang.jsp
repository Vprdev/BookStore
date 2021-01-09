<%@page import="bean.HoaDonBean"%>
<%@page import="bean.AdminBean"%>
<%@page import="bean.LichSuBean"%>
<%@page import="bean.ChiTietHoaDonBean" %>
<%@page import="bean.KhachHangBean" %>
<%@page import="bo.SachBO"%>
<%@page import="bean.Sach"%>
<%@page import="bean.MonHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.GioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Nhà sách Minh Khai - Lịch sử mua hàng</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="fontawesome/css/all.min.css">
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/base.css">

	 <!-- slick css -->
	 <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css" />

</head>
<body>
 <%@include file="header.jsp"%>
  
    <div class="container">
		<% ArrayList<HoaDonBean> list = (ArrayList<HoaDonBean>)session.getAttribute("hoadon");
			if(list != null){
		%>
			<table id="customers">
				<tr>
				<th>STT</th>
				  <th>Mã khách hàng</th>
				  <th>Mã hóa đơn</th>
				  <th>Ngày mua</th>
				  <th>Đã mua</th>
				</tr>
				<% int i =1;
				for(HoaDonBean order : list) {%>
					<tr>
					  <td><%=i++ %></td>
					  <td><%=order.getMakh() %></td>
					  <td><%=order.getMaHoaDon() %></td>
					  <td><%=order.getNgayMua() %></td>
					  <td><%=order.isDamua() %></td>
					</tr>
				<%} %>
			</table>
		
		<%}else{%>
			<div>
				<h4> Bạn chưa mua Sản Phẩm nào từ Cửa Hàng</h4>
			<p>Cảm ơn bạn dã chọn lựa của hàng cửa chúng  tôi!</p>
			</div>
		<%} %>
	</div>
	

	<%@ include file="footer.jsp" %>

	<script src="script/jquery3.5.1.js"></script>
	<script src="script/jquery-3.5.1.slim.min.js"></script>
	<script src="script/popper.min.js"></script>
	<script src="script/bootstrap.min.js"></script>
	<script src="script/jquery.twbsPagination.js"></script>

	
	<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script src="script/packed.js"></script>

</body>
</html>