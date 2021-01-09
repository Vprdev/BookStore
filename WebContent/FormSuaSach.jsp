<%@page import="bo.LoaiBO"%>
<%@page import="bo.SachBO"%>
<%@page import="bean.LoaiSach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Sach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Register Admin</title>
        <link href="admin/dist/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
    <%request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	  SachBO bo = new SachBO();
	  String masach =request.getParameter("masach_select"); 
	  if(masach != null &&!masach.isEmpty()) {
		  Sach sach1 =new Sach(); 
		  sach1 = bo.Find(masach);
	  System.out.println(sach1.getTensach()); 
	  session.setAttribute("Sach", sach1);
	  }else session.removeAttribute("Sach"); 
    Sach sach =(Sach) session.getAttribute("Sach"); %>
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7" style="margin-top: -24px;margin-bottom: 22px;">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header" style="height: 79px;"><h3 class="text-center font-weight-light my-4" style="margin-top: 8px !important;margin-bottom: 0 !important;">
                                    Create Books
                                    </h3>
                                 </div>
                                    <div class="card-body">
                                        <form method="post" action="NhapController" enctype= "multipart/form-data">
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputFirstName">Mã sách</label>
                                                        <input class="form-control py-4" type="text" name="txtmasach" <%if(sach != null){ %> value="<%=sach.getMasach() %>" <%} %> required/>
                                                       <%--  <span  style="color: red;">${errors.errorFirstName}</span> --%>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputLastName">Tác Giả</label>
                                                        <input class="form-control py-4" type="text" name="txttacgia"  <%if(sach != null){ %> value="<%=sach.getTacgia() %>" <%} %> required>
                                                       <%--  <span  style="color: red;">${errors.errorLastName}</span> --%>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">Giá</label>
                                                        <input class="form-control py-4" type="number" name="txtgia"  <%if(sach != null){ %> value="<%=sach.getGia()%>" <%} %> required />
                                                        <%-- <span  style="color: red;">${errors.errorpass}</span> --%>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputConfirmPassword">Số lượng</label>
                                                        <input class="form-control py-4" type="number" name="txtsoluong"  <%if(sach != null){ %> value="<%=sach.getSoluongcon()%>" <%} %> required />
                                                        <%-- <span  style="color: red;">${errors.errorpass2}</span> --%>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">Ngày nhập</label>
                                                        <input class="form-control py-4" type="date" name="txtngaynhap"  <%if(sach != null){ %> value="<%=sach.getNgaynhap()%>" <%} %> required />
                                                        <%-- <span  style="color: red;">${errors.errorpass}</span> --%>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputConfirmPassword">Tên Sách</label>
                                                        <input class="form-control py-4 " type="text" name="txttensach" <%if(sach != null){ %> value="<%=sach.getTensach() %>" <%} %> required  />
                                                       <%--  <span  style="color: red;">${errors.errorpass2}</span> --%>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">Ảnh</label>
                                                <input style="height: 20%;" class="form-control " type="file" name="txtanh"required />
                                               <%--  <span  style="color: red;">${errors.errorEmail}</span> --%>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputPassword">Số Tập</label>
                                                        <input class="form-control py-4" type="number" name="txtsotap"  <%if(sach != null){ %> value="<%=sach.getSotap() %>" <%} %> required/>
                                                        <%-- <span  style="color: red;">${errors.errorpass}</span> --%>
                                                    </div>
                                                </div>
                                                <%LoaiBO bo1 = new LoaiBO();
													 ArrayList<LoaiSach> list = new ArrayList<LoaiSach>();
													 list = bo1.getLoaiSach();
												%>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="small mb-1" for="inputConfirmPassword">Mã Loại</label>
                                                        <select style="height: 50px;" class="form-control" name="PasswordAdmin2" id="inputConfirmPassword" >
                                                        	<%if(sach != null){ %>
															   			<option  >
															   			<%=sach.getMaloai() %>
																		</option>	
																<%}else{ %>
															 		<%for(LoaiSach loai :list){ %>
																		 <option>
																				<%=loai.getTenLoai()%><%} %>
																		</option>	
																<%} %>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <button type="submit" class="form-group mt-4 mb-0 btn btn-primary" style="width: 100%">Create Books</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="admin/dist/js/scripts.js"></script>
    </body>
</html>