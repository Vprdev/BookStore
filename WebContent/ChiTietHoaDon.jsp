<%@page import="bo.ChiTietHoaDonBo"%>
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
		<%
		//ChiTietHoaDonBo bo = new ChiTietHoaDonBo();
		ArrayList<ChiTietHoaDonBean> ct = (ArrayList<ChiTietHoaDonBean>)session.getAttribute("chitiethd");
		//ct = bo.Func_Bo_ChiTietHoaDon(khLogin.getMakh());
		if(ct != null) {
	%>

		<table id="customers">
			<tr>
			<th>STT</th>
			  <th>Mã Chi Tiết hóa đơn</th>
			  <th>mã sách</th>
			  <th>Số lượng mua</th>
			  <th>mã hóa đơn</th>
			</tr>
			<% int i = 1;
			for(ChiTietHoaDonBean order : ct) {%>
			<tr>
				<td><%=i++ %></td>
			  <td><%=order.getMaChiTietHD() %></td>
			  <td><%=order.getMaSach()%></td>
			  <td><%=order.getSoLuongMua()%></td>
			  <td><%=order.getMaHoaDon() %></td>
			</tr>
			<%} %>
			</table>

		<%}else{ %>
			<h4  > Bạn chưa mua Sản Phẩm nào từ Cửa Hàng</h4>
			<p>Cảm ơn bạn dã chọn lựa của hàng cửa chúng  tôi!</p>
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