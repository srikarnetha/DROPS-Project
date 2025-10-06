<!DOCTYPE html>
  <%@page import="com.Database.Database"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.util.Iterator"%>
<html lang="en">

<head>
  <meta charset="utf-8">
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

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
  
  
  <title></title>
  
</head>

<body>
<!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center header-inner-page">
    <div class="container d-flex align-items-center justify-content-between ">

      <div class="logo">
        <h1><a href="index.html">Alstar</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto " href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="upload.jsp">Upload Data</a></li>
          <li><a class="nav-link scrollto" href="ViewOwnFile.jsp">View Data</a></li>
          <li><a class="nav-link scrollto " href="search.jsp">Search Data</a></li>
          <li><a class="nav-link scrollto" href="fsearch.jsp">Searched Data</a></li>
          <li><a class="nav-link scrollto" href="apfiles.jsp">View Key</a></li>
          <li><a class="nav-link scrollto" href="Loin.html">Logout</a></li>
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
          <div class="carousel-item active" style="background-image: url(assets/img/slide/slide-1.jpg);">
            <div class="carousel-container">
              <div class="carousel-content">




<style>  
        table{  
            border-collapse: collapse;  
            width: 100%;   
        }  
    th,td{  
        border: 2px solid green;   
        padding: 15px;  
    }  
               
    </style>  
  

 

      
       
     <table width="100%" border="1"; style=" color: white;"><thead>
<tr >

<th>File ID</th>
<th>User Name</th>
<th>FILE NAME</th>
<th>FILE Key</th>
<th>Encrypted Data</th>
</tr>
<%
try{
ResultSet r=Database.getUp();
while(r.next())
{

		%>
		<tr >
		<td><%=r.getString(1) %></td>
		<td><%=r.getString(2) %></td>
		<td><%=r.getString(3) %></td>
		<td><%=r.getString(6) %></td>
		<td><%=r.getString(7) %></td>
		</tr>
		<%
	
}
}catch(SQLException e)
{
	e.printStackTrace();
}
%></thead>
</table>
		
              </div>
            </div>
          </div>

            </section><!-- End Hero -->


</body>

</html>