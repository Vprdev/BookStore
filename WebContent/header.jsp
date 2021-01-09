<%@page import="bean.AdminBean"%>
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
<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<script src="script/jquery3.5.1.js"></script>

<div class="header-menu-top">
	<!-- button Login & sign up -->
	<ul class="header-menu-top-box">
		 <% AdminBean admin = (AdminBean) session.getAttribute("admin");
		   KhachHangBean khLogin=(KhachHangBean) session.getAttribute("user");
		   session.setAttribute("UserKh",khLogin );
		%>
		<li class="header-menu-top-item" data-toggle="modal"
			<% if(khLogin == null){%>
				data-target= "#modalLoginForm"
				<%} %>>
		  <% 
			 if(khLogin != null){
				 out.print("Hello! "+khLogin.getHoten()); 
				 System.out.println("get user tu session thanh cong!"); 	
			 }
			  if(admin != null) {
				  out.print("Hello! Admin");
			  }
			 if(khLogin == null && admin == null){
				 out.print("<a class='icon_home_content' ><i class='fa fa-lock'></i> Login</a>");
				 System.out.println("get admin tu session that bai");	
			 }
		  %> 
		  
		</li>
		<%if(khLogin == null && admin ==null){ %>
			<li class="header-menu-top-item">
				<a class=" icon_home_content item-user" data-toggle="modal" data-target="#modalRegisterForm" >
					<i class="icon_user color_white far fa-user"></i>Sign up
				</a>
		<%}%></li>
		
		<%
			if(khLogin != null || admin !=null){%>
				<%System.out.println("đăng nhập thành công"); %>
					<li class="header-menu-top-item">
						<a class="icon_home_content" href="DangXuat"><i class="fas fa-sign-out-alt"></i>LogOut</a> 
					</li>
			  <%} %>
			  
		<li class="header-menu-top-item hidden-mobile-tablet"><a class='icon_home_content' href="ThanhToanController"><i class="fa fa-check-square"></i>Thanh Toán</a></li>
	</ul>
</div>
<div class="header-menu">
	<div class="container">
		
		<div class="header-menu-logo">
			<ul class="header-menu-logo-list">
				<li class="header-menu-logo-list-item logo-page"><a href="SachController"><img src="image_sach/minhkhai-logo.png"></a></li>
				<li class="header-menu-logo-list-item hidden-mobile-tablet"><i class="fas fa-cube"></i>GIAO HÀNG FREE</li>
				<li class="header-menu-logo-list-item hidden-mobile-tablet"><i class="fas fa-exchange-alt"></i>ĐỔI TRẢ FREE</li>
				<li class="header-menu-logo-list-item hidden-mobile-tablet"><i class="fas fa-life-ring"></i>HỖ TRỢ 24/7</li>	
				
			</ul>
		</div>
	</div>
</div>
<div class="header-menu-bottom">
	<% GioHang gioHang =(GioHang) session.getAttribute("Gio");
		int soluong = 0;
		if(gioHang != null)
		soluong =gioHang.getList().size() ;
	%>
	<div class="container header-menu-bottom-overlay">
		<!-- Menu -->
		<ul class="header-menu-bottom-box">
			<li class="header-menu-bottom-item"><a href="SachController">Trang chủ</a></li>
			<li class="header-menu-bottom-item"><a href="GioiThieuController">Giới thiệu</a></li>
			<li class="header-menu-bottom-item"><a href="LichSuMuaHangController">Lịch Sử Mua Hàng</a></li>		
			<li class="header-menu-bottom-item" style="border: none;"><a href="ChiTietHoaDonController">Chi tiết hóa đơn</a></li>
			
		</ul>
		
		<div class="search-item" >
			<form action="SachController" class="header-menu-bottom-item-button">
				<input type="text" class="form-control" placeholder="Search" name="search">
				<button class="btn btn-default" type="submit"><i class="fas fa-search"></i></button>
			</form>
		</div>

		<div class="header-menu-logo-list-item-cart"><a href="GioHangController"><i class="fas fa-shopping-cart"></i>
			<span class="label-cart">
				<%if(soluong !=0){%><%=soluong %>
				<%}else%> 0
			</span></a>
		</div>		
	</div>
</div>
<!-- Form Login-->
<form action="LoginController" method="post"  class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"aria-hidden="true">
	<div class="modal-dialog" role="document" style="top: 15%;">
	  <div class="modal-content form-elegant">
		<div class="modal-header">
		  <h3 class="modal-title" id="myModalLabel">Login</h3>
		  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
		
		<div class="modal-body">
			<div class="md-form ">
				<label class="element-required" data-error="wrong" data-success="right" for="Form-email1">UserName</label>
				<input type="name" id="Form-email1" value="${after.UserName}" name="username" placeholder="Nhập username" class="form-control validate" required>
				<span class="check-error" name="errorName">${errors.failUser}</span>
			</div>
			<div class="md-form">
				<label class="element-required" data-error="wrong" data-success="right" for="Form-pass1" >Password</label>
				<input type="password" id="Form-pass1" name="pass" placeholder="Nhập password" class="form-control validate" required>
				<span class="check-error" name="errorName">${errors.failpass}</span>
			</div>							
			<div class="forgot-password">
				<p class="forgot-password-text">Forgot <a href="#" class="forgot-password-link">Password?</a></p>
			</div>
			<div class="submit-box text-center">
				<button type="submit" class="btn btn-block ">Sign in</button>
			</div>						 
		</div>
		
		<div class="modal-footer">
		  <p class="font-small grey-text d-flex justify-content-end">Not a member?  <a href=""  class="close1" data-dismiss="modal" aria-label="Close"  data-toggle="modal" data-target="#modalRegisterForm">Sign Up</a></p>
		</div>
	  </div>
	</div>
