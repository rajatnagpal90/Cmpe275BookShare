<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>CMPE 275 Book-Store</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel='stylesheet' type='text/css' media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel='stylesheet' type='text/css' media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Google Fonts -->
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sticky-navigation.css" />
<link href="${pageContext.request.contextPath}/resources/css/demo.css" rel="stylesheet" type="text/css" />
<script>
$(function() {

	// grab the initial top offset of the navigation 
	var sticky_navigation_offset_top = $('#sticky_navigation').offset().top;
	
	// our function that decides weather the navigation bar should have "fixed" css position or not.
	var sticky_navigation = function(){
		var scroll_top = $(window).scrollTop(); // our current vertical position from the top
		
		// if we've scrolled more than the navigation, change its position to fixed to stick to top, otherwise change it back to relative
		if (scroll_top > sticky_navigation_offset_top) { 
			$('#sticky_navigation').css({ 'position': 'fixed', 'top':0, 'left':0 });
		} else {
			$('#sticky_navigation').css({ 'position': 'relative' }); 
		}   
	};
	
	// run our function on load
	sticky_navigation();
	
	// and run it again every time you scroll
	$(window).scroll(function() {
		 sticky_navigation();
	});
	
	// NOT required:
	// for this demo disable all links that point to "#"
	$('a[href="#"]').click(function(event){ 
		event.preventDefault(); 
	});
	
});
</script>
</head>
<body>
	<!-- Header Part Starts Here -->
<div class="header">
	<div class="container">
	<div id="demo_top_wrapper">
	<div id="sticky_navigation_wrapper">
		<div id="sticky_navigation">
			<div class="demo_container navigation-bar">
				<div class="navigation">
					<div class="logo"><a href="index.html">BookStore</a></div>
					<span class="menu"></span>
					<script>
						$( "span.menu" ).click(function() {
						  $( ".navig" ).slideToggle( "slow", function() {
						    // Animation complete.
						  });
						});
					</script>
					<div class="navig">
						<ul>
							<li><a href="#">Buyers</a></li>
							<li><a href="#">Sellers</a></li>
							<li><a href="#">Books</a></li>
							<li><a href="feedback.html">Feedback</a></li>
							<li><a href="about.html">About</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="navigation-right">
					<ul class="user">
						<li>
							<span></span><a href="login.html">Log In</a>
						</li>
						<li>
							<span class="bascket"></span><a href="bascket.html">Basket(0)</a>
						</li>
						<li>
							<button class="search"></button>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<div class="serch">
							<form action="doSearch" method="post">
								<span>
					      			<input type="text" placeholder="Search" name="searchText" />
									<input type="submit" value="" />
								</span>
							</form>
				</div>
				<script>
					$( "button.search" ).click(function() {
					  $( ".serch" ).slideToggle( "slow", function() {
						  
					  });
					});
				</script>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<div class="container">
