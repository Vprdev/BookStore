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
	<%
		ArrayList<Sach> ds;
		ds = (ArrayList<Sach>)request.getAttribute("listsach");
		ArrayList<LoaiSach> listLoai = (ArrayList<LoaiSach>)request.getAttribute("listloaisach");
		int n = ds.size();
		int m = listLoai.size();
	%>
	<%@ include file="header.jsp" %>
	
	<div class="container body_container">
		<!-- slide show -->
		<div class="banner-slider">
			<div class="row">
				<div id="slideShowTop" class="carousel slide carousel-fade banner-slide-box col-md-12 col-lg 9 col-xl-9" data-ride="carousel">
					<div class="carousel-inner banner-slide-inner">
					  <div class="carousel-item banner-slide-item active">
						<img src="image_sach/slider_3.jpg" class="d-block w-100">
					  </div>
					  <div class="carousel-item banner-slide-item">
						<img src="image_sach/slider_2.jpg" class="d-block w-100">
					  </div>
					  <div class="carousel-item banner-slide-item">
						<img src="image_sach/slider_1.jpg" class="d-block w-100">
					  </div>
					</div>
					<a class="carousel-control-prev" href="#slideShowTop" role="button" data-slide="prev">
					  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					  <span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#slideShowTop" role="button" data-slide="next">
					  <span class="carousel-control-next-icon" aria-hidden="true"></span>
					  <span class="sr-only">Next</span>
					</a>
				  </div>
				<div class="banner-right col-lg-3 col-xl-3 hidden-tablet">
					<img src="image_sach/slider_banner_top.jpg" alt="">
				</div>
			</div>
		</div>
		
		<!-- body content -->
		<div class="body-content" >
			<div class="row">
				<!-- category product  -->
				<div class="col-md-4 col-lg-3 col-xl-3 mobile-category-box">
					<nav class="mobile-category" action="SachController">
						<ul class="list-group">
							<li class="list-group-item"><i class="fa fa-list"></i> Danh mục sản phẩm</li>
							
							<%for(int i=0; i<m; i++){ %>
								<li class="list-group-item" name="tag" value="<%=listLoai.get(i).getMaLoai()%>">
									<a class="list-group-item-link" href="SachController?tag=<%=listLoai.get(i).getMaLoai()%>"><%=listLoai.get(i).getTenLoai()%></a>
								</li>
							<%} %>	
						</ul>
					</nav>
					<!-- slide mini left -->
					<div class="show-mini">
						<div class="show-mini-box">
							<div class="show-mini-title"><i class="fas fa-hand-point-right"></i>Bộ sưu tập</div>
							<div id="slideshowmini-1" class="carousel slide slide-mini" data-ride="carousel">
								<div class="carousel-inner slide-show-mini-box">
								<div class="carousel-item slide-show-mini-item active">
									<img src="image_sach/slide-mini-2.jpg" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item slide-show-mini-item">
									<img src="image_sach/slide-mini-3.jpg" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item slide-show-mini-item">
									<img src="image_sach/slide-mini-4.jpg" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item slide-show-mini-item">
									<img src="image_sach/slide-mini-5.jpg" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item slide-show-mini-item">
									<img src="image_sach/slide-mini-6.jpg" class="d-block w-100" alt="...">
								</div>
								</div>
								<a class="carousel-control-prev" href="#slideshowmini-1" role="button" data-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
								</a>
								<a class="carousel-control-next" href="#slideshowmini-1" role="button" data-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
								</a>
							</div>
						</div>

						<div class="show-mini-box">
							<div class="show-mini-title"><i class="fas fa-hand-point-right"></i>Website liên kết</div>
							<div id="slideshowmini-2" class="carousel slide slide-mini" data-ride="carousel">
								<div class="carousel-inner slide-show-mini-box">
									<div class="carousel-item slide-show-mini-item active">
										<img src="image_sach/facebook-logo.jpg" class="d-block w-100" alt="...">
									</div>
									<div class="carousel-item slide-show-mini-item">
										<img src="image_sach/logo-gui-nhanh.jpg" class="d-block w-100" alt="...">
									</div>
									<div class="carousel-item slide-show-mini-item">
										<img src="image_sach/logo-gui-thuong.jpg" class="d-block w-100" alt="...">
									</div>
								</div>
								<a class="carousel-control-prev" href="#slideshowmini-2" role="button" data-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
								</a>
								<a class="carousel-control-next" href="#slideshowmini-2" role="button" data-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
								</a>
							</div>
							<div class="show-mini-detail">
								<ul class="show-mini-detail-box">
									<li class="show-mini-detail-item"><a class="show-mini-detail-link" href=""><i class="fas fa-caret-right"></i>Facebook</a></li>
									<li class="show-mini-detail-item"><a class="show-mini-detail-link" href=""><i class="fas fa-caret-right"></i>Chuyển phát nhanh</a></li>
									<li class="show-mini-detail-item"><a class="show-mini-detail-link" href=""><i class="fas fa-caret-right"></i>Chuyển phát thường</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				
				<!-- list product itemt -->
				<div class="box-product col-md-8 col-lg-9 col-xl-9 row">
						<%for(int i=0; i<n; i++){%>
							<%int j = i;
							for(; j<n&&j<i+4; j++){
								Sach sach = ds.get(j);
							%>	
							<div class="box-product-element contentPage col-6 col-md-4 col-lg-3 col-xl-3">
								<div class="box-product-element-child">
									<div class="overlay_hover">
										<div class="box-product-element-img">
											<a href="" class="product-item-link"><img class="product-item-img" src="<%=sach.getAnh() %>"></a>
										</div>
										
										<div class="box-product-element-name">
											<a class="product-name"><h2 href=""><%=sach.getTensach()%></h2></a>
											<h6 class="product-author"><%=sach.getTacgia()%></h6>
										</div>
										<div class="box-product-element-priceAuthor">
											<p class="special-price"><span class="price"><%=sach.getGia()%> đ</span></p>
										</div>
										<!-- overlay-mobile -->
										<div class="box-product-element-overlay-mobile">
											<a href="DatHangController?mahang=<%=sach.getMasach()%>" class="btn-buy-now overlay-add-cart-mobile" name="datmua">
												<i class="fa fa-shopping-cart overlay-add-cart-icon-mobile"></i>	
												<span class="overlay-add-cart-hover-mobile">Thêm vào giỏ</span>
											</a>
										</div>
									</div>
									<!-- overlay-pc -->
									<div class="box-product-element-overlay">
										<a href="DatHangController?mahang=<%=sach.getMasach()%>" class="btn-buy-now overlay-add-cart" name="datmua">
											<i  class="fa fa-shopping-cart overlay-add-cart-icon"></i>	
											<span class="overlay-add-cart-hover">Thêm vào giỏ</span>
										</a>
										<a href="#" class="overlay-view " data-toggle="modal" data-target="#view-product<%=sach.getMasach()%>">
											<i class="fa fa-eye overlay-view-icon"></i>
											<span class="overlay-view-hover">Xem nhanh</span>
										</a>
									</div>
								</div>
							</div>
							
							<!-- View product -->
							<div class=" modal fade bs-example-modal-lg" id="view-product<%=sach.getMasach()%>" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
								<div class="modal-dialog modal-lg" role="document" style="top: 15%;">
									<div class="modal-content">
										<div class="modal-header" >
											<div class="modal-tittle">
												<h3>Nhà Sách Minh Khai</h3>
											</div>
											<button type="button" class="close btn-close" data-dismiss="modal" aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<div class="modal-containar">
												<div class="row ">
													<div class="col-md-5 col-lg-5 view-product-content-left">
														<div class="pseudo-view-element-img">
															<img class="product-item-img" src="<%=sach.getAnh() %>">
														</div>
													</div>
													<div class="col-md-7 col-lg-7 view-product-content-right">
														<div class="view-product-content-top">
															<h5 class="product-name-view"><%=sach.getTensach()%></h5>
															<div class="product-price-view">
																<h5 class="product-author-view">Tác Giả: <%=sach.getTacgia()%></h5>
																<p class="special-price-view">Giá:<span class="price"><%=sach.getGia()%> đ</span></p>
															</div>
														</div>
														<div class="view-product-content-bottom">
															<a href="DatHangController?mahang=<%=sach.getMasach()%>" class="btn btn-success buy" name="datmua">Thêm vào giỏ</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<%}%>
							<%i=j;%>
						<%}%>
					<!-- pagination -->
					<ul id="pagination"></ul>
				
				</div>
				
			</div>
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