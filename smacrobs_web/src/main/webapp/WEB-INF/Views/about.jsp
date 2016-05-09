<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Twenty by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html lang="en">
	<head>
		<title>About Us | EaseMySleep</title>
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico"  type="image/x-icon" />
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<!--[if lte IE 8]><script src="<%=request.getContextPath()%>/home/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/ie9.css" /><![endif]-->
		<link rel="stylesheet" href="https://i.icomoon.io/public/temp/6271e1568c/UntitledProject/style.css">
		
		
	</head>
	<body class="about">
		<div id="page-wrapper">

			<!-- Header -->
				<header id="header">
					<h1 id="logo"><a href="<%=request.getContextPath()%>">EaseMySleep <span>by SMACROBS</span></a></h1>
					<nav id="nav">
						<ul>
							<li class="current"><a href="<%=request.getContextPath()%>">Home</a></li>
								<li class="submenu">
								<a href="#">What's More?</a>
								<ul>
									<li><a href="/smacrobs/fitbit">Fitbit</a></li>
									<li><a href="/smacrobs/senso">Sense Fence</a></li>
									<li><a href="/smacrobs/data">Data Analytics</a></li>
									<li><a href="/smacrobs/contact">Contact Us</a></li>
									<li><a href="/smacrobs/about">About Us</a></li>
								</ul>
							</li>
						</ul>
					</nav>
				</header>

			<!-- Main -->
				<article id="main">

					<header class="special container">
						<span class="icon fa-users"></span>
						<h2><strong>About Us</strong></h2>
						<p>Meet the team which will help you sleep better!</p>
					</header>

					<!-- One -->
						<section class="">

									<!-- Content -->
											<div class="row">
											<div class="2u"></div>
      											<div class="2u">
													 <p class="p-center"><img class="circle-img p-center" height="150" src="images/srini.jpg" />Srinidhi<br/>Full Stack Developer</p>
												</div>
												<div class="2u">
													 <p class="p-center"><img class="circle-img p-center" width="150" height="150" src="images/uday.jpeg" />Uday Sagar<br/>Backend Developer</p>
												</div>
												<div class="2u">
													 <p class="p-center"><img class="circle-img p-center" width="150" height="150" src="images/neha.jpg" />Neha <br/>FrontEnd Developer</p>
												</div>
												<div class="2u">
													 <p class="p-center"><img class="circle-img p-center" width="150" height="150" src="images/ceeeni.jpg" />Sreenivaasan <br/>Android Developer</p>
												</div>
										</div>
						</section>	
				</article>

			<!-- Footer -->
				<footer id="footer">
					<ul class="copyright">
						<li>&copy; <strong>SMACROBS</strong> 2015-2016</li><li>Design: <a href="http://html5up.net">TWENTY By HTML5 UP</a></li>
					</ul>
				</footer>

		</div>

		<!-- Scripts -->
			<script src="<%=request.getContextPath()%>/home/js/jquery.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/jquery.dropotron.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/jquery.scrolly.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/jquery.scrollgress.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/skel.min.js"></script>
			<script src="<%=request.getContextPath()%>/home/js/util.js"></script>
			<!--[if lte IE 8]><script src="<%=request.getContextPath()%>/home/js/ie/respond.min.js"></script><![endif]-->
			<script src="<%=request.getContextPath()%>/home/js/main.js"></script>

	</body>
</html>