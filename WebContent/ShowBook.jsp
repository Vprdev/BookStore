<%@page import="bean.AdminBean"%>
<%@page import="bean.Sach"%>
<%@page import="bo.SachBO"%>
<%@page import="bo.HoaDonBo"%>
<%@page import="bean.HoaDonBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Book Store</title>
        <link href="admin/dist/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
     <!--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="admin.jsp">BookStore</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </div>
            </form>
            <%  
    			response.setCharacterEncoding("UTF-8");
    			request.setCharacterEncoding("UTF-8");
            	AdminBean Admin1=(AdminBean) session.getAttribute("admin");
            	session.setAttribute("UserKh1",Admin1 ); %>
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user fa-fw"></i>
                    	<%if(Admin1  != null) {%>
	                    	<%=Admin1.getHo()+" "+Admin1.getTen()%>
	                    <%} %>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Settings</a>
                        <a class="dropdown-item" href="#">Activity Log</a>
                        <%if(Admin1  != null) {%>
                        <a class="dropdown-item" href="LogOutAdmin">Logout</a>
                        <%}else{ %>
                        <a class="dropdown-item" href="login.jsp">Login</a>
                        <%} %>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="admin.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Layouts
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.jsp">Static Navigation</a>
                                    <a class="nav-link" href="layout-sidenav-light.jsp">Light Sidenav</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Pages
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="login.jsp">Login</a>
                                            <%if(Admin1 != null && Admin1.isQuyen() == true){ %>
                                            <a class="nav-link" href="register.jsp">Register</a>
                                            <%} %>
                                            <a class="nav-link" href="password.jsp">Forgot Password</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                         Edit Books
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                           <%if(Admin1 == null) {%>
                                       		<a class="nav-link" href="ShowBook.jsp">Show Books</a>
                                       <%} else{%>
                                        <%if(Admin1.isQuyen() == true){ %>
                                            <a class="nav-link" href="Edit.jsp">EDIT Books</a>
                                            <a class="nav-link" href="FormSuaSach.jsp">ADD Books</a>
                                            <a class="nav-link" href="ShowBook.jsp">Show Books</a>
                                           <%}else {%>
                                           	<a class="nav-link" href="ShowBook.jsp">Show Books</a>
                                           <%} }%>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="charts.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts
                            </a>
                            <a class="nav-link" href="table.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Tables
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start BookStore
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Tables</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="admin.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Tables</li>
                        </ol>
                      <!--   <div class="card mb-4">
                            <div class="card-body">
                                DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the
                                <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                                .
                            </div>
                        </div> -->
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                DataTable Books
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                  <th>Mã Sách</th>
												  <th>Tên Sách</th>
												  <th>Tác giả</th>
												  <th>Giá</th>
												  <th>Old image</th>
												  <th>Số lượng</th>
												  <th>New image</th>
												  <!-- <th>Edit</th> -->
												  <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <!-- <tfoot>
                                            <tr>
                                                  <th>Mã Sách</th>
												  <th>Tên Sách</th>
												  <th>Tác giả</th>
												  <th>Giá</th>
												  <th>Old image</th>
												  <th>Số lượng</th>
												  <th>New image</th>
                                            </tr>
                                        </tfoot> -->
                                     <% SachBO bo2 = new SachBO() ;
										ArrayList<Sach> list2 = new ArrayList<Sach>();
										list2 = bo2.getSach();
										%>
                                        <tbody>
                             			<%for(Sach order : list2) {%>
	                             			 <tr>
	                                               <td><%=order.getMasach() %></td>
												  <td><%=order.getTensach() %></td>
												  <td><%=order.getTacgia() %></td>
												  <td><%=order.getGia() %>đ</td>
												  <td><%=order.getAnh() %></td>
												  <td><%=order.getSoluongcon() %></td>
												  <td><%=order.getAnh() %></td>
												  <td><span class="delete_book" data-toggle="modal" data-target="#<%=order.getMasach()%>">delete</span></td>
												  
	                                          </tr>
	                                          
	                                          <div class="modal fade" id="<%=order.getMasach()%>" role="dialog">
											    <div class="modal-dialog">
											    
											      <!-- Modal content-->
											      <div class="modal-content">
												        <div class="modal-header">
												          <button type="button" class="close" data-dismiss="modal">&times;</button>
												        </div>
												        <div class="modal-body">
												          <p>Bạn có chắc là muốn  xóa <%=order.getTensach() %> không?</p>
												        </div>
												        <div class="modal-footer">
												        <a  href="XoaSachController?masach=<%=order.getMasach()%>"> Delete</a>
												          <button type="button" class="btn btn-default" data-dismiss="modal">Quay lại</button>
												        </div>
												    </div>
											    </div>  
										 	</div>
	                                          <%} %>
                                        </tbody>
                                        
                                    </table>
                                    
									
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
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
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="admin/dist/assets/demo/datatables-demo.js"></script>
    </body>
</html>
