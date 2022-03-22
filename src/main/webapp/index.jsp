<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.upload.Movie" %>
  <%@ page import="com.upload.uploadDB" %>
  <%@ page import="com.author.articleDB_util" %>
   <%@ page import="com.author.article" %>
   <%@ page session="true" %>
  

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600%7CUbuntu:300,400,500,700" rel="stylesheet">

	<!-- CSS -->

	<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
	<link rel="stylesheet" href="css/bootstrap-grid.min.css">
	<link rel="stylesheet" href="css/owl.carousel.min.css">
<!-- 	<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
	<link rel="stylesheet" href="css/nouislider.min.css"> -->
	<link rel="stylesheet" href="css/ionicons.min.css">
<!-- 	<link rel="stylesheet" href="css/plyr.css">
	<link rel="stylesheet" href="css/photoswipe.css">
	<link rel="stylesheet" href="css/default-skin.css"> -->
	<link rel="stylesheet" href="css/main.css">

	<!-- Favicons -->
	<link rel="icon" type="image/png" href="icon/favicon-32x32.png" sizes="32x32">
	<link rel="apple-touch-icon" href="icon/favicon-32x32.png">
	<link rel="apple-touch-icon" sizes="72x72" href="icon/apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="icon/apple-touch-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="144x144" href="icon/apple-touch-icon-144x144.png">

	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="Dmitry Volkov">
	<title>Deflix – Online Movies, TV Shows & Cinema</title>

</head>
<body class="body">

<% String userType = (String)session.getAttribute("user"); %>

<% ArrayList<Movie> movie=(ArrayList<Movie>)uploadDB.displayMovie(); %>
<% ArrayList<article> Article=(ArrayList<article>)articleDB_util.getArticleDetails(); %>

	
	<!-- header -->
	<header class="header">
		<div class="header__wrap">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="header__content">
							<!-- header logo -->
							<a href="index.jsp?UserId=<%= request.getParameter("UserId") %>" class="header__logo">
								<img src="img/logo2.svg" alt="">
							</a>
							<!-- end header logo -->

							<!-- header nav -->
							<ul class="header__nav">

								<li class="header__nav-item">
									<a href="movielist.jsp" class="header__nav-link">Movies</a>
								</li>
						
                               	<li class="header__nav-item">
									<a href="tvserieslist.jsp" class="header__nav-link">TV Series</a>
								</li>
								
								<li class="header__nav-item">
									<a href="articlelist.jsp" class="header__nav-link">Articals</a>
								</li>

								
								

								<!-- dropdown -->
								<li class="dropdown header__nav-item">
									<a class="dropdown-toggle header__nav-link header__nav-link--more" href="#" role="button" id="dropdownMenuMore" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="icon ion-ios-more"></i></a>

									<ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuMore">
										
										<li><a href="aboutus.jsp">About Us</a></li>
										<li><a href="contactus.jsp">Contact Us</a></li>
									</ul>
								</li>
								<!-- end dropdown -->
							</ul>
							<!-- end header nav -->

							<!-- header auth -->
							<div class="header__auth">
								<button class="header__search-btn" type="button">
									<i class="icon ion-ios-search"></i>
								</button>
							
								
								
								<% if (userType != null && userType.equals("RegisteredUser")) {%>
								<li class="header__nav-item" id="login">
									<a href="login" class="header__nav-link">Log out</a>
								</li>
								<a href="user?command=ACCOUNT&UserId=<%= session.getAttribute("userId")%>" class="header__sign-in" id="signin">
									<i class="icon ion-ios-log-in"></i>
									<span>Account</span>
								</a>
								<% } %>
									
								<% if (userType == null || userType == "") {%>
								<li class="header__nav-item" id="login">
									<a href="RUserlogin.jsp" class="header__nav-link">log in</a>
								</li>
								<a href="RUserRegister.jsp" class="header__sign-in" id="signin">
									<i class="icon ion-ios-log-in"></i>
									<span>Register</span>
								</a>
								<% } %>
								
								
								
								
								
							</div>
							<!-- end header auth -->

							<!-- header menu btn -->
							<button class="header__btn" type="button">
								<span></span>
								<span></span>
								<span></span>
							</button>
							<!-- end header menu btn -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- header search -->'
		<form action="moviesearch" class="header__search" method="post">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="header__search-content">
							<input type="text" name="search" placeholder="Search for a movie, TV Series that you are looking for">

							<input type="submit" value="Search" >
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- end header search -->
	</header>
	<!-- end header -->

	<!-- home -->
	<section class="home">
		<!-- home bg -->
		<div class="owl-carousel home__bg">
			<div class="item home__cover" data-bg="img/home/home__bg.jpg"></div>
			<div class="item home__cover" data-bg="img/home/home__bg2.jpg"></div>
			<div class="item home__cover" data-bg="img/home/home__bg3.jpg"></div>
			<div class="item home__cover" data-bg="img/home/home__bg4.jpg"></div>
		</div>
		<!-- end home bg -->

		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1 class="home__title"><b>NEW ITEMS</b> OF THIS SEASON</h1>

					<button class="home__nav home__nav--prev" type="button">
						<i class="icon ion-ios-arrow-round-back"></i>
					</button>
					<button class="home__nav home__nav--next" type="button">
						<i class="icon ion-ios-arrow-round-forward"></i>
					</button>
				</div>

				<div class="col-12">
					<div class="owl-carousel home__carousel">
				<!-- card ---------------------------------------------------------------------->		
				<% 
