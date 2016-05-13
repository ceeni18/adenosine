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
<title>Data Analytics | EaseMySleep</title>
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
<body class="data">
<div id="google_translate_element"></div><script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE, gaTrack: true, gaId: 'UA-77712704-1'}, 'google_translate_element');
}
</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
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
				<span class="icon fa fa-cogs"></span>
				<h2>
					Data <strong>Analytics</strong>
				</h2>
				<p>To reveal the hidden secrets of your data.</p>
			</header>

			<!-- One -->
			<section class="wrapper style4 container">

				<!-- Content -->
				<div class="content">
					<section>
						<img style="margin: 0 auto; display: block" width="75%"
							src="images/data.jpg" alt="Data Analytics"
							title="Image Courtesy: http://hostedrecords.com/services/data-analytics/" />
						<br />
						<br />
						<p>Data Ingestion is where we collect by importing data from
							the devices - Fitbit and Sense Fence. We process the data and
							store it as collections in the database. This sometimes involves
							merging individual files and formatting them to fit into a large
							document. We validate, prioritize the sources for proessing and
							validate results.</p>
						<p>Data Visualization is the another component that helps us
							to visualize the data we import. Unlike a singular chart or graph
							data, visualization tools help us visualize the data
							interconnected with time. This time series is often helpful to
							find out ambiguities in patterns of data. We have used Highcharts
							for data representation</p>
						<p>Highcharts is a JavaScript based charting library, which
							offers interactive charts for web applications. It offers a
							variety of chart types such as line, area, column, etc. It
							supports multiple axes, exporting features among many other
							features.</p>
					</section>
				</div>

			</section>

			<!-- Two -->
			<section class="wrapper style1 container special">
				<div class="row">
					<div class="4u 12u(narrower)">

						<section>
							<span class="icon featured fa-check-square-o"></span>
							<header>
								<h3>Big Data Fact #1</h3>
							</header>
							<p>The world is growing at a breathtaking pace, from 2
								billion objects in 2006 to a projected 200 billion by 2020. That
								will be around 26 smart objects for every human being on Earth!
								We need a strong data engine to understand this data!</p>
						</section>

					</div>
					<div class="4u 12u(narrower)">

						<section>
							<span class="icon featured fa-check-square-o"></span>
							<header>
								<h3>Big Data Fact #2</h3>
							</header>
							<p>By 2025, the total global worth of IoT technology with
								data analytics could be as high as USD 6.2 trillion. Most of
								that value comes from devices in the domain of health care (USD
								2.5 trillion) and manufacturing (USD 2.3 trillion).</p>
						</section>

					</div>
					<div class="4u 12u(narrower)">

						<section>
							<span class="icon featured fa-check-square-o"></span>
							<header>
								<h3>Big Data Fact #3</h3>
							</header>
							<p>IOT and Data analytics go together and they are spread
								across various domains - 40% in business and manufacturing, 30%
								in healthcare, 8.3% in retail and 7.7% in security.</p>
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
