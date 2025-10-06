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


 <style>  
        table{  
            border-collapse: collapse;  
            width: 100%;   
        }  
    th,td{  
        border: 2px solid lightgreen;   
        padding: 15px;  
    }  
               
    </style>    
       <h1><b style="color: white;">View Key</b></h1>
				<%
					session = request.getSession(false);
					String sql = "select fid from keyreq where userid='"+session.getAttribute("uid")+"' and status='Approved'";
					List<String> lt = Database.getFid(sql);
					Iterator<String> itr = lt.iterator();
					
				%>
				<table width="100%" border="1 solid red">
					<thead>
						<tr>
							<th style="color: Grey;">File ID</th>
							<th style="color: Grey;">Generated Key</th>
							<th style="color: Grey;">Hash Key</th>
							<th style="color: Grey;">Download Data</th>
						</tr>
					</thead>
					<%
						while(itr.hasNext()){
								String fid = itr.next();
								sql = "select * from ukeys where fid='"+fid+"' and userid='"+session.getAttribute("uid")+"'";
								if(Database.getData(sql) == true){
								sql = "select * from ukeys where fid='"+fid+"'";
								List<String> lt1 = Database.getUKeys(sql);
								
								
								Iterator<String> itr1 = lt1.iterator();
								while(itr1.hasNext()){
					%>
					<tbody>
						<tr>
							<td style="color: white;"><%=fid%></td>
							<td style="color: white;"><%=itr1.next()%></td>
							<td style="color: white;"><%=itr1.next()%></td>
							<td style="color: white;"><a href="download.jsp?fid=<%=fid%>" class="actions">DOWNLOAD</a></td>
						</tr>
					</tbody>
					<%
								}
						}else{
							/* System.out.println("hilal"); */
							sql = "select * from upload where fid='"+fid+"'";
							List<String> lt1 = Database.getKeys(sql);
							Iterator<String> itr1 = lt1.iterator();
							while(itr1.hasNext()){
								%>
								<tbody>
									<tr>
										<td style="color: white;"><%=fid%></td>
										<td style="color: white;"><%=itr1.next()%></td>
										<td style="color: white;"><%=itr1.next()%></td>
										<td><a href="download.jsp?fid=<%=fid%>" class="actions">DOWNLOAD FILE</a></td>
									</tr>
								</tbody>
								<%
							}
						}
								}
					%>
				</table>
				</form></div></div></div></div></div></div></section>
   


</body>

</html>