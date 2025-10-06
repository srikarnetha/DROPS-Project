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

<body>
    
<!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center header-inner-page">
    <div class="container d-flex align-items-center justify-content-between ">

      <div class="logo">
        <h1><a href="index.html">Attacker Details</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar">
        <ul>
         <!--  <li><a class="nav-link scrollto active" href="#hero">Home</a></li> -->
          <li><a class="nav-link scrollto" href="Attackers.jsp">Attacker Details</a></li>
           <li><a class="nav-link scrollto" href="FileDetails.jsp"> Uploaded Data</a></li>
          
          <li><a class="nav-link scrollto " href="admin.jsp">Logout</a></li>
         
            </ul>
          
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->

   

   <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div class="hero-container">
      <div id="heroCarousel" data-bs-interval="5000" class="carousel slide carousel-fade" data-bs-ride="carousel">

        <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>

        <div class="carousel-inner" role="listbox">

          <!-- Slide 1 -->
          <div class="carousel-item active" style="background-image: url(assets/img/slide/slide-1.jpg); height:690px;">
            <div class="carousel-container">
              <div class="carousel-content" style="height: 100%;">
               <center>

 
				<h2>ATTACKER DETAILS</h2>
				</br></br>
				<%
					String sql = "select * from attack";
							List<String> lt = Database.getAttack(sql);
							Iterator<String> itr = lt.iterator();
				%>
				<table width="80%" border="1">
					<tr>
						<th style="color: GREEN;"> File ID</th>
						<th style="color: GREEN;">Owner ID</th>
						<th style="color: GREEN;">User ID</th>
						<th style="color: GREEN;">IP Address</th>
						<th style="color: GREEN;">Date of Attacker</th>
					</tr>
					<%
						while(itr.hasNext()){
					%>
					<tr style="color: white;">
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
						<td><%=itr.next()%></td>
					</tr>
					<%
						}
					%>
				</table></center>
     
			<style>
			 body{
    width: 100%;
    height: 100%;
    
    
    }
    .navbar{
   display:inline;
    color:white;}
			</style>
                
              </div>
            </div>
          </div>

            </section><!-- End Hero --> 
</body>

</html>
