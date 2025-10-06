<!DOCTYPE html>
   <%@page import="com.Database.Database"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
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

    <section id="hero">
    <div class="hero-container">
      <div id="heroCarousel" data-bs-interval="5000" class="carousel slide carousel-fade" data-bs-ride="carousel">

        <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>

        <div class="carousel-inner" role="listbox">

          <!-- Slide 1 -->
          <div class="carousel-item active" style="background-image: url(assets/img/slide/slide-1.jpg);">
            <div class="carousel-container">
              <div class="carousel-content">


  <h1><b style="color: white;">Searched Data</b></h1>
				
				<%
					String fname = request.getParameter("sub");
					String sql = "select * from upload where fname like '%"+fname+"%'"; 
					List<String> lt = Database.getUFile(sql);
					Iterator<String> itr = lt.iterator();
				%>
				<table width="200%" border="3">
					<thead>
						<tr>
							<th style="color: grey;">File ID</th>
							<th style="color: grey;">User ID</th>
							<th style="color: grey;">FileName</th>
							<th style="color: grey;">Download</th>
							<th style="color: grey;">Key Request</th>
						</tr>
					</thead>
					<%
						while(itr.hasNext()){
							String fid = itr.next();
					%>
					<tbody>
						<tr>
							<td><%=fid%></td>
							<td><%=itr.next()%></td>
							<td><%=itr.next()%></td>
						<strong>	<td><a href="FDownload?fid=<%=fid%>" class="actions">Download</a></td></strong>
							<td><a href="KeyReq?fid=<%=fid%>" class="actions">Request</a></td>
						</tr>
					</tbody>
					<%
						}
					%>
				</table>
				</form></div></div></div></div></div></div></section>
   
		

		

</body>

</html>