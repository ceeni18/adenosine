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

<style>
.ig-b- {
	display: inline-block;
}

.ig-b- img {
	visibility: hidden;
}

.ig-b-:hover {
	background-position: 0 -60px;
}

.ig-b-:active {
	background-position: 0 -120px;
}

.ig-b-v-24 {
	width: 137px;
	height: 24px;
	background:
		url(//badges.instagram.com/static/images/ig-badge-view-sprite-24.png)
		no-repeat 0 0;
}

@media only screen and (-webkit-min-device-pixel-ratio: 2) , only screen and
		(min--moz-device-pixel-ratio: 2) , only screen and
		(-o-min-device-pixel-ratio: 2 / 1) , only screen and
		(min-device-pixel-ratio: 2) , only screen and (min-resolution: 192dpi)
		, only screen and (min-resolution: 2dppx) {
	.ig-b-v-24 {
		background-image:
			url(//badges.instagram.com/static/images/ig-badge-view-sprite-24@2x.png);
		background-size: 160px 178px;
	}
}
</style>

</head>
<body class="about">
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
				<span class="icon fa-users"></span>
				<h2>
					<strong>About Us</strong>
				</h2>
				<p>Meet the team which will help you sleep better!</p>
			</header>

			<!-- One -->
			<section class="">

				<!-- Content -->
				<div class="row">
					<div class="2u"></div>
					<div class="2u">
						<p class="p-center">
							<img class="circle-img p-center" height="150"
								src="images/srini.jpg" />Srinidhi<br />Full Stack Developer<br />
							<a href="https://www.linkedin.com/in/srinidhisrinivasaraghavan"
								style="text-decoration: none;"><span
								style="font: 80% Arial, sans-serif; color: #0783B6;"><img
									src="https://static.licdn.com/scds/common/u/img/webpromo/btn_in_20x15.png"
									width="20" height="15"
									alt="View Srinidhi Srinivasa Raghavan's LinkedIn profile"
									style="vertical-align: middle;" border="0"></span></a><br /> <a
								class="github-button"
								href="https://github.com/srinidhisrinivasaraghavan"
								aria-label="Follow @srinidhi on GitHub">Follow @srinidhi</a>
						</p>
					</div>
					<div class="2u">
						<p class="p-center">
							<img class="circle-img p-center" width="150" height="150"
								src="images/uday.jpeg" />Uday Sagar<br />Backend Developer<br />
							<a href="https://www.linkedin.com/in/udaysagar"
								style="text-decoration: none;"><span
								style="font: 80% Arial, sans-serif; color: #0783B6;"><img
									src="https://static.licdn.com/scds/common/u/img/webpromo/btn_in_20x15.png"
									width="20" height="15"
									alt="View Uday Sagar Shiramshetty's LinkedIn profile"
									style="vertical-align: middle;" border="0"></span></a><br /> <a
								class="github-button" href="https://github.com/udaysagar2177"
								aria-label="Follow @uday on GitHub">Follow @uday</a>
						</p>
					</div>
					<div class="2u">
						<p class="p-center">
							<img class="circle-img p-center" width="150" height="150"
								src="images/neha.jpg" />Neha <br />FrontEnd Developer<br /> <a
								href="https://www.linkedin.com/in/nehaviswanathan"
								style="text-decoration: none;"><span
								style="font: 80% Arial, sans-serif; color: #0783B6;"><img
									src="https://static.licdn.com/scds/common/u/img/webpromo/btn_in_20x15.png"
									width="20" height="15"
									alt="View Neha Viswanathan's LinkedIn profile"
									style="vertical-align: middle;" border="0"></span></a><br /> <a
								class="github-button" href="https://github.com/neha-viswanathan"
								aria-label="Follow @neha on GitHub">Follow @neha</a>
						</p>
					</div>
					<div class="2u">
						<p class="p-center">
							<img class="circle-img p-center" width="150" height="150"
								src="images/ceeeni.jpg" />Sreenivaasan <br />Android Developer<br />
							<a href="https://www.linkedin.com/in/ceeeni"
								style="text-decoration: none;"><span
								style="font: 80% Arial, sans-serif; color: #0783B6;"><img
									src="https://static.licdn.com/scds/common/u/img/webpromo/btn_in_20x15.png"
									width="20" height="15"
									alt="View Sreenivaasan Gajapathy's LinkedIn profile"
									style="vertical-align: middle;" border="0"></span></a><br /> <a
								class="github-button" href="https://github.com/ceeeni"
								aria-label="Follow @ceeeni on GitHub">Follow @ceeeni</a>
						</p>
					</div>
				</div>
			</section>
		</article>

		<!-- Footer -->
		<footer id="footer">
			<br /> <a href="https://www.instagram.com/smacrobs/?ref=badge"
				class="ig-b- ig-b-v-24"><img
				src="//badges.instagram.com/static/images/ig-badge-view-24.png"
				alt="Instagram" /></a> <br /> <a href="https://twitter.com/smacrobs"
				class="twitter-follow-button" data-show-count="false"
				data-size="large">@smacrobs</a>
			<script>
				!function(d, s, id) {
					var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
							.test(d.location) ? 'http' : 'https';
					if (!d.getElementById(id)) {
						js = d.createElement(s);
						js.id = id;
						js.src = p + '://platform.twitter.com/widgets.js';
						fjs.parentNode.insertBefore(js, fjs);
					}
				}(document, 'script', 'twitter-wjs');
			</script>
			<br /> 
			<a data-pin-do="buttonFollow" href="https://www.pinterest.com/smacrobs/">smacrobs</a>
			<br /> <br />
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
	<script async defer src="https://buttons.github.io/buttons.js"></script>
	<script async defer src="//assets.pinterest.com/js/pinit.js"></script>
</body>
</html>