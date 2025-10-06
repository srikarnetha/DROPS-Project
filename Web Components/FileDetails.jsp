<%@page import="com.Database.Database"%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

    
    <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">


</head>

<style>

ul{

float: left;
list-style-type: none;

}
ul li{

float: left;
padding: 10px;

}

a:hover {
	background-color: grey;
}

</style>
</head>

<body style="background-image:url(assets/img/slide/slide-1.jpg) ">
    
<!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center header-inner-page">
    <div class="container d-flex align-items-center justify-content-between ">

      <div class="logo">
        <h1><a href="#">Data</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar">
        <ul style="color: white;">
          <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="Attackers.jsp">Attackers Details</a></li>
           
          <li><a class="nav-link scrollto " href="admin.jsp">Logout</a></li>
         
            </ul>
          
       
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->

   <br/><br/><br/><br/><br/><br/>
     
<div class="container" >
    <center>

 
				<h2 style="color: green;">File DETAILS</h2>
				</br></br>
				<%
					String sql = "select * from upload";
							List<String> lt = Database.getUploadDetails(sql);
							Iterator<String> itr = lt.iterator();
				%>
				<table width="80%" border="1">
					<tr>
						<th style="color: GREEN;">  FID</th>
						<th style="color: GREEN;">UserID</th>
						<th style="color: GREEN;">FNAME</th>
						<th style="color: GREEN;">ENCRYPTED DATA</th>
						
						
					</tr>
					<%
						while(itr.hasNext()){
					%>
					<tr style="color: white;">
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
						
					</tr>
					<%
						}
					%>
				</table></center>

			
			</div>
			</div></div></div></div></div></div></section>
</body>

</html>