</form>


<!-- Form Sign Up -->									
<form  action="AddAcountUser" method="post"  class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"aria-hidden="true">
	<div class="modal-dialog" role="document" style="top: 10%;">
		<!--Content-->
		<div class="modal-content form-elegant">
			<div class="modal-header">
				<h3 class="modal-title" id="myModalLabel">Sign Up</h3>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="md-form">
					<label class="element-required" data-error="wrong" data-success="right" for="Form-Yrname">Full Name</label>
					<input type="name" value="${after.inputName}" name="inputName"  placeholder="Họ và tên" id="Form-Yrname"  class="form-control validate" required>
					<span class="check-error" name="errorName">${errors.YrName}</span> 
				</div>
				<div class="md-form">
					<label class="element-required" data-error="wrong" data-success="right" for="Form-Usname">UserName</label>
					<input type="name" id="Form-Usname" value="${after.username}"  name="username" placeholder="Tên đăng nhập" class="form-control validate" required>
					<span class="check-error" name="errorName">${errors.UsName}</span> 
				</div>
				<div class="md-form">
					<label class="element-required" data-error="wrong" data-success="right" for="Form-email1">Email</label>
					<input type="email" id="Form-email1" value="${after.email}"   name="email" placeholder="Email" class="form-control validate" required>
					<span class="check-error" name="errorName">${errors.Email}</span> 
				</div>
				<div class="md-form">
					<label class="element-required" data-error="wrong" data-success="right" for="Form-pass1">Password</label>
					<input type="password" id="Form-pass1" value="${after.password}"  name="password" placeholder="Password" class="form-control validate" required>
					<span class="check-error" name="errorName">${errors.Pass}</span> 
				</div>
				<div class="md-form">
					<label class="element-required" data-error="wrong" data-success="right" for="Form-phone">Number phone</label>
					<input type="text" id="Form-phone" value="${after.phone}" name="phone" placeholder="Số điện thoại" class="form-control validate" required>
					<span class="check-error" name="errorName">${errors.Phone}</span> 
				</div>
				<div class="md-form">
					<label class="element-required" data-error="wrong" data-success="right" for="Form-address">Address</label>
					<input type="address" id="Form-address" value="${after.address}" name="address" placeholder="Địa chỉ" class="form-control validate" required>
					<span class="check-error" name="errorName">${errors.Address}</span> 
				</div>							
				<div class="md-form">
					<span class="error" name="error-confirm-password"style="color:red;">${errors.signup_fail}</span>
				</div>						 
				<div class="submit-box text-center">
					<button type="submit" class="btn btn-block">Sign Up</button>
				</div>
			</div>
			<div class="modal-footer mx-5 pt-3 mb-1">
				<p class="font-small grey-text d-flex justify-content-end">Have Account ?<a href="" class="close1" data-dismiss="modal" aria-label="Close" 
				data-toggle="modal" data-target="#modalLoginForm">Login</a></p>
			</div>
		</div>
	</div>
</form>
<!-- menu mobile tablet-->
<div class="menu-mobile">
	<label for="nav-input-mobile-tablet" class="menu-mobile-tablet"><i class="fas fa-bars menu-mobile-icon"></i></label> 
	<input type="checkbox" hidden name="" class="nav-input-check" id="nav-input-mobile-tablet">
	<label for="nav-input-mobile-tablet" class="overlay-mobile-tablet"></label> 
	<nav class="header-menu_mobile-tablet">
		<ul class="nav_mobile-tablet-list">
			<li class="nav_mobile-tablet-item">
				<a class="nav_mobile-tablet-link" href="SachController"><i class="fas fa-angle-right"></i>Trang chủ</a>
			</li>
			<li class="nav_mobile-tablet-item">
				<a class="nav_mobile-tablet-link" href="GioiThieuController"><i class="fas fa-angle-right"></i>Giới thiệu</a>
			</li>
			<li class="nav_mobile-tablet-item">
				<a class="nav_mobile-tablet-link" href="LichSuMuaHangController"><i class="fas fa-angle-right"></i>Lịch sử mua hàng</a>
			</li>
			<li class="nav_mobile-tablet-item">
				<a class="nav_mobile-tablet-link" href="ChiTietHoaDonController"><i class="fas fa-angle-right"></i>Chi tiết hóa đơn</a>
			</li>
			<li class="nav_mobile-tablet-item">
				<a class="nav_mobile-tablet-link" href="ThanhToanController"><i class="fas fa-angle-right"></i>Thanh toán</a>
			</li>
		</ul>
	</nav>    
</div>

	<% if((boolean)session.getAttribute("ShowLoginForm") == true){ %> 
		<script type="text/javascript">
		        $(window).on('load',function(){
		            $('#modalLoginForm').modal('show');
		        });
		</script>
		 <% session.removeAttribute("ShowLoginForm"); 
	 } %>
	<% if((boolean)session.getAttribute("ShowSignUPForm") == true && khLogin == null ){ %> 
		<script type="text/javascript">
		        $(window).on('load',function(){
		            $('#modalRegisterForm').modal('show');
		        });
		</script>
		<% session.removeAttribute("ShowSignUpForm"); 
	}%>
	
	