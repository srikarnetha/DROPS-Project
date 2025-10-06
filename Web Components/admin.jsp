<!DOCTYPE html>
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
          <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="LoginCSP.jsp">CServices</a></li>
          <li><a class="nav-link scrollto" href="Loin.html">Login</a></li>
          <li><a class="nav-link scrollto " href="Register.html">Register</a></li>
          
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
               <script type="text/javascript">

function checklog()
{
	
var un=document.getElementById("uname").value;
var pwd=document.getElementById("pass").value;
if(un=="csp")
	{
	if(pwd=="csp")
		{
		window.location="csphome.jsp";
		}else{
			alert("CSP LOGIN HAS FAILED")
		}
	}else{
		alert("PLEASE ENTER VALID USER NAME AND PASSWORD DETAILS !.CSP LOGIN HAS FAILED")
	}
}
</script>
  <style>  
        table{  
            border-collapse: collapse;  
            width: 100%;   
        }  
    th,td{  
        
        padding: 15px;  
    }  
               
    </style>    
  

    

        <h1><b style=" color: green;">Admin</b></h1>
		<form action="Admin" method="post" style="text-align: left;">
		
		
			<table style="color: Lightgreen;">
			<tr><td>UserId</td><td><input type="text" name="uid" style="width: 250px;"/> </td></tr>
			<tr><td>Password</td><td><input type="password" name="pwd" style="width: 250px;"/> </td></tr>
			
			<tr><td><input type="Submit" value="Login"/>	</td></tr> 
				</table>
  	
		</form>		
     
			
                <a href="index.html" class="btn-get-started scrollto animate__animated animate__fadeInUp">Home</a>
              </div>
            </div>
          </div>

            </section><!-- End Hero -->		

</body>

</html>