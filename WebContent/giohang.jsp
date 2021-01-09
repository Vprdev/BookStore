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
	<title>Nhà sách Minh Khai - Giỏ hàng</title>
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

	<%@ include file="header.jsp" %>

	<div class="container">
		<div class="row cart-content">
			<%
			GioHang gioHangg = (GioHang) session.getAttribute("Gio");
			if (gioHangg != null) {
			%>
			<div class="col-md-8 cart-content-box">
				<ul class="cart-content-list">
					<%
						ArrayList<MonHang> list = gioHangg.getList(); // lấy danh sách trong giỏ hàng
						SachBO sbo = new SachBO();
						sbo.getSach();
						for (MonHang monHang : list) {
							Sach sach = sbo.find(monHang.getMaHang());
					%>
							<li class="cart-content-item">
								<div class="cart-content-item-photo">
									<img alt="" src="<%=sach.getAnh()%>">
								</div>
								<div class="cart-content-item-text-inf">
									<h5><%=sach.getTensach()%></h5>
									<p>Tác giả: <%=sach.getTacgia()%></p>
									<form method="post" action="sua.jsp?mahang=<%=monHang.getMaHang()%>">
											Số lượng: <input type="number" name="soluong"value="<%=monHang.getSoLuong()%>" min="1">
													 <input type="submit" name="chinhsua" value="Lưu">
									</form>
									<p>Đơn giá: <%=monHang.getDonGia()%></p>
									<a href="xoa.jsp?mahang=<%=monHang.getMaHang()%>"class="btn btn-danger buy" name="xoa">Xóa</a>
								</div>
								
								
							</li>
						<%}%>
				</ul>
			</div>
			<div class="col-md-4">
				<h3 >Thanh Toán</h3>
				<h4>Tổng Tiền: <span style="float: right"><%=gioHangg.tongTien()%></span></h4>
				<form action="ThanhToanController">
					<input type="submit" name="thanhtoan" value="Thanh Toán"class="btn btn-success">
				</form>
			</div>
			<%} else {%>
				<p >Bạn không có sản phẩm nào trong giỏ!</p>
			<%}%>
		</div>
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