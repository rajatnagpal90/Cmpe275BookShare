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
							<li><a href="buyers.html">Buyers</a></li>
							<li><a href="sellers.html">Sellers</a></li>
							<li><a href="books.html">Books</a></li>
							<li><a href="feedback.html">Feedback</a></li>
							<li><a href="about.html">About</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="navigation-right">
					<ul class="user">
						<li><span></span><a href="login.html">${currentView}</a></li>
									<li><span class="bascket"></span><a href="logout.html">Logout</a>
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
					    // Animation complete.
					  });
					});
				</script>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<div class="container">
<section id="main">
	<div class="content">
		<div class="pag-nav">
			<ul class="p-list">
				<li><a href="index.html">Home</a></li> &nbsp;&nbsp;/&nbsp;
				<li class="act">&nbsp;About</li>
			</ul>
		</div>
		<div class="coats">
			<h3 class="c-head">About</h3>
			<p>This is what we do only for you.</p>
		</div>
		<div class="row about-row">
			<div class="col-md-6 about-col">
				<img src="${pageContext.request.contextPath}/resources/images/about1.jpg" alt="" class="img-responsive">
				<div class="who">
					<h3>What motivated us?</h3>
					<pre>
The part of electronic commerce has been the most persuasive business use in World Wide Web. E-business has ended up being the best stage joining clients to the traders and permitting them to pursuit and purchase items from their home or from their portable devices. The business-to-trade deals from e-trade came to up to $350 billion in year 2014 and it will reach to $1.4 trillion in 2015. E-Commerce Giants like Amazon, Alibaba, and eBay has been the real players in the field of e business. Our task is expected to take in the ideas of e-trade site and how the site functions in the back-end. The goal of this project is to fabricate a web application that associates with a server in the cloud in the meantime actualizing and practicing standards and techniques of Inversion of Control, Aspect Oriented Programming, Object social mapping and exchanges. We are building San Jose Book Store web application which will incorporate all the aforementioned strategies with a few different highlights added to it. San Jose Book store is the ecommerce web application that students can use to share and offer utilized course books. We are meaning to give an online platform to SJSU students to purchase and offer books to different students. Students can enroll on our site to include posting for offering the books, give criticism to purchasers and venders, purchase and hunt books from book postings. We are utilizing JAVA spring as our back-end structure for our book shop. Our task is meant to give an answer for SJSU students to share their notes and books which can help them for their studies.
The inspiration driving this thought was that as present students of SJSU, we too confront the issue of purchasing new books each semester for all the subjects. We needed an answer for the present issue where we could without much of a stretch purchase course books at economic costs and offer them back after the semester to different students needing the book. We thought of this thought to manufacture a platform for students in a specific region to share their books, purchase or offer them. As a term project, we additionally needed to execute all the innovations we learned in the subject. We thought building up an e-trade site would fuse every one of them, subsequently, we decided to construct an online book shop application

					</pre>
				</div>
			</div>
			<div class="col-md-6 about-col">
				<img src="${pageContext.request.contextPath}/resources/images/about2.jpg" alt="" class="img-responsive">
				<div class="who">
					<h3>What we are doing?</h3>
					<pre>
Account Creation: 
User can register himself by creating profile for online trading of book. He will be presented with a login page where new user can have an option to register themselves by filling up the detailed form. The form will contain important details about the user so as to authenticate him and to prevent fraudulent transaction.  
Profile Management: 
For managing user profiles, a database will be maintained which would comprise of the details filled in the registration form. The database would also store the id and password of the user for login authentication.  
The mapping of database with the objects will be done using JPA. We will set up Hibernate using spring context to save and retrieve data.   
Selling a book: 
A registered user can put up a book for sale at some desired price. The details of the book to be sold would include title, authors, ISBN, pictures, condition, description, and price. The user can also give away the book for free.  
Post for book requirement: 
Any user who wants to buy a book can post the requirement on the website. The user needs to post including details such as title, authors, ISBN, pictures, condition, description, and the price he is willing to pay for the book. 
Search book: 
The user can look for the book he wants using keywords such as the title, author, ISBN. The selected book will be stored temporarily in database for the user to review at a later stage.  
We will be using spring validation annotations and tag libraries to display errors to the users in case of some incomplete or wrong information. 
Buy, Sell or Bid: 
The user can purchase the book he needs as per the listed price or he can even offer the seller to sell the book at some lower price. The seller can further accept the offer and give away the book at offered price or can decline the offer.  
We will be providing security to our application using spring security xml and filter that is also a part of spring security xml. This will allow us to implement URL based security and restrict user according to their roles. 
Feedback: 
Lastly, once the transaction has been done, users will be prompted to fill up the feedback form for the buyer and seller both. They will be offered greater visibility and preference in searched results if the rating for them is high.  
We can optionally ask users to rate our application too. 
All these interfaces will be designed using spring MVC where users can make all the   decisions and perform actions on the data. We will be using message properties file to display custom messages to user along with cascading style sheets to improve look and feel of the application and to make our application attractive and interactive.
					
					</pre></div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="sap_tabs">	
				     <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
						  <ul class="resp-tabs-list">
						  	  <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>About Product</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>Product sales</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-2" role="tab"><span>Reviews</span></li>
							  <div class="clear"></div>
						  </ul>				  	 
							<div class="resp-tabs-container">
							    <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
									<div class="facts">
									  <ul class="tab_list">
									  	<li><a href="#">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat</a></li>
									  	<li><a href="#">augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigatione</a></li>
									  	<li><a href="#">claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica</a></li>
									  	<li><a href="#">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</a></li>
									  </ul>           
							        </div>
							     </div>	
							      <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts">
									  <ul class="tab_list">
									    <li><a href="#">augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigatione</a></li>
									  	<li><a href="#">claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica</a></li>
									  	<li><a href="#">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</a></li>
									  </ul>           
							        </div>
							     </div>	
							      <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-2">
									<ul class="tab_list">
									  	<li><a href="#">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat</a></li>
									  	<li><a href="#">augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigatione</a></li>
									  	<li><a href="#">claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores leg</a></li>
									  	<li><a href="#">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</a></li>
									  </ul>      
							     </div>	
							 </div>
					      </div>
					 </div>
					 <script src="${pageContext.request.contextPath}/resources/js/easyResponsiveTabs.js" type="text/javascript"></script>
					    <script type="text/javascript">
						    $(document).ready(function () {
						        $('#horizontalTab').easyResponsiveTabs({
						            type: 'default', //Types: default, vertical, accordion           
						            width: 'auto', //auto or any width like 600px
						            fit: true   // 100% fit in a container
						        });
						    });
						   </script>
						
	</div>
</section>
</div>
</body>
</html>