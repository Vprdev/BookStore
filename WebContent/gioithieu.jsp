<%@page import="bean.MonHang"%>
<%@page import="bean.GioHang"%>
<%@page import="bean.KhachHangBean"%>
<%@page import="dao.XuLyDao"%>
<%@page import="bean.LoaiSach"%>
<%@page import="bo.LoaiBO"%>
<%@page import="dao.LoaiDAO"%>
<%@page import="bean.Sach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.SachBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nhà sách Minh Khai</title>
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
	<div class="container content-introduce">
		<p>
			Từ năm 1998 đến nay, Nhà sách Minh Khai đã và đang tiếp tục nhận được sự tín nhiệm của đông đảo bạn đọc gần xa 
			cũng như sự tín nhiệm của các cơ quan, trường học trong và ngoài nước. Sự tín nhiệm đó chính là nguồn động lực lớn 
			giúp Nhà sách luôn cố gắng hoàn thiện hơn nữa để phục vụ quý khách ngày một tốt hơn.
		</p>
		<p>
			Với tổng diện tích 1.200m2, không gian rộng rãi, trang bị máy lạnh thoáng mát, đội ngũ nhân viên phục vụ ân cần. 
			Chủng loại sách phong phú với khoảng 35.000 đầu sách, đa dạng các mặt hàng: Văn phòng phẩm, Dụng cụ học sinh, 
			Băng đĩa, Quà lưu niệm, Đồ chơi, …
		</p>
		<p>Nhà sách Minh Khai chuyên cung cấp sỉ và lẻ các mặt hàng sau tại chỗ hoặc tận nơi theo yêu cầu, nhanh chóng và tiện lợi:</p>
		
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