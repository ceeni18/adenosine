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
<title>Fitbit | EaseMySleep</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/images/favicon.ico"
	type="image/x-icon" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<!--[if lte IE 8]><script src="<%=request.getContextPath()%>/home/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/home/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/ie8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="<%=request.getContextPath()%>/home/css/ie9.css" /><![endif]-->
<link rel="stylesheet"
	href="https://i.icomoon.io/public/temp/6271e1568c/UntitledProject/style.css">
</head>
<body class="fitbit">
	<div id="page-wrapper">

		<!-- Header -->
		<header id="header">
			<h1 id="logo">
				<a href="<%=request.getContextPath()%>">EaseMySleep <span>by
						SMACROBS</span></a>
			</h1>
			<nav id="nav">
				<ul>
					<li class="current"><a href="<%=request.getContextPath()%>/">Home</a></li>
					<li class="submenu"><a href="#">What's More?</a>
						<ul>
							<li><a href="/fitbit">Fitbit</a></li>
							<li><a href="/senso">Sense Fence</a></li>
							<li><a href="/data">Data Analytics</a></li>
							<li><a href="/contact">Contact Us</a></li>
							<li><a href="/about">About Us</a></li>
						</ul></li>
				</ul>
			</nav>
		</header>

		<!-- Main -->
		<article id="main">

			<header class="special container">
				<span class="icon fa-trophy"></span>
				<h2>
					Behold the <strong>Fitbit</strong>
				</h2>
				<p>How was your sleep last night?</p>
			</header>

			<!-- One -->
			<section class="wrapper style4 container">

				<div class="row 150%">
					<div class="4u 12u(narrower)">

						<!-- Sidebar -->
						<div class="sidebar">
							<section>
								<header>
									<h3>Sleep Tracking</h3>
								</header>
								<p>Fitbit tracks your sleep and classifies your sleep time
									as 'Asleep', 'Restless' and 'Awake'. Sleep Efficiency is
									calculated with these different sleep stages.</p>
							</section>

							<section>
								<img src="images/blaze.jpg"
									title="Image Courtesy: https://www.fitbit.com/"
									alt="Fitbit Blaze" />
								<header>
									<h3>Food and Water Logs</h3>
								</header>
								<p>There are no automatic tracking of food and water intake.
									Instead, Fitbit uses keys in the data through the app to
									estimate Calorie values.</p>
								<footer>
									<ul class="buttons">
										<li><a href="https://www.fitbit.com/store"
											class="button small">Buy Now</a></li>
									</ul>
								</footer>
							</section>
						</div>

					</div>
					<div class="8u 12u(narrower) important(narrower)">

						<!-- Content -->
						<div class="content">
							<section>
								<img src="images/sleep.jpg"
									title="Image Courtesy: Our very own Android Developer"
									alt="Sample Sleep Graph" />
								<header>
									<h3>Activity Tracking</h3>
								</header>
								<p>Fitbit uses 3-axis accelerometer and altimeter to track
									your movements. Data from Accelerometer converts to steps and
									altimeter converts to climbs. Miles and calories burnt are
									estimated from steps and climbs.</p>
								<header>
									<h3>Heart Rate</h3>
								</header>
								<p>Fitbit uses optical heart rate monitor to capture pulse
									rate and estimates resting heart rate using Purepulse&trade;
									technology.</p>
								<p>When your heart beats, your capillaries expand and
									contract based on blood volume changes. PurePulse&trade; LED
									lights on your tracker reflect onto the skin to detect blood
									volume changes and finely tuned algorithms are applied to
									measure heart rate automatically and continuously.</p>
							</section>
						</div>

					</div>
				</div>
			</section>

			<section class="wrapper style1 container special">
				<div class="row">
					<div class="4u 12u(narrower)">

						<section>
							<span class="icon featured fa-check-square-o"></span>
							<header>
								<h3>Fitbit Story #1</h3>
							</header>
							<p>Fitbit's Resting Heart Rate is the number of beats per
								minute when you are static. Fitbit users has a resting heart
								rate of 50 - 90 beats per minute.</p>
							<footer>
								<ul class="buttons">
									<li><a
										href="https://blog.fitbit.com/what-your-resting-heart-rate-can-reveal-about-your-health/"
										class="button small">Learn More</a></li>
								</ul>
							</footer>
						</section>

					</div>
					<div class="4u 12u(narrower)">

						<section>
							<span class="icon featured fa-check-square-o"></span>
							<header>
								<h3>Fitbit Story #2</h3>
							</header>
							<p>Find out the favorite activities of Fitbit users across
								the world. Running is the most favorite, followed by strength
								training for men in USA and elliptical work-outs for women in
								USA.</p>
							<footer>
								<ul class="buttons">
									<li><a href="https://www.fitbit.com/activity-index"
										class="button small"> Learn More</a></li>
								</ul>
							</footer>
						</section>

					</div>
					<div class="4u 12u(narrower)">

						<section>
							<span class="icon featured fa-check-square-o"></span>
							<header>
								<h3>Fitbit Story #3</h3>
							</header>
							<p>Do you San Francisco is the 2nd most active city for
								Fitbit users? Guess which one's the first?</p>
							<footer>
								<ul class="buttons">
									<li><a
										href="http://www.usatoday.com/pages/interactives/sponsor-story/fitbit-active-cities/"
										class="button small"> Learn More</a></li>
								</ul>
							</footer>
						</section>

					</div>
				</div>
			</section>

		</article>

		<!-- Footer -->
		<footer id="footer">
			<ul class="copyright">
				<li>&copy; <strong>SMACROBS</strong> 2015-2016
				</li>
				<li>Design: <a href="http://html5up.net">TWENTY By HTML5 UP</a></li>
			</ul>
		</footer>

	</div>

	<!-- Scripts -->
	<script src="<%=request.getContextPath()%>/home/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/home/js/jquery.dropotron.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/home/js/jquery.scrolly.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/home/js/jquery.scrollgress.min.js"></script>
	<script src="<%=request.getContextPath()%>/home/js/skel.min.js"></script>
	<script src="<%=request.getContextPath()%>/home/js/util.js"></script>
	<!--[if lte IE 8]><script src="<%=request.getContextPath()%>/home/js/ie/respond.min.js"></script><![endif]-->
	<script src="<%=request.getContextPath()%>/home/js/main.js"></script>

</body>
</html>