int count;
if(movie.size()<5){
	count=movie.size();
}else{
	count=5;
}
	%>

	<% int recentcount=movie.size()-1; %>

<% for(int x=0;x<count;x++) { 
    
    Movie mv = (Movie)movie.get(recentcount);
    %>
						<div class="item">
							<!-- card -->
							<div class="card card--big">
								<div class="card__cover">
									<img src="<%out.print(mv.getFilename()); %>" alt="" width="270" height="400">
									<a href="viewmovie?mid=<% out.print(mv.getId()); %>" class="card__play">
										<i class="icon ion-ios-play"></i>
									</a>
								</div>
								<div class="card__content">
									<h3 class="card__title"><a href="viewmovie?mid=<% out.print(mv.getId()); %>"><%out.print(mv.getName()); %></a></h3>
									<span class="card__category">
										<a href="viewmovie?mid=<% out.print(mv.getId()); %>"><%
										
										out.print(mv.getLanguage());
										%></a>
									</span>
									<span class="card__rate"><i class="icon ion-ios-star"><%out.print(mv.getRating()); %></i></span>
								</div>
							</div>
							<!-- end card -->
						</div>

						<%
recentcount--;

} %>
                    <!-- card ------------------------------------------------------->
					

					
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- end home -->

	

						<!-- end card -->

					<!-- section btn -->
					<div class="col-12">
						<a href="movielist.jsp" class="section__btn">Show more</a>
					</div>
					<!-- end section btn -->
				</div>


	<!-- expected premiere -->
	<section class="section section--bg" data-bg="img/section/section.jpg">
		<div class="container">
			<div class="row">
				<!-- section title -->
				<div class="col-12">
					<h2 class="section__title">Recent Articles</h2>
				</div>
				<!-- end section title -->
					<% 