<section id="main">
	<div class="content">
		<!-- Banner Starts Here --->
		<div class="banner">
			<h1>Book Store</h1>
			<small>Buyers Sellers Books</small>
			<div class="ban-btn">
				<a href="#">View Books</a>
			</div>
		</div>
		<!-- Banner Ends Here --->
		<!-- Gallery Starts Here --->
		<div class="gallery">
			<div class="gallery-row">
				<div class="gallery-grid">
					<div class="grid-top img-pos"><img src="${pageContext.request.contextPath}/resources/images/p1.jpg" alt="" class="img-responsive">
						<div class="img-caption jk-t">
							<p>ROMANTIC<br>LOVE STORIES</p>
							<small>from $50.00</small>
						</div>
					</div>
					<div class="grid-bot img-pos"><img src="${pageContext.request.contextPath}/resources/images/p2.jpg" alt="" class="img-responsive">
					    <div class="img-caption jk-t">
							<p>NON-FICTION <br> REAL LIFE</p>
							<small>from $99.00</small>
					    </div>
					</div>
				</div>
				<div class="gallery-grid1">
					<div class="grid1-row1">
						<div class="g1-r2">
							<div class="twit t-wit">
								<span class="line"></span>
								<i class="twit-icon"></i>
								<span class="line"></span>
								<p>Best Seller Worldwide <br> Must Read Books Category</p>
								<small>@NYTimes </small>
							</div>
							<div class="twit img-pos"><img src="${pageContext.request.contextPath}/resources/images/p3.jpg" alt="" class="img-responsive">
							<div class="img-caption jk-t">
							<p>FICTION <br> ACTION</p>
							<small>from $99.00</small>
							</div></div>
							<div class="clearfix"></div>
						</div>
						<div class="g1-r2">
							<div class="twit img-pos"><img src="${pageContext.request.contextPath}/resources/images/p4.jpg" alt="" class="img-responsive">
								<div class="img-caption jk-t">
									<p>CARTOON</p>
									<small>from $69.00</small>
								</div>
							</div>
							<div class="twit t-wit">
								<span class="line"></span>
								<i class="twit-icon"></i>
								<span class="line"></span>
								<p>Trending Books to watch out for!</p>
								<small>@J K Rowling</small>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="grid1-row2">
						<div class="twit t-hat">
							<i class="aarow"></i>
							<p>Really</p>
							<small>Great Platform</small>
						</div>
						<div class="twit img-pos"><img src="${pageContext.request.contextPath}/resources/images/p5.jpg" alt="" class="img-responsive">
							<div class="img-caption jk-t">
									<p>Cook Books</p>
									<small>from $199.00</small>
								</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="gallery-grid">
					<div class="grid-bot t-hat">
						<i class="aarow"></i>
						<p>Buyers Sellers</p>
						<small>One Place</small>
					</div>
					<div class="grid-top img-pos"><img src="${pageContext.request.contextPath}/resources/images/p6.jpg" alt="" class="img-responsive respon">
						<div class="img-caption">
							<p>FASHION<br>ADVENTURE</p>
							<small>from $200.00</small>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div>
		<p> </p>
		</div>
		<!-- Gallery Ends Here --->
		<!--- Subscribe Bar Starts here -->
		<!--<div class="subscribe">
			<h3>sign up to receive our updates</h3>
			<p>Nulla ipsum dolor lacus, suscipit adipiscing. Cum sociis natoque penatibus et ultrices volutpat.</p>
			<div class="sub-bar">
				<span>
					<input type="text"  placeholder="Your e-mail" required="" />
					<input type="submit" value="add" />
				</span>
			</div>
		</div> -->
		<!--- Subscribe Bar Ends here -->
		<!-- Partners Starts Here --->
		<!--
		<div class="partner">
				<ul id="flexiselDemo3">
				   <li><img src="images/ss1.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="images/ss2.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="images/ss3.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="images/ss4.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="images/ss5.png" class="img-responsive" alt=""/></li>
				</ul>
				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo3").flexisel({
							visibleItems: 5,
							animationSpeed: 1000,
							autoPlay: true,
							autoPlaySpeed: 3000,    		
							pauseOnHover: true,
							enableResponsiveBreakpoints: true,
					    	responsiveBreakpoints: { 
					    		portrait: { 
					    			changePoint:480,
					    			visibleItems: 1
					    		}, 
					    		landscape: { 
					    			changePoint:640,
					    			visibleItems: 2
					    		},
					    		tablet: { 
					    			changePoint:768,
					    			visibleItems: 3
					    		}
					    	}
					    });
					    
					});
			 </script>
	         <script type="text/javascript" src="js/jquery.flexisel.js"></script>
		</div>-->
		<!-- Partners Ends Here --->
		<!-- Footer Menu Starts here --->
		<div class="footer">
			<div class="row footer-row">
			<!--	<div class="col-md-3 footer-col">
					<h3 class="ft-title">Collection</h3>
					<ul class="ft-list">
						<li><a href="#">Woman (1725)</a></li>
						<li><a href="#">Men (635)</a></li>
						<li><a href="#">Kids (2514</a></li>
						<li><a href="#">Comming Soon (76)</a></li>
					</ul>
				</div>-->
				<!--<div class="col-md-3 footer-col">
					<h3 class="ft-title">site</h3>
					<ul class="ft-list  list-h">
						<li><a href="#">Terms of Service </a></li>
						<li><a href="#">Privacy Policy </a></li>
						<li><a href="#">Copyright Policy </a></li>
						<li><a href="#">Press Kit</a></li>
						<li><a href="#">Support</a></li>
					</ul>
				</div> -->
				<!--<div class="col-md-3 footer-col">
					<h3 class="ft-title">Shop</h3>
					<ul class="ft-list list-h">
						<li><a href="#">About us</a></li>
						<li><a href="#">Shipping Metods</a></li>
						<li><a href="#">Career</a></li>
						<li><a href="contact.html">Contact</a></li>
					</ul>
				</div> -->
				<!--<div class="col-md-3 foot-cl">
					<h3 class="ft-title">social</h3>
					<p>Shoper is made with love in Warsaw,<br>2014 &copy; Template By <a href="http://w3layouts.com/">W3layouts</a></p>
					<ul class="social">
						<li><i class="fa"></i></li>
						<li><i class="tw"></i></li>
						<li><i class="is"></i></li>
					</ul>
				</div>-->
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- Footer Menu Ends here --->
	</div>
</section>
</div>
	<!-- Header Part Starts Here -->
</body>
</html>