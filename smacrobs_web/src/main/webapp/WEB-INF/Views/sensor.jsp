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
		<title>Sense Fence | EaseMySleep</title>
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
	<body class="senso">
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
									<li><a href="/fitbit">Fitbit</a></li>
									<li><a href="/senso">Sense Fence</a></li>
									<li><a href="/data">Data Analytics</a></li>
									<li><a href="/contact">Contact Us</a></li>
								</ul>
							</li>
						</ul>
					</nav>
				</header>

			<!-- Main -->
				<article id="main">

					<header class="special container">
						<span class="icon fa-bar-chart"></span>
						<h2><strong>Sense Fence</strong></h2>
						<p>Sense Fence tracks your environment for you!</p>
					</header>

					<!-- One -->
						<section class="wrapper style4 container">

							<div class="row 150%">
								<div class="8u 12u(narrower)">

									<!-- Content -->
										<div class="content">
											<section>
												<a href="#" class="image featured"><img src="images/sensorTag.jpg" alt="" /></a>
												<header>
													<h3>Sensor Tag CC2650</h3>
												</header>
												<p>The multi-standard SensorTag, based on the SimpleLink ultra-low power 
												CC2650 wireless MCU, supports development for Bluetooth Smart, 
												6LoWPAN and ZigBee. 
												This SensorTag has a unique feature that allows developers to change 
												between different 2.4 GHz technologies by simply loading new software 
												images directly from the SensorTag app over-the-air.</p>
											</section>
										</div>

								</div>
								<div class="4u 12u(narrower)">

									<!-- Sidebar -->
										<div class="sidebar">
											<section>
												<header>
													<h3>Magna Feugiat</h3>
												</header>
												<p>The SimpleLink&trade; SensorTag allows quick and easy prototyping of IoT devices. 
												It just works – connect your sensor solution to the cloud in three minutes.</p>
												<footer>
													<ul class="buttons">
														<li><a href="https://store.ti.com/Basket.aspx" class="button small">Buy Now</a></li>
													</ul>
												</footer>
											</section>

											<section>
												<a href="#" class="image featured"><img src="images/pic04.jpg" alt="" /></a>
												<header>
													<h3>Amet Lorem Tempus</h3>
												</header>
												<p>Sed tristique purus vitae volutpat commodo suscipit amet sed nibh. Proin a ullamcorper sed blandit. Sed tristique purus vitae volutpat commodo suscipit ullamcorper sed blandit lorem ipsum dolore.</p>
												<footer>
													<ul class="buttons">
														<li><a href="#" class="button small">Buy Now</a></li>
													</ul>
												</footer>
											</section>
										</div>

								</div>
							</div>
						</section>

					<!-- Two -->
						<section class="wrapper style1 container special">
							<div class="row">
								<div class="4u 12u(narrower)">

									<section>
										<header>
											<h3>Light</h3>
										</header>
										<p>Sense Fence monitors your bedroom's lighting when you sleep and 
										will let you know if there were any disturbances!</p>
									</section>

								</div>
								<div class="4u 12u(narrower)">

									<section>
										<header>
											<h3>Temperature</h3>
										</header>
										<p>Sense Fence tracks your bedroom temperature for you!</p>
									</section>

								</div>
								<div class="4u 12u(narrower)">

									<section>
										<header>
											<h3>Humidity</h3>
										</header>
										<p>Sense Fence compares your bedroom humidity with your location's humidity and gives you more insights.</p>
									</section>

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