int countt;
if(Article.size()<7){
	countt=Article.size();
}else{
	countt=7;
}
	%>

	<% int recentcountt=Article.size()-1; %>			
				
	<% for(int x=0;x<countt;x++) { 
    
    article mv = (article)Article.get(recentcountt);
    %>
				
				


				<!-- card -->
				<div class="col-6 col-sm-4 col-lg-3 col-xl-2">
					<div class="card">
						<div class="card__cover">
							<img src="img/book.png" alt="">
							<a href="singlearticle.jsp?articleid=<% out.print(mv.getID()); %>" class="card__play">
								<i class="icon ion-ios-play"></i>
							</a>
						</div>
						<div class="card__content">
							<h3 class="card__title"><a href="singlearticle.jsp?articleid=<% out.print(mv.getID()); %>"><% out.print(mv.getName()); %></a></h3>
							<span class="card__category">
								<a href="singlearticle.jsp?articleid=<% out.print(mv.getID()); %>"><% out.print(mv.getCategory()); %></a>
								
							</span>
							<span class="card__rate"><i class="icon ion-ios-star"></i><% out.print(mv.getRating()); %></span>
						</div>
					</div>
				</div>
				<!-- end card -->
				
									<%
recentcountt--;

} %>	
				

			
			</div>
		</div>
	</section>
	<!-- end expected premiere -->

	<!-- partners -->
	<section class="section">
		<div class="container">
			<div class="row">
				<!-- section title -->
				<div class="col-12">
					<h2 class="section__title section__title--no-margin">From Us to You</h2>
				</div>
				<!-- end section title -->

				<!-- section text -->
				<div class="col-12">
					<p class="section__text section__text--last-with-margin">With us, you can watch free TV shows and HD movies. Our website offers a high-quality, virus-free, and completely secure service. Download the best content by registering for free on our website today. Using our website, you can read articles and reviews written by previous viewer about movies and TV shows.. We hope you enjoy your movie nights with us.</p>
				</div>
				<!-- end section text -->
			</div>
		</div>
	</section>
	<!-- end partners -->

	<!-- footer -->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<!-- footer list -->
				<div class="col-12 col-md-3">
					<h6 class="footer__title">Download Our App</h6>
					<ul class="footer__app">
						<li><a href="#"><img src="img/Download_on_the_App_Store_Badge.svg" alt=""></a></li>
						<li><a href="#"><img src="img/google-play-badge.png" alt=""></a></li>
					</ul>
				</div>
				<!-- end footer list -->

				<!-- footer list -->
				<div class="col-6 col-sm-4 col-md-3">
					<h6 class="footer__title">Resources</h6>
					<ul class="footer__list">
						<li><a href="movielist.jsp">Movies</a></li>
						<li><a href="tvserieslist.jsp">TV Series</a></li>
						<li><a href="articlelist.jsp">Articals</a></li>
					</ul>
				</div>
				<!-- end footer list -->

				<!-- footer list -->
				<div class="col-6 col-sm-4 col-md-3">
					<h6 class="footer__title">Legal</h6>
					<ul class="footer__list">
						<li><a href="aboutus.jsp">About Us</a></li>
						<li><a href="contactus.jsp">Contact Us</a></li>
						<li><a href="#">Terms of Use</a></li>
						<li><a href="#">Privacy Policy</a></li>
						
						<li><a href="#">Help</a></li>
					</ul>
				</div>
				<!-- end footer list -->

				<!-- footer list -->
				<div class="col-12 col-sm-4 col-md-3">
					<h6 class="footer__title">Contact</h6>
					<ul class="footer__list">
						<li><a href="tel:+18002345678">+1 (000) 000-0000</a></li>
						<li><a href="#">deflix.com</a></li>
					</ul>
					<ul class="footer__social">
						<li class="facebook"><a href="#"><i class="icon ion-logo-facebook"></i></a></li>
						<li class="instagram"><a href="#"><i class="icon ion-logo-instagram"></i></a></li>
						<li class="twitter"><a href="#"><i class="icon ion-logo-twitter"></i></a></li>
						<li class="vk"><a href="#"><i class="icon ion-logo-vk"></i></a></li>
					</ul>
				</div>
				<!-- end footer list -->

				<!-- footer copyright -->
				<div class="col-12">
					<div class="footer__copyright">
						<small><a target="_blank" href="#">OOP Project Team</a></small>

						<ul>
							<li><a href="adminlogin.jsp">Admin Login</a></li>
							<li><a href="authorlogin.jsp">Author Login</a></li>
						</ul>
					</div>
				</div>
				<!-- end footer copyright -->
			</div>
		</div>
	</footer>
	<!-- end footer -->

	<!-- JS -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.mousewheel.min.js"></script>
	<script src="js/jquery.mCustomScrollbar.min.js"></script>
	<script src="js/wNumb.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/plyr.min.js"></script>
	<script src="js/jquery.morelines.min.js"></script>
	<script src="js/photoswipe.min.js"></script>
	<script src="js/photoswipe-ui-default.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>